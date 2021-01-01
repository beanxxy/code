package com.iot.check;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.iot.check.mqtt.Result;
import com.iot.gateway.core.Event;
import com.iot.gateway.core.Ioinfo;
/**
 * 执行反馈
 * @author bean
 *
 */
public class DevEvent extends Event{

	@Override
	public void action(Ioinfo info) { 
		Result r = new Result();
		r.id = this.attr.get("devid");
		if(info.value.equals("1")) {
			r.checkResult=1;
		}else {
			r.checkResult=0;
		} 
		r.cmdId   		= Long.parseLong(this.attr.get("missionId"));
		r.storeId 		= Long.parseLong(Star.STOREID);
		r.message 		= this.attr.get("massge");
		String str 		= new Gson().toJson(r); 
		Star.mqttSend("deviceCmdExcResult", str);
		
		
		
		//mqtt============================================================================
		Map<String,String> process = new HashMap<String,String>();
		process.put("storeId",Star.STOREID);
		process.put("id",r.id);
		process.put("cmdId",r.cmdId+"");
		process.put("coccurTime",new Date().toGMTString());
		process.put("content",r.message);
		Star.mqttSend("deviceCheckPointProcess", new Gson().toJson(process));
		//================================================================================
		
		 
		info.event.remove(info.value); 
		Star.timeCheck.remove(this.attr.get("missionId")); 
		Star.order.remove(this.attr.get("orderkey"));
	} 
	 
}