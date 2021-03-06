package gateway.core.config;

import java.io.Serializable;

public class Function implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String deviceid;
	public String ip;
	public String protocal;
	public int port;
	public String dataAddr;
	public String dataModel;
	public String code;
	public String listenaddr;
	public String remark;
	public String state;
	public String devtype;
	
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getProtocal() {
		return protocal;
	}
	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getDataAddr() {
		return dataAddr;
	}
	public void setDataAddr(String dataAddr) {
		this.dataAddr = dataAddr;
	}
	public String getDataModel() {
		return dataModel;
	}
	public void setDataModel(String dataModel) {
		this.dataModel = dataModel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getListenaddr() {
		return listenaddr;
	}
	public void setListenaddr(String listenaddr) {
		this.listenaddr = listenaddr;
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
	public String getDevtype() {
		return devtype;
	}
	public void setDevtype(String devtype) {
		this.devtype = devtype;
	}
}
