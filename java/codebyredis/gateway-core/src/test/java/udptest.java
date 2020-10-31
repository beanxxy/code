import gateway.core.config.AddressConfig;
import gateway.core.util.CRC16;
import gateway.core.util.Udp;

public class udptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressConfig address = new AddressConfig();
		address.protocal = "mcu";
		address.ip 	     = "192.168.8.112";
		address.port	 = 50000;
		address.dataModel= "bit";
		address.dataAddr = "0006"; 
		
		String[] addr = address.dataAddr.split("-");
		String sendstr = "";
		if(addr.length>1) {
			sendstr=addr[1];
		}
		byte[] bt = Udp.send(address.ip, address.port, addr[0],""); 
		System.out.println(new String(bt));
		System.out.println(CRC16.bytesToHex(bt));
	}

}
