package gateway.core;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import gateway.core.config.Alert;
import gateway.core.config.Function;
import gateway.core.config.Ioinfo;
import gateway.core.imp.ClientTcp;
import gateway.core.mapper.FunctionMapper;
import gateway.core.mapper.IoinfoMapper;
import gateway.core.mqtt.Cmd;
import gateway.core.mqtt.Result;
import gateway.core.mybatis.MySql;
import gateway.core.redis.Config;
import redis.clients.jedis.Jedis;

public class Dbz_Star {
	
	public static Map<String,String> takes = new HashMap<String,String>();
	public static Map<String,Long> takesTime = new HashMap<String,Long>();
	public static Map<String,Result> mapResult = new HashMap<String,Result>();
	
	public static Map<String,String> db = new HashMap<String,String>(); 
	public static Map<String,Alert> alertdb = new HashMap<String,Alert>();
	public static Gson gson = new Gson();
	public static ClientTcp cp = new ClientTcp(); 
	
	
	public static void main(String arg[]) throws InterruptedException {
		/*
		 * while(true) { Result r = new Result(); r.id = "1303262303050842114"; r.cmdId
		 * = (long) 33232; r.message = "成功"; r.storeId=(long) 12323; Gson gson = new
		 * Gson(); redisWrite(gson.toJson(r)); Thread.sleep(100); }
		 */
		Dbz_Star star = new Dbz_Star();
		star.monitor();
		star.read();
	}
	//读取任务
	public static Map redisRead() {
		 Jedis jedis 	= Config.get(); 
		 String str 	= jedis.rpop("devtask");
		 Gson gson 		= new Gson();
		 //System.out.println(gson.toJson(str));
		 if(str==null||str.equals("null"))return null;
		 Map cmd 		= gson.fromJson(str, Map.class);
		 return cmd;
	}
	//读取命令
	public void read() {
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{ 
			try { 
				Gson gson 		= new Gson();
				Map cmd 		= redisRead();
				if(cmd!=null) {
					System.out.println(gson.toJson(cmd));
					Map map 		= gson.fromJson(cmd.get("cmdParam")+"", Map.class);
					String id	   	= cmd.get("id")+""; 
		    		String type	   	= cmd.get("type")+""; 
		    		String funid   	= cmd.get("cmd")+""; 
		    		String data	   	= cmd.get("cmdParam")+""; 
		    		String missionId= cmd.get("cmdId")+"";  
					if( 
		    			funid!=null
		    			&&id!=null
		    			&&type!=null
		    			&&data!=null
		    			&&missionId!=null) { 
						//System.out.println(funid+"-"+ id+"-"+ type+"-"+data+"");
		    				funs(funid+"", id+"", type+"", data+"",missionId+"");
		    		}
				}
				
		    }catch (Throwable t) { System.out.println(t.getMessage()); t.printStackTrace(); }
		},1000,1000, TimeUnit.MILLISECONDS);  
	}
	
	
	/**
	 * 功能调用
	 * @param code 功能代码;
	 * @param devid 设备id / 如果设备id为空或者设备id为0 / 调用全部设备类型;
	 * @param devtype 设备类型;
	 * @param data	发送到功能的数据;
	 */
	public static void funs(String code,String devid,String devtype,String data,String missionId) {
		List<Function> functions = null;
		FunctionMapper functionMapper = MySql.getSqlSession().getMapper(FunctionMapper.class);
		 
		System.out.println("fun:"+code+","+devid+","+devtype+","+data+","+missionId);
		
		if(devid==null||devid.length()==0||devid.equals("0")) {
			//System.out.println("fun1:"+code+","+devid+","+devtype+","+data+","+missionId);
			functions = functionMapper.getAddrFunByType(devtype, code);//获取所有设备
		}else {	
			//System.out.println("fun2:"+code+","+devid+","+devtype+","+data+","+missionId);
			functions = functionMapper.getAddrFun(devid,devtype,code);
			//System.out.println("funx:"+code+","+devid+","+devtype+","+data+","+missionId);
		}
		//System.out.println("pxl:"+functions.size());
		for(Function fun:functions) {
			Ioinfo addr = new Ioinfo();
			addr.dataAddr = fun.dataAddr;
			addr.dataModel = fun.dataModel;
			addr.ip = fun.ip;
			addr.deviceid = fun.deviceid;
			addr.port = fun.port;
			addr.protocal = fun.protocal;
			System.out.println("send : "+gson.toJson(addr)+"==:::==="+data);
			cp.batchWrite(addr, data);
			String[] listens = fun.listenaddr.split(",");
			
			for(int i=0;i < listens.length;i++) {
				System.out.println(addr.deviceid+listens[i]+" xx "+missionId);
				takes.put(addr.deviceid+listens[i], missionId); 
				/*
				 * takesTime.put(addr.deviceid+listens[i], new Date().getTime());//超时 Result r =
				 * new Result(); r.id = addr.deviceid; r.checkResult = 0; r.cmdId =
				 * Long.parseLong(missionId); //r.storeId = Long.parseLong(STOREID); r.message =
				 * "超时"; //mapResult.put(addr.deviceid+listens[i], r);
				 */			} 
		}
		
		if(functions.size()==0) {
			Result r = new Result();
			r.id = "0";
			r.checkResult 	= 0; 
			r.cmdId   		= Long.parseLong(missionId);
			//r.storeId 		= Long.parseLong(STOREID);
			r.message 		= "没有找到设备!";
			//mqtt.sendMessage("deviceCmdExcResult", gson.toJson(r));
		}
		
	}
	/**
	 * 报警反馈
	 */
	public void alert(Ioinfo io,String value) {
		 String alertkey = io.deviceid+io.dataAddr+value;
		 
		 if(alertdb.get(alertkey)!=null) {//触发报警
			 System.out.println("alert :" +alertkey);
			 Alert at = alertdb.get(alertkey); 
			 System.out.println("alert====:" +alertkey);
			 if(task(io,value,at)) { //是否是执行反馈
				 //mqtt.sendMessage("devalert", gson.toJson(alertmassg));
				 
				 Map<String,String> alertmassg = new HashMap();
				 //alertmassg.put("storeId", STOREID);
				 alertmassg.put("id", io.deviceid);
				 alertmassg.put("name", io.estimateName);
				 alertmassg.put("type", io.type);
				 alertmassg.put("data", at.massge);
				 alertmassg.put("code", at.code); 
				 rpush("devalert",gson.toJson(alertmassg));
//				 mqtt.sendMessage("devalert", gson.toJson(alertmassg));
			 }
		 }
	}
	/**
	 * 执行进程反馈
	 * takes.put(addr.deviceid+fun.listenaddr, missionId);
	 * @return 
	 */
	public boolean task(Ioinfo io,String value,Alert at) {
		System.out.println("xxf:"+io.deviceid+io.dataAddr);
		String comm = takes.get(io.deviceid+io.dataAddr)+"";
		System.out.println("taskid:"+comm); 
		if(comm!=null && (!comm.equals("null")) ) {
			if(at!=null) {  
				Result r = new Result();
				r.id = io.deviceid;
				r.checkResult = (Integer.parseInt(value)==2?0:1); 
				r.cmdId = Long.parseLong(comm);
				//r.storeId = Long.parseLong(STOREID);
				r.message = at.massge;				
				//mqtt.sendMessage("deviceCmdExcResult", gson.toJson(r));
				rpush("taskans",gson.toJson(r));
				if(at.command.equals("over")) { 
					//System.out.println("over - ");
					takesTime.remove(io.deviceid+io.dataAddr);//超时
					mapResult.remove(io.deviceid+io.dataAddr);
					takes.remove(io.deviceid+io.dataAddr);
				}
			}else {
				takesTime.remove(io.deviceid+io.dataAddr);//超时
				mapResult.remove(io.deviceid+io.dataAddr);
				takes.remove(io.deviceid+io.dataAddr);
			}
			return false;
		}
		return true;
	}
	/**
	 * 监控变量
	 */
	public void monitor() { 
		IoinfoMapper ioinfoMapper =MySql.getSqlSession().getMapper(IoinfoMapper.class);
		List<Ioinfo> ios = ioinfoMapper.getList();
		Map<String,String> isout = new HashMap<String,String>();  
		Map map = new HashMap<String,String>();
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{ 
			
			for(Ioinfo ac : ios) {try { 
				//System.out.println(ac.dataAddr+"."+ac.parentName+"."+ac.estimateName);
				cp.batchRead(ac).thenAccept(s->{
					String dbkey = ac.deviceid+"."+ac.parentName+"."+ac.estimateName; 
					map.put(ac.parentName+"."+ac.estimateName, s); 
					
					if(db.get(dbkey)==null)db.put(dbkey, "");
					if((db.get(dbkey)+"").equals(s)) {
						
					}else {//变量变换
						db.put(dbkey,s);
						System.out.println(dbkey+":"+s);
						//报警监控
						alert(ac,s);
					}
					
				});
			} catch (Throwable t) { System.out.println(t.getMessage());  }}
			try { 
				set("devstate",new Gson().toJson(map));
			}catch (Throwable t) { System.out.println(t.getMessage());  }
		},1000, 4000, TimeUnit.MILLISECONDS);  
	}
	public static void rpush(String k,String r) {
		 Jedis jedis 	= Config.get(); 
		 jedis.rpush(k,r);
	} 
	public static void set(String k,String r) {
		 Jedis jedis 	= Config.get(); 
		 jedis.set(k, r);
	}
	
}
