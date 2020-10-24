package com.comon.gateway.config.model;

import java.util.List;

/**
 * @author bean
 * 2020年9月24日
 */
public class GW_interface  {
	public int id;
	public boolean type;	//接入 1 , 接口 2
	public boolean online;	//是否离线,离线或者接入后,自动接收消息
	public boolean register;//是否注册--注册数据标识,从入口注册标识
	public int post;		//端口
	public String protocol;	//协议  http / tcp / mqtt /udp / opc /modbus
	public String name; 	  //名称  
	public String config;	  // 接入配置
	public List<DataModel> inData; // 输入数据
	public List<DataModel> outData;// 输出数据 
}
