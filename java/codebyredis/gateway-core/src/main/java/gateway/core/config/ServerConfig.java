package gateway.core.config;

import java.io.Serializable;

public class ServerConfig implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int id;
	public int port;
	public String dataAddr;
	public int type;
	public int state;
	
	public String toString() {
		return this.port+"-"+this.dataAddr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
