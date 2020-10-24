package com.comon.gateway.config;

import java.util.List;
import java.util.Set;

import com.comon.gateway.config.model.deviceInfo;

/**
 * @author bean
 * 2020年9月24日
 */
public interface DeviceInterface {
	/**
	 **获取所有的配置
	 * @return
	 */
	List<deviceInfo> getDeviceInterface();
	/**
	 **根据设备id获取配置
	 * @param deviceid
	 * @return
	 */
	List<deviceInfo> getDeviceInterfaceById(int deviceid);
	List<deviceInfo> getDeviceInterfaceById(Set<Integer> deviceid);
	/**
	 **根据设备名称获取配置
	 * @param name
	 * @return
	 */
	List<deviceInfo> getDeviceInterfaceByName(String name);
	List<deviceInfo> getDeviceInterfaceByName(Set<String>  names);
	
}
