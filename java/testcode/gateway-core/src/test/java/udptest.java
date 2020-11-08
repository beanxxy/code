import gateway.core.config.Ioinfo;
import gateway.core.util.CRC16;
import gateway.core.util.Udp;

public class udptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ioinfo address = new Ioinfo();
		address.protocal = "mcu";
		address.ip 	     = "192.168.1.191";
		//address.ip 	     = "172.28.9.255";
		address.port	 = 50000;
		address.dataModel= "string";
		address.dataAddr = "A010"; 
		
		String[] addr = address.dataAddr.split("-");
		String sendstr = "";
		if(addr.length>1) {
			sendstr=addr[1];
		}
		byte[] bt = Udp.send(address.ip, address.port, address.dataAddr,""); 
		if(bt!=null) { 
			System.out.println(new String(bt));
			System.out.println(CRC16.bytesToHex(bt));
		}
	}

}
