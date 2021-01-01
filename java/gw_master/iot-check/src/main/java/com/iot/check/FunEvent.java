package com.iot.check;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.iot.check.mqtt.Result;
import com.iot.gateway.core.Event;
import com.iot.gateway.core.Ioinfo;
import com.iot.gateway.core.imp.ClientTcp;

/**
 * @author bean
 *
 */
public class FunEvent extends Event{

	@Override
	public void action(Ioinfo info) {
		// TODO Auto-generated method stub
		String command  = this.attr.get("command");
		String code 	= this.attr.get("code");
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
		

		//mqtt============================================================================
		Map<String,String> process = new HashMap<String,String>();
		process.put("storeId",Star.STOREID);
		process.put("id",r.id);
		process.put("cmdId",r.cmdId+"");
		process.put("coccurTime",new Date().toGMTString());
		process.put("content",r.message);
		Star.mqttSend("deviceCheckPointProcess", new Gson().toJson(process));
		//================================================================================
		
		
		if(command!=null&&command.equals("close")) {
			//去掉读取;  
			Star.client.close(info);
		}
		
		if(command!=null&&command.equals("close_fun")) {
			//去掉读取;  
			
			Star.client.close(info);
			Star.funing.remove(r.id+code);
			Star.mqttSend("deviceCmdExcResult", str);
		}
		if(Star.funing.get(r.id+code)==null) {
			Star.client.close(info);
		} 
		info.event.remove(info.value); 
		Star.timeCheck.remove(this.attr.get("missionId")); 
		Star.order.remove(this.attr.get("orderkey"));
	}
	
}
