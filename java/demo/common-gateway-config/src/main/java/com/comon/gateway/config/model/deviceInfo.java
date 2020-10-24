package com.comon.gateway.config.model;

import java.util.List;

/**
 * @author bean
 * 2020年9月24日
 */
public class deviceInfo {
	public String devicename;//设备名称
	public String deviceType;//设备类型
	/**
	 **注册数据标识,登录时�?�自动获取注册标�?,当收的时候自动获�?
	 **来自于输入输出数�?,如果接入就是输入数据
	 **/
	public List<String> flags; 
	/**
	 **设备出入接口 
	 **/
	public List<GW_interface>  interfaces; 
}
