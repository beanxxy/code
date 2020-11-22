package com.iot.gateway.cfg.model;

/**
 * io点位/地址点位
 * @author bean
 * 2020年11月9日
 */
public class cfg_IoInfo {
	/**
	 * 管理id
	 */
	public int id;
	/**
	 * 配置类型
	 */
	public String config;
	/**
	 * io的编码
	 */
	public String code;
	/**
	 * 上级名称
	 */
	public String parentName;
	/**
	 * 当前名称
	 */
	public String estimateName;
	/**
	 * 设备地址
	 */
	public String DataAddr;
	/**
	 * 数据模型
	 */
	public String DataModel;
	/**
	 * 备注
	 */
	public String remark;
	/**
	 * 状态
	 */
	public String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getEstimateName() {
		return estimateName;
	}
	public void setEstimateName(String estimateName) {
		this.estimateName = estimateName;
	}
	public String getDataAddr() {
		return DataAddr;
	}
	public void setDataAddr(String dataAddr) {
		DataAddr = dataAddr;
	}
	public String getDataModel() {
		return DataModel;
	}
	public void setDataModel(String dataModel) {
		DataModel = dataModel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
