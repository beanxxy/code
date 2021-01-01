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
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
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
import com.iot.gateway.cfg.model.cfg_Alarm;
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
/**
 * @author bean
 *
 */
public class Star {
	static Logger logger = Logger.getLogger(Star.class.getName());
	public static Map<String,String> db 			= new ConcurrentHashMap<String,String>(); 
	ScheduledExecutorService scheduledThreadPool 	= Executors.newScheduledThreadPool(100); 
	public static String STOREID 					= "59905";
	public static MyMqtt mqtt 						= null;
	public static Gson gson 						= new Gson();
	public static Client client 					= new ClientTcp(); 
	
	public static Map<String,String> timeCheck    	= new ConcurrentHashMap<String,String>(); 
	public static Map<String,String> order 			= new ConcurrentHashMap<String,String>(); 
	
	public static Map<String,String> funing			= new ConcurrentHashMap<String,String>(); 
	/**
	 * 功能调用
	 * @param code 功能代码;
	 * @param devid 设备id / 如果设备id为空或者设备id为0 / 调用全部设备类型;
	 * @param devtype 设备类型;
	 * @param data	发送到功能的数据;
	 * @throws Exception 
	 */
	public static void funs(String code,String devid,String devtype,String data,String missionId)  {
		
		String orderkey = code+devtype+data; 
		if(funing.get(devid+code)!=null) {
			Result r = new Result();
    		r.id = devid;
    		r.checkResult 	= 0; 
    		r.cmdId   		= Long.parseLong(missionId);
    		r.storeId 		= Long.parseLong(STOREID);
    		r.message 		= "不能重复操作!"; 
    		mqttSend("deviceCmdExcResult", gson.toJson(r)); 
    		return;
		} 
		funing.put(devid+code, missionId); 
		 
		
		SqlSession session				= MySql.getSqlSession();
		DevMapper devMapper 			= session.getMapper(DevMapper.class);
		FunctionMapper functionMapper 	= session.getMapper(FunctionMapper.class);
		CallMapper callMapper 			= session.getMapper(CallMapper.class);
		List<cfg_Dev> devs 				= null; 
		if(devid==null||devid.length()==0||devid.equals("0")) {
			 devs 				= devMapper.getListByType(devtype);
		}else {	
			devs 				= devMapper.getListByDevid(devid);
		}
		for(cfg_Dev dev:devs) { 
			//超时检查注册
			timeCheck.put(missionId,System.currentTimeMillis()+"-"+devid);
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
				
				info.attr.put("datamodel", info.dataModel);
				try {
					client.write(info, data);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					Result r = new Result();
            		r.id = dev.devid;
            		r.checkResult 	= 0; 
            		r.cmdId   		= Long.parseLong(missionId);
            		r.storeId 		= Long.parseLong(STOREID);
            		r.message 		= "设备不在线!"; 
            		String str 		= gson.toJson(r); 
            		mqttSend("deviceCmdExcResult", str);
            		Star.funing.remove(r.id+code);
            		//e.printStackTrace();
            		continue;
				}  
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
					List<cfg_Call> lsEvent 	= maplist.get(str); 
					FunInfo eventInfo		= new FunInfo();
					eventInfo.attr 			= new ConcurrentHashMap<String,String>(); 
					eventInfo.attr.put("devid", dev.devid);
					eventInfo.attr.put("parentName", dev.name);
					eventInfo.attr.put("estimateName", fun.name);
					eventInfo.attr.put("code", code);
					
					eventInfo.dataAddr  = str;
					eventInfo.dataModel = lsEvent.get(0).DataModel;
					eventInfo.ip  		= dev.ip;
					eventInfo.port 		= Integer.parseInt(dev.port);
					eventInfo.event		= new ConcurrentHashMap<String,Event>(); 
					eventInfo.protocal	= dev.protocal;
					
					for(cfg_Call call:lsEvent) {
						FunEvent ev = new FunEvent();
						ev.attr = new ConcurrentHashMap<String,String>(); 
						ev.attr.put("missionId", missionId);
						ev.attr.put("devid", devid);
						ev.attr.put("massge", call.massge);
						ev.attr.put("orderkey", orderkey); 
						
						if(call.command==null) {
							call.command="";
						}
						ev.attr.put("code", code);
						ev.attr.put("command", call.command);
						
						//logger.info(call.command);
						//logger.info(call.DataAddr+":"+
						//		call.value
						//		+":"+call.massge); 
						
						eventInfo.event.put(call.value,ev); 
					} 
					//logger.info("============");
					if(ClientTcp.IoinfoData.get(ClientTcp.getKeyInfo(eventInfo))==null) {
						client.read0(eventInfo);
					}else {
						
					}
					
				} 
			}
			
		}
		session.close();
	}
	
	public static void mqttSend(String topic, String msg) {
		try {
			mqtt.sendMessage(topic, msg);
		} catch (MqttException e) { 
			mqttRead();
			e.printStackTrace();
		} catch (Exception e) { 
			mqttRead();
			e.printStackTrace();
		} 
	}
	
	/**
	 * mqtt 中读取命令
	 */
	public static void mqttRead() {
		mqtt= new MyMqtt(new MqttCallback() { 
			@Override
            public void messageArrived(String arg0, MqttMessage arg1){
                // TODO 自动生成的方法存根 
            	Long missionId = null	 ;
        		String id = null	;
        		String funid = null;
            	try {
            		if(arg0.equals("deviceCmd_59905")) { 
	            		String msg 		= new String(arg1.getPayload());
	            		Cmd cmd  		= gson.fromJson(msg, Cmd.class); 
	            		id	   			= cmd.id; 
	            		int type	   	= cmd.type; 
	            		funid   	= cmd.cmd+"";
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
            		r.message 		= "未知错误!"; 
            		String str 		= gson.toJson(r); 
            		mqttSend("deviceCmdExcResult", str);
            		Star.funing.remove(r.id+funid);
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
		
		 String[] arrstr = new String[] { "deviceCmd_"+STOREID };
		 int[] arri = new int[] {0};
		 mqtt.subscribe(arrstr, arri); 
	}
	public static void main(String[] args) { 
		//Logger.global.setLevel(Level.OFF);
		
		//logger.getGlobal().setLevel(Level.OFF);
		Star star = new Star();
		star.mqttRead();
		
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
				info.attr.put("datamodel",io.DataModel); 
				info.attr.put("addr",io.DataAddr); 
				client.read(info); // break;
			} 
			List<cfg_Alarm> cfg_Alarms  =	alarMapper.getListByConfig(dev.config);
			
			for(cfg_Alarm caf:cfg_Alarms) {
				AlarmInfo info 	= new AlarmInfo();
				info.attr		= new ConcurrentHashMap<String,String>(); 
				info.ip 		= dev.ip;
				info.dataAddr 	= caf.DataAddr;
				info.port 		= Integer.parseInt(dev.port);
				info.protocal	= dev.protocal;
				info.dataModel	= caf.DataModel;
				info.attr.put("port",info.port+"" );
				info.attr.put("protocal",info.protocal );
				info.attr.put("dataModel",info.dataModel );
				info.attr.put("devid",dev.devid );
				info.attr.put("devtype",dev.devtype);  
				info.event		= new ConcurrentHashMap<String,Event>(); 
				
				//dev.devtype
				AlarmEvent ev 	= new AlarmEvent();
				ev.attr			= new ConcurrentHashMap<String,String>(); 
				ev.attr.put("massge",dev.devid+"-"+info.dataAddr+"-"+caf.code+":"+caf.massge);
				ev.attr.put("code", caf.code);
				info.event.put(caf.value, ev); 
				//logger.info(new Gson().toJson(info)); 
				client.read(info); // break;
			} 
		} 
		session.close();
		 
		
		star.checktime();
		logger.info("start "+ new Date().toString());  
	}
	
	public void checktime() {
		scheduledThreadPool.scheduleAtFixedRate(()->{try {  
			for(String missionId:Star.timeCheck.keySet()) {
				String[] dt = Star.timeCheck.get(missionId).split("-");
				if(new Date().getTime()-Long.parseLong(dt[0])>ClientTcp.MAXTIME) {
					Result r = new Result();
					r.id = dt[1];
					r.checkResult 	= 0; 
					r.cmdId   		= Long.parseLong(missionId);
					r.storeId 		= Long.parseLong(STOREID);
					r.message 		= "超时!"; 
					String str 		= gson.toJson(r); 
					mqttSend("deviceCmdExcResult", str);
					Star.timeCheck.remove(missionId);
					
					for(String funkey:funing.keySet()) {
						if(missionId.equals(funing.get(funkey)+"")) {
							funing.remove(funkey);
						}
					} 
				}
			}
		}catch(Throwable t) {  
			logger.warning(t.getMessage());
		} }, 10, 60, TimeUnit.SECONDS);
	}
	/**
	 * io上报
	 * 弃用
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
				//outmap.put("storeId", "");
				outmap.put("id", heads.get(str).get("id"));
				outmap.put("storeId", heads.get(str).get("storeId"));
				outmap.put("name", heads.get(str).get("name"));
				outmap.put("partId", heads.get(str).get("partId"));
				outmap.put("checkPointList", point.get(str));
			    String outstr = gson.toJson(outmap); 
			    Thread.sleep(50);
			    mqttSend("devicePartCheckPoint", outstr);  
			}  
			session.close();
			 
			
			
			
			
			//超时检查
			//timeCheck
			for(String missionId:Star.timeCheck.keySet()) {
				String[] dt = Star.timeCheck.get(missionId).split("-");
				if(new Date().getTime()-Long.parseLong(dt[0])>ClientTcp.MAXTIME) {
					Result r = new Result();
					r.id = dt[1];
					r.checkResult 	= 0; 
					r.cmdId   		= Long.parseLong(missionId);
					r.storeId 		= Long.parseLong(STOREID);
					r.message 		= "超时!"; 
					String str 		= gson.toJson(r); 
					mqttSend("deviceCmdExcResult", str);
					Star.timeCheck.remove(missionId);
				}
			}
			
		}catch(Throwable t) { 
			logger.warning(t.getMessage());
		} }, 10, 60, TimeUnit.SECONDS);
	    //mqtt.sendMessage("devicePartCheckPoint", outstr);
		
	}

}
