package gateway.core.config;

import java.io.Serializable;

public class Call implements Serializable{
	private static final long serialVersionUID = 1L;
	public int id;
	public String deviceid;
	public String dataAddr;
	public String value;
	public String code;
	public String massge;
	public String command;
	public int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMassge() {
		return massge;
	}
	public void setMassge(String massge) {
		this.massge = massge;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
