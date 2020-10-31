package gateway.core.config;

import java.io.Serializable;

public class Alert implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public int id;
	public String dataAddr; 
	public String value;
	public String massge;
	public String deviceid;
	public String code;
	public String command;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataAddr() {
		return dataAddr;
	}
	public void setDataAddr(String dataAddr) {
		this.dataAddr = dataAddr;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMassge() {
		return massge;
	}
	public void setMassge(String massge) {
		this.massge = massge;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
}
