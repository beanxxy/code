

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import gateway.core.Server;
import gateway.core.config.AddressConfig;
import gateway.core.config.Alert;
import gateway.core.config.ServerConfig;
import gateway.core.imp.ClientTcp;
import gateway.core.imp.ServerHttp;
import gateway.core.mapper.AlertData;
import gateway.core.mapper.DevAddress;
import gateway.core.mapper.DevServer;
import gateway.core.mybatis.MySql;
import gateway.core.redis.Config;
import redis.clients.jedis.Jedis;

public class Star_test {
	public static Map<String,String> takes = new HashMap<String,String>();
	public static Map<String,String> db = new HashMap<String,String>(); 
	public static Map<String,String> alertdb = new HashMap<String,String>();
	public static void log(String strlog) {
		System.out.println(new Date().toGMTString()+":"+strlog);
		//Jedis jedis = Config.get();
		//if(jedis.llen("gateway:device:state:execute-log-debug") > 10000) jedis.rpop("gateway:device:state:execute-log-debug");
		//jedis.lpush("gateway:device:state:execute-log-debug",strlog); 
		//jedis.close();
		
	}
	public static void main_(String[] args) {
		//Consumer<? super T> action
		//CompletableFuture.supplyAsync(()->"Hello");
		AlertData alerter = MySql.session.getMapper(AlertData.class);
		List<Alert> als	  = alerter.getList();
		for(Alert at:als) {
			alertdb.put(at.deviceid+at.dataAddr+at.value, at.massge);
		}
		
		
		// 接口服务
		DevServer devser = MySql.session.getMapper(DevServer.class);
		List<ServerConfig> sls = devser.getServer();
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		Server server = new ServerHttp();
		for(ServerConfig sc:sls) {
			server.bind(sc);
			map.put(sc.dataAddr+sc.port,sc.type);
			log("open"+sc.toString());
		}
		server.Accept(http->{
			 	//System.out.println("收到信息!"+map.toString());
				//System.out.println(map.get(http.url+http.port));
				//System.out.println(http.url);
				//System.out.println(http.port);
				String type = map.get(http.url+http.port)+"";
				String data = http.data;
				log(data);
				Gson gson = new Gson();
				Map datamap = gson.fromJson(data, Map.class);
				String devid = datamap.get("deviceId")+""; 
				String missionId = datamap.get("missionId")+""; 
				String idata = datamap.get("data")+""; 
				if(idata==null||idata==""||idata.equals("null")) idata="1"; 
				DevAddress devaddr = MySql.session.getMapper(DevAddress.class);
				List<AddressConfig> ls =  null;
				if(Integer.parseInt(devid)==0) {
					ls = devaddr.getAddrFunAll(Integer.parseInt(type));
				}else {
					ls = devaddr.getAddrFun(Integer.parseInt(devid),Integer.parseInt(type));
				} 
				ClientTcp cp = new ClientTcp();
				//System.out.println(type);
				//System.out.println(devid);00
				//System.out.println(type); 
				
				for(AddressConfig ac : ls) {
					 log(ac.toString()+"==="+idata);
					//System.out.println(ac.toString()+"==="+idata);
					takes.put(ac.deviceId+ac.massge, missionId);
					//log(ac.toString()+"==="+idata);
					//System.out.println(ac.deviceId+ac.massge);
					cp.batchWrite(ac, idata);
				} 
				//type devid
				//System.out.println(http.url);
			}
		); 
		//Star.devDB();
		
		//Server.future.
		//System.out.println("over");
	}
	
	
	
	
	
	
	
	
	
	//从mysql中读取具体的数据进行监听
	public static void devDB() {
		// 数据采集启动 
		DevAddress devaddr = MySql.session.getMapper(DevAddress.class);
		List<AddressConfig> ls =  devaddr.getAddrDB();
		ClientTcp cp = new ClientTcp();
		//int it = 1; 
			//System.out.println("开始"+ls.size());
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{  
			for(AddressConfig ac : ls) { 
				try { 
					cp.batchRead(ac).thenAccept(s->{ 
						 //System.out.println(Thread.currentThread().getName()); 
						 //System.out.println("----"+ac.toString());
						 Gson gson = new Gson();
						 Map<String,String> map = new HashMap();
						 map.put("deviceId", ac.deviceId);
						 map.put("parentName", ac.parentName);
						 map.put("estimateName", ac.estimateName);
						 map.put("estimateValue", s);
						 map.put("datatime", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date())); 
						  
						 //========================； 
						 //System.out.println("SSs:"+s); 
						 String sjosn = gson.toJson(map); 
						 Jedis jedis1 = Config.get();  
						 
						//报警==at.deviceid+at.dataAddr+at.value
						 String alertkey = ac.deviceId+ac.dataAddr+s;
						 if(alertdb.get(alertkey)!=null) {
							 String message = alertdb.get(alertkey);
							 Map<String,String> alertmassg = new HashMap();
							 alertmassg.put("deviceId", ac.deviceId);
							 alertmassg.put("parentName", ac.parentName);
							 alertmassg.put("estimateName", ac.estimateName);
							 alertmassg.put("message",message); 
							 alertmassg.put("datatime", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));  
							 jedis1.lpush(Config.key+":historical-alert",gson.toJson(alertmassg));  
						 }
						 //=====================================
						 String dbkey = ac.deviceId+"."+ac.parentName+"."+ac.estimateName;
						 if(db.get(dbkey)==null)db.put(dbkey, "");
						 if((db.get(dbkey)+"").equals(s)) {
							 
						 }else {
							 if(jedis1.llen(Config.key+":historical-data") > 10000) jedis1.rpop(Config.key+":historical-data");
							 jedis1.lpush(Config.key+":historical-data",sjosn);  
							 db.put(dbkey,s);
							 log(sjosn);
						 }
						 //jedis1.
						 jedis1.close();
						 //takes.put(ac.deviceId+ac.type+ac.massge, missionId); 
						 //任务回执
						 if(Star_test.takes.get(ac.deviceId+ac.dataAddr)!=null&&!s.equals("0")) { 
							 //System.out.println("VRVDFDFDFDF");
							 Map<String,String> tstate = new HashMap();
							 tstate.put("deviceId", ac.deviceId);
							 tstate.put("missionId", Star_test.takes.get(ac.deviceId+ac.dataAddr));
							 if(s.equals("1")) {
								 tstate.put("code","0000");
							 }else {
								 tstate.put("code","2001");
							 } 
							 tstate.put("datatime", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));  
							 String strts = gson.toJson(tstate); 
							 Jedis jedis = Config.get();
							 if(jedis.llen(Config.key+":execute-log") > 10000) jedis.rpop(Config.key+":execute-log");
							 jedis.lpush(Config.key+":execute-log",strts);  
							  
							 log(strts);
							 jedis.close();
							 Star_test.takes.put(ac.deviceId+ac.dataAddr,null);
							 //System.out.println(":"+strts+""); 
						 }
						 //System.out.println("=================="+ac.dataAddr+"="+sjosn+""); 
						 //System.out.println("S:"+ac.deviceId+ac.dataAddr+"=="+s);
					}).exceptionally(ex -> {
		                ex.printStackTrace();
		                return null;
		            });
				} catch (Throwable t) {
					//System.out.println("Error");
				} 
			}
		} ,1000, 1000, TimeUnit.MILLISECONDS);  /**/
			//System.out.println(ac.toString()); 
		 
	}
}
