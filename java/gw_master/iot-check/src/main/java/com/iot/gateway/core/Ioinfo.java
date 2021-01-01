package com.iot.gateway.core;
import java.util.Map;
/**
 * @author bean
 * 2020年11月14日
 */
public abstract class Ioinfo {
	
	/**
	 * 生存时间;
	 */
	public Long lifetime;
	/**
	 * ip 地址
	 */
	public String ip;
	/**
	 * 端口
	 */
	public int port;
	/**
	 * 协议
	 */
	public String protocal;
	/**
	 * 数据地址
	 */
	public String dataAddr;
	/**
	 * 数据类型
	 */
	public String dataModel;
	/**
	 * 其他属性
	 */
	public Map<String,String> attr;
	/**
	 * 字段值
	 */
	public String value; 
	/**
	 * 当value = key 时触发
	 * 事件触发
	 */
	public Map<String,Event> event;
	/**
	 * 当值发送改变时,回调
	 * @param value
	 */
	public abstract void change(String value);
	
	/**
	 * @param value
	 */ 
	public abstract void call(String value);
	
}
