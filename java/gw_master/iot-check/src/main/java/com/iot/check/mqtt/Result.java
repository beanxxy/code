package com.iot.check.mqtt;

public class Result {
	/**
	 * 门店id
	 */
	public Long storeId;
	/**
	 * 设备id
	 */
	public String id;
	/**
	 * 点检命令id
	 */
	public Long cmdId;
	/**
	 * 点检结果信息
	 */
	public String message;
	/**
	 * 点检结果
	 */
	public int checkResult;	
}
