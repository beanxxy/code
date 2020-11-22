package com.iot.check;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;
import com.iot.check.mqtt.Cmd;
import com.iot.check.mqtt.MyMqtt;
import com.iot.check.mqtt.Result;
import com.iot.gateway.cfg.mapping.AlarmMapper;
import com.iot.gateway.cfg.mapping.CallMapper;
import com.iot.gateway.cfg.mapping.DevMapper;
import com.iot.gateway.cfg.mapping.FunctionMapper;
import com.iot.gateway.cfg.mapping.IoInfoMapper;
import com.iot.gateway.cfg.model.cfg_Call;
import com.iot.gateway.cfg.model.cfg_Dev;
import com.iot.gateway.cfg.model.cfg_Function;
import com.iot.gateway.cfg.model.cfg_IoInfo;
import com.iot.gateway.cfg.mybatis.MySql;
import com.iot.gateway.core.Client;
import com.iot.gateway.core.Event;
import com.iot.gateway.core.Ioinfo;
import com.iot.gateway.core.imp.ClientTcp;
import com.iot.gateway.core.util.Tool;
public class Star {
	public static Map<String,String> db 			= new ConcurrentHashMap<String,String>(); 
	ScheduledExecutorService scheduledThreadPool 	= Executors.newScheduledThreadPool(100); 
	public static String STOREID 					= "59905";
	public static MyMqtt mqtt 						= null;
	public static Gson gson 						= new Gson();
	public static Client client 					= new ClientTcp(); 
	
