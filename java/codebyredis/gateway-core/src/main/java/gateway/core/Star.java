package gateway.core;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;

import gateway.core.config.Alert;
import gateway.core.config.Function;
import gateway.core.config.Ioinfo;
import gateway.core.imp.ClientTcp;
import gateway.core.mapper.AlertData;
import gateway.core.mapper.FunctionMapper;
import gateway.core.mapper.IoinfoMapper;
import gateway.core.mqtt.Cmd;
import gateway.core.mqtt.MyMqtt;
import gateway.core.mqtt.Result;
import gateway.core.mybatis.MySql;
import gateway.core.util.Tool;

public class Star {
	public static Map<String,String> takes = new HashMap<String,String>();
	public static Map<String,Long> takesTime = new HashMap<String,Long>();
	public static Map<String,Result> mapResult = new HashMap<String,Result>();
	
	public static Map<String,String> db = new HashMap<String,String>(); 
	public static Map<String,Alert> alertdb = new HashMap<String,Alert>();
	
	public static String STOREID = "1000";
	public static MyMqtt mqtt = null;
	public static ClientTcp cp = new ClientTcp();
	public static Gson gson = new Gson();
	public static void main(String[] args) {
		//=======================
		 MySql.init();
		 Star star = new Star();
		 star.mqttRead();//读取设备命令
		 star.init();
		 //======================
		 star.monitor(); //变量监控
	}
	
	/**
	 * 
	 */
    public void init() {
		AlertData alertData = MySql.getSqlSession().getMapper(AlertData.class);
		List<Alert> ls = alertData.getList();
		for(Alert ac : ls) { 
			alertdb.put(ac.deviceid+ac.dataAddr+ac.value,ac);
		}
	}
	
	/**
	 * mqtt 中读取命令
	 */
	public void mqttRead() {
		mqtt= new MyMqtt(new MqttCallback() { 
            public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
                // TODO 自动生成的方法存根
            	System.out.println(arg0);
            	try {
            		if(arg0.equals("deviceCmd_1000")) { 
	            		String msg = new String(arg1.getPayload());
	            		Cmd cmd  = gson.fromJson(msg, Cmd.class); 
	            		String id	   	= cmd.id; 
	            		int type	   	= cmd.type; 
	            		String funid   	= cmd.cmd+"";
	            		String data	   	= cmd.cmdParam; 
	            		Long missionId	= cmd.cmdId;  
	            		if( 
	            			funid!=null
	            			&&id!=null
	            			&&type!=0
	            			&&data!=null
	            			&&missionId!=null) { 
	            			//System.out.println(funid+"-"+ id+"-"+ type+"-"+data+"");
	            			funs(funid+"", id+"", type+"", data+"",missionId+"");
	            		} 
            		}
            	}catch (Throwable t) {
					//System.out.println("Error");
				}
            }

			@Override
			public void connectionLost(Throwable cause) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deliveryComplete(IMqttDeliveryToken token) {
				// TODO Auto-generated method stub
				
			}
        },false); 
		//System.out.println("xx");
		
