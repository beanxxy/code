package com.iot.gateway.core;

import java.util.Map;

/**
 * @author bean
 * 2020年11月15日
 */
public abstract class Event {
	/**
	 * 其他属性
	 */
	public Map<String,String> attr;
	/**
	 * 事件触发
	 */
	public abstract void action(Ioinfo info);
}
