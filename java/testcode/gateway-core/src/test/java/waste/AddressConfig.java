package waste;

public class AddressConfig {
	public int id;
	/**
	 * �豸��ip��ַ
	 */
	public String ip;
	/**
	 * �豸�Ķ˿ں�
	 */
	public int port;
	/**
	 * �豸��ͨ��Э�� melsec mcu 
	 */
	public String protocal; 
	/**
	 * ���ݵ�ַ
	 */
	public String dataAddr; 
	/**
	 * ����ģ��
	 */
	public String dataModel;
	
	public int state;// 0 停用 1 启用
	
	public int type;// 0 停用 1 启用
	
	public String parentName;
	public String estimateName;
	public String deviceId;
	public String massge;
	
	public String toString() {
		return this.ip+","+this.dataAddr+","+
				this.dataModel+","+this.deviceId+","+this.type;
	}
}