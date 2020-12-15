package com.iot.check;

import com.iot.gateway.core.Ioinfo;

public class FunInfo extends Ioinfo{

	@Override
	public void change(String value) {
		// TODO Auto-generated method stub
		System.out.println("stv："+this.dataAddr+":"+value);
	} 
}
