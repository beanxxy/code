package com.iot.check;

import java.util.logging.Logger;

import com.iot.gateway.core.Ioinfo;

/**
 * @author bean
 *
 */
public class FunInfo extends Ioinfo{
	static Logger logger = Logger.getLogger(FunInfo.class.getName());
	@Override
	public void change(String value) {
		// TODO Auto-generated method stub
		//logger.info("stv："+this.dataAddr+":"+value);
	}

	@Override
	public void call(String value) {
		// TODO Auto-generated method stub
		String deviceid 	= this.attr.get("devid");
		String code 		= this.attr.get("code");
		if(code!=null && Star.funing.get(deviceid+code)==null) {
			Star.client.close(this);
		}
	} 
}