	public static Map<String,String> timeCheck    	= new ConcurrentHashMap<String,String>(); 
	public static Map<String,String> order 			= new ConcurrentHashMap<String,String>(); 
	/**
	 * 功能调用
	 * @param code 功能代码;
	 * @param devid 设备id / 如果设备id为空或者设备id为0 / 调用全部设备类型;
	 * @param devtype 设备类型;
	 * @param data	发送到功能的数据;
	 * @throws InterruptedException 
	 */
	public static void funs(String code,String devid,String devtype,String data,String missionId) throws InterruptedException {
		
		String orderkey = code+code+devtype+data;
//		if(order.get(orderkey)!=null) {
//			Result r = new Result();
//			r.id = devid;
//			r.checkResult 	= 0; 
//			r.cmdId   		= Long.parseLong(missionId);
//			r.storeId 		= Long.parseLong(STOREID);
//			r.message 		= "不能重复执行!"; 
//			String str 		= gson.toJson(r); 
//			mqtt.sendMessage("deviceCmdExcResult", str);
//			return;
//		}
//		order.put(orderkey, missionId); 
		
		SqlSession session				= MySql.getSqlSession();
		DevMapper devMapper 			= session.getMapper(DevMapper.class);
		FunctionMapper functionMapper 	= session.getMapper(FunctionMapper.class);
		CallMapper callMapper 			= session.getMapper(CallMapper.class);
		List<cfg_Dev> devs 				= null;//devMapper.getList();
		if(devid==null||devid.length()==0||devid.equals("0")) {
			 devs 				= devMapper.getListByType(devtype);
		}else {	
			devs 				= devMapper.getListByDevid(devid);
		}
		for(cfg_Dev dev:devs) { 
			
			timeCheck.put(missionId,new Date().getTime()+"-"+devid);//超时检查注册
			List<cfg_Function> funs 	= functionMapper.getListByConfig(dev.config); 
			List<cfg_Call> calls		= callMapper.getListByConfig(dev.config); 
			for(cfg_Function fun:funs) { 
				Ioinfo info 	= new DevInfo();
				info.attr		= new ConcurrentHashMap<String,String>(); 
				info.ip 		= dev.ip;
				info.dataAddr 	= fun.DataAddr;
				info.port 		= Integer.parseInt(dev.port);
				info.protocal	= dev.protocal;
				info.dataModel	= fun.DataModel;  
				client.write(info, data);  
				Map<String,List<cfg_Call>> maplist = new HashMap<String,List<cfg_Call>>();
				for(cfg_Call call:calls) {  
					List<cfg_Call> lsEvent = maplist.get(call.DataAddr);
					if(lsEvent==null) {
						lsEvent = new ArrayList<cfg_Call>();
					} 
					lsEvent.add(call);
					maplist.put(call.DataAddr, lsEvent);
				} 
				for(String str : maplist.keySet()) {
					List<cfg_Call> lsEvent = maplist.get(str); 
					Ioinfo eventInfo= new DevInfo();
					eventInfo.attr = new ConcurrentHashMap<String,String>(); 
					//eventInfo.attr.put("missionId", missionId);
					eventInfo.dataAddr  = str;
					eventInfo.dataModel = lsEvent.get(0).DataModel;
					eventInfo.ip  		= dev.ip;
					eventInfo.port 		= Integer.parseInt(dev.port);
					eventInfo.event		= new ConcurrentHashMap<String,Event>(); 
					for(cfg_Call call:lsEvent) {
						DevEvent ev = new DevEvent();
						ev.attr = new ConcurrentHashMap<String,String>(); 
						ev.attr.put("missionId", missionId);
						ev.attr.put("devid", devid);
						ev.attr.put("massge", call.massge);
						ev.attr.put("orderkey", orderkey); 
						eventInfo.event.put(call.value,ev); 
					}
					client.read(eventInfo);
				} 
			}
			
		}
		session.close();
	}
	/**
	 * mqtt 中读取命令
	 */
	public void mqttRead() {
		mqtt= new MyMqtt(new MqttCallback() { 
            public void messageArrived(String arg0, MqttMessage arg1){
                // TODO 自动生成的方法存根 
            	Long missionId = null	 ;
        		String id = null	;
            	try {
            		if(arg0.equals("deviceCmd_59905")) { 
	            		String msg 		= new String(arg1.getPayload());
	            		Cmd cmd  		= gson.fromJson(msg, Cmd.class); 
	            		id	   	= cmd.id; 
	            		int type	   	= cmd.type; 
	            		String funid   	= cmd.cmd+"";
	            		String data	   	= cmd.cmdParam; 
	            		missionId	= cmd.cmdId;  
	            		if( 
	            			funid!=null
	            			&&id!=null
	            			&&type!=0
	            			&&data!=null
	            			&&missionId!=null) { 
	            		 
	            			funs(funid+"", id+"", type+"", data+"",missionId+"");
	            		} 
            		}
            	}catch (Throwable t) {
 
            		Result r = new Result();
            		r.id = id;
            		r.checkResult 	= 0; 
            		r.cmdId   		= missionId;
            		r.storeId 		= Long.parseLong(STOREID);
            		r.message 		= "设备不在线!"; 
            		String str 		= gson.toJson(r); 
            		mqtt.sendMessage("deviceCmdExcResult", str);
            		
				}
            }

			public void connectionLost(Throwable cause) {
				// TODO Auto-generated method stub
			}

			public void deliveryComplete(IMqttDeliveryToken token) {
				// TODO Auto-generated method stub
			} 
        },false);  
		
		 String[] arrstr = new String[] { "deviceCmd_"+STOREID };
		 int[] arri = new int[] {0};
		 mqtt.subscribe(arrstr, arri); 
	}
	public static void main(String[] args) { 
		Gson gs 						= new Gson();
		SqlSession session				= MySql.getSqlSession();
		DevMapper devMapper 			= session.getMapper(DevMapper.class);
		List<cfg_Dev> devs 				= devMapper.getList();
		AlarmMapper alarMapper 			=  session.getMapper(AlarmMapper.class);
		CallMapper callMapper 			=  session.getMapper(CallMapper.class);
		FunctionMapper functionMapper 	=  session.getMapper(FunctionMapper.class);
		IoInfoMapper foInfoMapper 		=  session.getMapper(IoInfoMapper.class);
		for(cfg_Dev dev:devs) { 
			List<cfg_IoInfo> cfg_ioInfo 	= foInfoMapper.getListByConfig(dev.config);   
			for(cfg_IoInfo io:cfg_ioInfo) {
				Ioinfo info 	= new DevInfo();
				info.attr		= new ConcurrentHashMap<String,String>(); 
				info.ip 		= dev.ip;
				info.dataAddr 	= io.DataAddr;
				info.port 		= Integer.parseInt(dev.port);
				info.protocal	= dev.protocal;
				info.dataModel	= io.DataModel;  
				
				info.attr.put("ip",info.ip );
				info.attr.put("dataAddr",info.dataAddr );
				info.attr.put("name",dev.name);
				
				info.attr.put("estimateName",io.estimateName);
				info.attr.put("parentName",io.parentName);
				
				info.attr.put("port",info.port+"" );
				info.attr.put("protocal",info.protocal );
				info.attr.put("dataModel",info.dataModel );
				info.attr.put("devid",dev.devid );
				info.attr.put("devtype",dev.devtype); 
				 
			 
				client.read(info); // break;
			} 
		} 
		session.close();
		 
		Star star = new Star();
		star.mqttRead();
		star.updata();
		System.out.println("start "+ new Date().toString());
	}
	
	
	/**
	 * io上报
	 */
	public void updata() { 
		scheduledThreadPool.scheduleAtFixedRate(()->{try { 
			SqlSession session 				= MySql.getSqlSession();
			DevMapper devMapper 			= session.getMapper(DevMapper.class);
			IoInfoMapper foInfoMapper 		= session.getMapper(IoInfoMapper.class);
			List<cfg_Dev> devs 				= devMapper.getList(); 
			Map<String,Object> outmap 		= new HashMap<String,Object>();
			Map<String,Map> heads 			= new HashMap<String,Map>();
			Map<String,List<Map>> point 	= new HashMap<String,List<Map>>();  
			for(cfg_Dev dev:devs) { 
				List<cfg_IoInfo> cfg_ioInfo = foInfoMapper.getListByConfig(dev.config);   
				for(cfg_IoInfo io:cfg_ioInfo) {
					String deviceid 	= dev.devid;
					String parentName 	= io.parentName;
					String estimateName	= io.estimateName;  
					String dbkey = deviceid+"."+parentName+"."+estimateName;
					Map<String,String> head = new HashMap<String,String>();
					Map<String,String> em = new HashMap<String,String>();
					List<Map> ls = point.get(deviceid);
					if(ls==null) {
						ls = new ArrayList<Map>();
					}
					em.put("parentName", parentName);
					em.put("estimateName", estimateName);
					em.put("estimateValue", db.get(dbkey)==null?"0":(db.get(dbkey)+""));
					ls.add(em);
					point.put(deviceid, ls); 
					head.put("storeId", STOREID);
					head.put("id", deviceid);
					head.put("name", parentName);
					head.put("partId", Tool.StringToId(parentName+deviceid).substring(0,5));
					//head.put("storeId", ""); 
					heads.put(deviceid, head); 
				} 
			}  
			for(String str : heads.keySet()) {
				outmap.put("storeId", "");
				outmap.put("id", heads.get(str).get("id"));
				outmap.put("storeId", heads.get(str).get("storeId"));
				outmap.put("name", heads.get(str).get("name"));
				outmap.put("partId", heads.get(str).get("partId"));
				outmap.put("checkPointList", point.get(str));
			    String outstr = gson.toJson(outmap); 
			    Thread.sleep(50);
			    mqtt.sendMessage("devicePartCheckPoint", outstr); 
			}  
			session.close();
			 
			
			
			
			
			//超时检查
			//timeCheck
//			for(String missionId:Star.timeCheck.keySet()) {
//				String[] dt = Star.timeCheck.get(missionId).split("-");
//				if(new Date().getTime()-Long.parseLong(dt[0])>1000) {
//					Result r = new Result();
//					r.id = dt[1];
//					r.checkResult 	= 0; 
//					r.cmdId   		= Long.parseLong(missionId);
//					r.storeId 		= Long.parseLong(STOREID);
//					r.message 		= "超时!"; 
//					String str 		= gson.toJson(r); 
//					mqtt.sendMessage("deviceCmdExcResult", str);
//					Star.timeCheck.remove(missionId);
//				}
//			}
			
		}catch(Throwable t) { System.out.println(t.getMessage());  } }, 10, 60, TimeUnit.SECONDS);
	    //mqtt.sendMessage("devicePartCheckPoint", outstr);
		
	}

}