		 String[] arrstr = new String[] { "deviceCmd_"+STOREID };
		 int[] arri = new int[] {0};
		 mqtt.subscribe(arrstr, arri); 
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
//				 Map<String,String> alertmassg = new HashMap();
//				 alertmassg.put("storeId", STOREID);
//				 alertmassg.put("id", io.deviceid);
//				 alertmassg.put("name", io.estimateName);
//				 alertmassg.put("type", io.type);
//				 alertmassg.put("data", at.massge);
//				 alertmassg.put("code", at.code); 
//				 mqtt.sendMessage("devalert", gson.toJson(alertmassg));
			 }
		 }
	}
	
	public void checkTime() {
		//mapResult
		if(takesTime.keySet().size()!=0)
		System.out.println("超时检查!"+takesTime.keySet().size());
		for(String str:takesTime.keySet()) {
			Long lg = new Date().getTime() - takesTime.get(str);
			System.out.println("时间"+lg);
			if((lg/1000/60) > 7) {
				
				mqtt.sendMessage("deviceCmdExcResult", gson.toJson(mapResult.get(str)));
				System.out.println("超时:"+gson.toJson(mapResult.get(str)));
				takesTime.remove(str);//超时
				mapResult.remove(str);
				//takes.remove(str);
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
				r.storeId = Long.parseLong(STOREID);
				r.message = at.massge;				
				mqtt.sendMessage("deviceCmdExcResult", gson.toJson(r));
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
	 * 功能调用
	 * @param code 功能代码;
	 * @param devid 设备id / 如果设备id为空或者设备id为0 / 调用全部设备类型;
	 * @param devtype 设备类型;
	 * @param data	发送到功能的数据;
	 */
	public static void funs(String code,String devid,String devtype,String data,String missionId) {
		List<Function> functions = null;
		FunctionMapper functionMapper = MySql.getSqlSession().getMapper(FunctionMapper.class);
		 
		//System.out.println("fun:"+code+","+devid+","+devtype+","+data+","+missionId);
		
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
			System.out.println("send : "+addr+":"+data);
			cp.batchWrite(addr, data);
			String[] listens = fun.listenaddr.split(",");
			
			for(int i=0;i < listens.length;i++) {
				System.out.println(addr.deviceid+listens[i]+" xx "+missionId);
				takes.put(addr.deviceid+listens[i], missionId); 
				takesTime.put(addr.deviceid+listens[i], new Date().getTime());//超时 
				Result r = new Result();
				r.id = addr.deviceid;
				r.checkResult = 0; 
				r.cmdId = Long.parseLong(missionId);
				r.storeId = Long.parseLong(STOREID);
				r.message = "超时";	
				mapResult.put(addr.deviceid+listens[i], r);
			} 
		}
		if(functions.size()==0) {
			Result r = new Result();
			r.id = "0";
			r.checkResult 	= 0; 
			r.cmdId   		= Long.parseLong(missionId);
			r.storeId 		= Long.parseLong(STOREID);
			r.message 		= "没有找到设备!";
			mqtt.sendMessage("deviceCmdExcResult", gson.toJson(r));
		}
		
	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * 监控变量
	 */
	public void monitor() {
		IoinfoMapper ioinfoMapper =MySql.getSqlSession().getMapper(IoinfoMapper.class);
		List<Ioinfo> ios = ioinfoMapper.getList();
		ClientTcp cp = new ClientTcp(); 
		Map<String,String> isout = new HashMap<String,String>();  
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{ 
			for(Ioinfo ac : ios) { 
				 //String dd = ac.deviceid+"."+ac.parentName+"."+ac.estimateName; 
				// System.out.println(dd+":"); 
				try { 
					cp.batchRead(ac).thenAccept(s->{
						 String dbkey = ac.deviceid+"."+ac.parentName+"."+ac.estimateName;
						 //System.out.println(dbkey+":"+s); 
						 if(db.get(dbkey)==null)db.put(dbkey, "");
						 if((db.get(dbkey)+"").equals(s)) {
							 
						 }else {//变量变换
							System.out.println("变了"+dbkey+":"+s); 
							db.put(dbkey,s);
							String divid = ac.deviceid;
							String name  = ac.parentName;
							String partId = Tool.StringToId(name).substring(32);
							String key = divid+name+partId; 
							System.out.println("andkey : == "+key);
							isout.put(key, "1");  
							//报警监控
							alert(ac,s);
							//执行监控
							//task(ac,s);
						 }
						  
					}).exceptionally(ex -> {
		                ex.printStackTrace();
		                return null;
		            });
					 
					
				} catch (Throwable t) {
					//System.out.println("Error");
				} 
			}
			try { 
				checkTime();//超时检查
			}catch(Throwable t) { }
		},1000, 4000, TimeUnit.MILLISECONDS); 
		
		/*	Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{   
			//发送mqtt
			
			try { 
				Map<String,Map> heads = new HashMap<String,Map>();   
				Map<String,List<Map>> point = new HashMap<String,List<Map>>();
				for(Ioinfo ac : ios) { 
					String dbkey = ac.deviceid+"."+ac.parentName+"."+ac.estimateName;
					String divid = ac.deviceid;
					String name  = ac.parentName;
					String partId = Tool.StringToId(name).substring(32);
					String key = divid+name+partId;
					System.out.println("out : == "+key);
					if(isout.get(key)!=null&&(isout.get(key)+"").equals("1")) {
						List<Map> mls = null;
						if(point.get(key)==null) {
							mls = new ArrayList<Map>();
						}else {
							mls = point.get(key);
						}
						
						Map<String,String> map = new HashMap();
						Map<String,String> head = new HashMap();
						map.put("parentName", ac.parentName);
						map.put("estimateName", ac.estimateName);
						map.put("estimateValue",db.get(dbkey));
						mls.add(map); 
						head.put("divid", divid);
						head.put("name", name);
						head.put("partId", partId); 
						point.put(key, mls);
						heads.put(key, head); 
						isout.put(key, "0");
						
					}
					
				}
			  //String outstr = gson.toJson(outmap);
				//mqtt.sendMessage("devicePartCheckPoint", outstr);
				
				
				for(Entry<String, Map> entry : heads.entrySet()){
					
				    String mapKey = entry.getKey();
				    
				    //if(isout.get(mapKey).equals("1")) {
				    	//System.out.println("test");
				    	Map<String,Object> outmap = new HashMap<String,Object>();
					    outmap.put("storeId", STOREID);
					    outmap.put("id", heads.get(mapKey).get("divid"));
					    outmap.put("name", heads.get(mapKey).get("name"));
					    outmap.put("partId", heads.get(mapKey).get("partId"));
					    outmap.put("checkPointList", point.get(mapKey));
					    String outstr = gson.toJson(outmap);
					    //isout.put(mapKey,"0");
					    System.out.println(outstr);
					    //mqtt.sendMessage("devicePartCheckPoint", outstr);
					    //mqtt.sendMessage("deviceIo", outstr);
				    //}
				}
			}catch (Throwable t) {
				System.out.println("Error");
			} 
		},1000, 10000, TimeUnit.MILLISECONDS);
	*/
		
		
		
		
	}
}
