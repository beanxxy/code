package com.iot.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.iot.gateway.core.Event;
import com.iot.gateway.core.Ioinfo;

public class AlarmEvent extends Event{

	@Override
	public void action(Ioinfo info) {
		Map<String,Object> outmap = new HashMap<String,Object>(); 
		outmap.put("id", info.attr.get("devid")); 
		outmap.put("storeId", Star.STOREID); 
		outmap.put("type", info.attr.get("devtype")); 
		outmap.put("state","1");
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(Integer.parseInt(this.attr.get("code")));
		outmap.put("errorList2",ls); 
		Star.mqttSend("deviceStatus", new Gson().toJson(outmap)); 
		//System.out.println(this.attr.get("massge"));
		// TODO Auto-generated method stub
//		Result r = new Result();
//		r.id = this.attr.get("devid");
//		if(info.value.equals("1")) {
//			r.checkResult=1;
//		}else {
//			r.checkResult=0;
//		} 
//		r.cmdId   		= Long.parseLong(this.attr.get("missionId"));
//		r.storeId 		= Long.parseLong(Star.STOREID);
//		r.message 		= this.attr.get("massge");
//		String str 		= new Gson().toJson(r); 
//		Star.mqttSend("deviceCmdExcResult", str);
//
//		//mqtt============================================================================
//		Map<String,String> process = new HashMap<String,String>();
//		process.put("storeId",Star.STOREID);
//		process.put("id",r.id);
//		process.put("cmdId",r.cmdId+"");
//		process.put("coccurTime",new Date().toGMTString());
//		process.put("content",r.message);
//		Star.mqttSend("deviceCheckPointProcess", new Gson().toJson(process));
//		//================================================================================
//		
//		//System.out.println(str);
//		info.event.remove(info.value); 
//		Star.timeCheck.remove(this.attr.get("missionId")); 
//		Star.order.remove(this.attr.get("orderkey"));
	}
	
}
