package com.comon.gateway.protocol;

import java.util.Map;

/**
 * @author bean
 * 2020年9月24日
 */
public interface Std {
	
	/**
	 * *启动监听 
	 * @param post	   	端口
	 * @param id		配置id,端口下的id
	 */
	void start(int port,String id) throws Exception ;
	
	/**
	 **读取数据
	 */
	Map read();
	
	/**
	 **写入数据
	 * @param obj
	 */
	void write(Object obj);
	
}
