package com.iot.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.iot.gateway.core.Event;
import com.iot.gateway.core.Ioinfo;

/**
 * @author bean
 * 2020年12月16日
 */
public class AlarmEvent extends Event{
	static Logger logger = Logger.getLogger(AlarmEvent.class.getName());
	@Override
	public void action(Ioinfo info) {
		Map<String,Object> outmap = new HashMap<String,Object>(); 
		String massge = this.attr.get("massge");
		outmap.put("id", info.attr.get("devid")); 
		outmap.put("storeId", Star.STOREID); 
		outmap.put("type", info.attr.get("devtype")); 
		outmap.put("state","1");
		List<Integer> ls = new ArrayList<Integer>();
		String code = this.attr.get("code");
		if(code!=null) {
			ls.add(Integer.parseInt(code));	
		} 
		outmap.put("errorList2",ls); 
		Star.mqttSend("deviceStatus", new Gson().toJson(outmap)); 
		if(Star.debug)logger.info(massge); 
		if(Star.debug)logger.info(new Gson().toJson(outmap)); 
	}
	
}
