package com.iot.check;

import com.google.gson.Gson;
import com.iot.check.mqtt.Result;
import com.iot.gateway.core.Event;
import com.iot.gateway.core.Ioinfo;

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
		Star.mqtt.sendMessage("deviceCmdExcResult", str);
		info.event.remove(info.value); 
		Star.timeCheck.remove(this.attr.get("missionId")); 
		Star.order.remove(this.attr.get("orderkey"));
	} 
	 
}