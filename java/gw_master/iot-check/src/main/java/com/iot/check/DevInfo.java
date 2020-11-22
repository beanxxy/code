package com.iot.check;

import com.iot.gateway.core.Ioinfo;
 
public class DevInfo extends Ioinfo{ 
	@Override
	public void change(String value) { 
		String deviceid 	= this.attr.get("devid");
		String parentName 	= this.attr.get("parentName");
		String estimateName	= this.attr.get("estimateName");
		String dbkey = deviceid+"."+parentName+"."+estimateName;
		Star.db.put(dbkey, value);
	} 
}  