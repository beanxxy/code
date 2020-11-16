package test;

import java.util.Date;

import gateway.core.util.CRC16;
import gateway.core.util.Udp;

public class MCUtest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		while(true) {
			long lg = new Date().getTime();
			Thread.sleep(50);
			byte[] bt = Udp.send("172.28.13.5", 50000,"A026",""); 
			if(bt!=null) { 
				//System.out.println(new String(bt));
				System.out.println(CRC16.bytesToHex(bt));
				System.out.println(lg-new Date().getTime());
			}
			
		}
		
	}

}
