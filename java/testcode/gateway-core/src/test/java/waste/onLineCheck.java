package waste;

import java.net.InetAddress;

public class onLineCheck {
	 public static boolean ping(String ipAddress) throws Exception {
        int  timeOut =  3000 ;  //超时应该在3钞以上        
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);     // 当返回值是true时，说明host是可用的，false则不可。
        return status;
     }

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ping("192.168.1.100")+"");
	} 
}