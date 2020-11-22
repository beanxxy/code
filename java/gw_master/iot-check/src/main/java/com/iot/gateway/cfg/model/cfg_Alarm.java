package com.iot.gateway.cfg.model;

/**
 * 报警字段
 * @author bean
 * 2020年11月9日
 */
public class cfg_Alarm {
	/**
	 * 管理id
	 */
	public int id; 
	/**
	 * 配置类型
	 */
	public String config;
	/**
	 * 报警编码
	 */
	public String code;
	/**
	 * 当为什么值时报警
	 */
	public String value;
	/**
	 * 报警等级
	 */
	public String level;
	/**
	 * 数据地址
	 */
	public String DataAddr;
	/**
	 * 数据模型
	 */
	public String DataModel;
	/**
	 * 报警消息
	 */
	public String massge;
	/**
	 * 状态
	 */
	public String state;
	
	/**
	 * 备注
	 */
	public String remark;
}
