package com.iot.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.iot.gateway.core.Ioinfo;
 
/**
 * @author bean
 *
 */
public class DevInfo extends Ioinfo{ 
	static Logger logger = Logger.getLogger(AlarmEvent.class.getName());
	@Override
	public void change(String value) { 
		String deviceid 	= this.attr.get("devid");
		String parentName 	= this.attr.get("parentName");
		String estimateName	= this.attr.get("estimateName");
		String datamodel	= this.attr.get("datamodel");
		String addr			= this.attr.get("addr");
		String dbkey = deviceid+"."+parentName+"."+estimateName;
		Star.db.put(dbkey, value);
		 
		Gson gs 						= new Gson();
		Map iomap = new HashMap<String,String>();
		iomap.put("parentName", parentName);
		iomap.put("estimateName", addr+"-"+estimateName);
		iomap.put("estimateValue", value);
		List<Map> point 	= new ArrayList<Map>();  
		point.add(iomap); 
		Map<String,Object> outmap 		= new HashMap<String,Object>(); 
		outmap.put("storeId",Star.STOREID);
		outmap.put("id",deviceid);
		outmap.put("name",parentName);
		outmap.put("partId", "1"); 
		if(datamodel.equals("bit")) {
			outmap.put("checkPointList", point);
			Star.mqttSend("devicePartCheckPoint", gs.toJson(outmap));  
		}else {
			outmap.put("measuredList", point);
			Star.mqttSend("devicePartMeasuredValue", gs.toJson(outmap));  
		}
		//logger.info(gs.toJson(outmap)); 
	}

	@Override
	public void call(String value) {
		// TODO Auto-generated method stub
		
	}


}  