package com.bgy.gateway.model.vo;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bean
 * 2020年11月15日
 */
@Getter
@Setter
public abstract class BaseEvent {
	/**
	 * 其他属性
	 */
	private Map<String,String> attr;

	/**
	 * 事件触发 
	 * @param plcDataModelVo  数据块
	 * @param address 改变的
	 * @param value 值
	 */
	public abstract void action(BasePlcDataModelVO plcDataModelVo,String address,String value);
}
