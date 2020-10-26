package gateway.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import gateway.core.config.Alert;
import gateway.core.config.Function;
import gateway.core.config.Ioinfo;
import gateway.core.imp.ClientTcp;
import gateway.core.mapper.AlertData;
import gateway.core.mapper.FunctionMapper;
import gateway.core.mapper.IoinfoMapper;
import gateway.core.mqtt.MyMqtt;
import gateway.core.mybatis.MySql;
import gateway.core.util.Tool;

public class Star {
	public static Map<String,String> takes = new HashMap<String,String>();
	public static Map<String,String> db = new HashMap<String,String>(); 
	public static Map<String,Alert> alertdb = new HashMap<String,Alert>();
	public static String STOREID = "1239863613804683265";
	public static MyMqtt mqtt = null;
	public static ClientTcp cp = new ClientTcp();
	public static Gson gson = new Gson();
	public static void main(String[] args) {
		//=======================
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
		AlertData alertData = MySql.session.getMapper(AlertData.class);
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
            	System.out.println(arg1);
            	try {
	            	if(arg0.equals("devtask")) {
	            		
	            		String msg = new String(arg1.getPayload());
	            		Map map  = gson.fromJson(msg, Map.class);
	            		String storeid 	= map.get("storeId")+"";
	            		String id	   	= map.get("id")+"";
	            		String name	   	= map.get("name")+"";
	            		String type	   	= map.get("type")+"";
	            		String funid   	= map.get("funid")+"";
	            		String data	   	= map.get("data")+""; 
	            		String missionId= map.get("missionId")+"";  
	            		System.out.println(map);
	            		if(storeid!=null&&storeid.equals(STOREID)
	            			&&funid!=null
	            			&&id!=null
	            			&&type!=null
	            			&&data!=null
	            			&&missionId!=null) {
	            			System.out.println(map);
	            			funs(funid, id, type, data,missionId);
	            		}
	            		//System.out.println(storeid);
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
		
		 String[] arrstr = new String[] { "devtask" };
		 int[] arri = new int[] {0};
		 mqtt.subscribe(arrstr, arri); 
	}

	/**
	 * 报警反馈
	 */
	public void alert(Ioinfo io,String value) {
		 String alertkey = io.deviceid+io.dataAddr+value;
		 if(alertdb.get(alertkey)!=null) {//触发报警
			 Alert at = alertdb.get(alertkey); 
			 if(task(io,value,at)) { //是否是执行反馈
				 Map<String,String> alertmassg = new HashMap();
				 alertmassg.put("storeId", STOREID);
				 alertmassg.put("id", io.deviceid);
				 alertmassg.put("name", io.estimateName);
				 alertmassg.put("type", io.type);
				 alertmassg.put("data", at.massge);
				 alertmassg.put("code", at.code); 
				 mqtt.sendMessage("devalert", gson.toJson(alertmassg));
			 }
		 }
	}
	
	/**
	 * 执行进程反馈
	 * takes.put(addr.deviceid+fun.listenaddr, missionId);
	 * @return 
	 */
	public boolean task(Ioinfo io,String value,Alert at) {
		String comm = takes.get(io.deviceid+io.dataAddr)+"";
		if(comm!=null) {
			if(at!=null) { 
				Map<String,String> tmp = new HashMap();
				tmp.put("storeId", STOREID);
				tmp.put("id", io.deviceid);
				tmp.put("name", io.estimateName);
				tmp.put("type", io.type);
				tmp.put("data", at.massge);
				tmp.put("funid", at.code);
				tmp.put("missionId",comm); 
				mqtt.sendMessage("taskans", gson.toJson(tmp));
				if(at.command.equals("over")) { 
					takes.remove(io.deviceid+io.dataAddr);
				}
			}else {
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
		FunctionMapper functionMapper = MySql.session.getMapper(FunctionMapper.class);
		if(devid==null||devid.length()==0||devid.equals("0")) {
			functions = functionMapper.getAddrFunByType(devtype, code);//获取所有设备
		}else {			
			functions = functionMapper.getAddrFun(devid,devtype,code);
		}
		for(Function fun:functions) {
			Ioinfo addr = new Ioinfo();
			addr.dataAddr = fun.dataAddr;
			addr.dataModel = fun.dataModel;
			addr.ip = fun.ip;
			addr.deviceid = fun.deviceid;
			addr.port = fun.port;
			addr.protocal = fun.protocal;
			cp.batchWrite(addr, data);
			String[] listens = fun.listenaddr.split(",");
			for(int i=0;i < listens.length;i++) {
				takes.put(addr.deviceid+listens[i], missionId); 
			} 
		}
	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * 监控变量
	 */
	public void monitor() {
		IoinfoMapper ioinfoMapper = MySql.session.getMapper(IoinfoMapper.class);
		List<Ioinfo> ios = ioinfoMapper.getList();
		ClientTcp cp = new ClientTcp(); 
		
		Map<String,Map> heads = new HashMap<String,Map>();  
		Map<String,String> isout = new HashMap<String,String>(); 
		Map<String,List<Map>> point = new HashMap<String,List<Map>>();
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{   
			
			for(Ioinfo ac : ios) { 
				 //String dd = ac.deviceid+"."+ac.parentName+"."+ac.estimateName; 
				// System.out.println(dd+":"); 
				try { 
					cp.batchRead(ac).thenAccept(s->{
						 String dbkey = ac.deviceid+"."+ac.parentName+"."+ac.estimateName;
						 System.out.println(dbkey+":"+s); 
						 if(db.get(dbkey)==null)db.put(dbkey, "");
						 if((db.get(dbkey)+"").equals(s)) {
							 
						 }else {//变量变换
							
							
							db.put(dbkey,s);
							String divid = ac.deviceid;
							String name  = ac.parentName;
							String partId = Tool.StringToId(name).substring(32);
							String key = divid+name+partId;
							
							isout.put(key, "1");
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
							map.put("estimateValue", s);
							mls.add(map); 
							head.put("divid", divid);
							head.put("name", name);
							head.put("partId", partId); 
							point.put(key, mls);
							heads.put(key, head); 
							
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
			
		},1000, 1000, TimeUnit.MILLISECONDS); 
		
		
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{   
			//发送mqtt
			try { 
				for(Entry<String, Map> entry : heads.entrySet()){
					
					
				    String mapKey = entry.getKey();
				    if(isout.get(mapKey).equals("1")) {
				    	Map<String,Object> outmap = new HashMap<String,Object>();
					    outmap.put("storeId", STOREID);
					    outmap.put("id", heads.get(mapKey).get("divid"));
					    outmap.put("name", heads.get(mapKey).get("name"));
					    outmap.put("partId", heads.get(mapKey).get("partId"));
					    outmap.put("checkPointList", point.get(mapKey));
					    String outstr = gson.toJson(outmap);
					    isout.put(mapKey,"0");
					    //mqtt.sendMessage("devicePartCheckPoint", outstr);
					    mqtt.sendMessage("deviceIo", outstr);
				    }
				}
			}catch (Throwable t) {
				//System.out.println("Error");
			} 
		},1000, 1000, TimeUnit.MILLISECONDS);
		
		
		
		
		
	}
}
