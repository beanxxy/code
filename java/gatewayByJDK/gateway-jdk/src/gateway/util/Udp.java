package gateway.util; 


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

//import io.netty.handler.timeout.TimeoutException;
 
/**
 * @author bean
 */
public class Udp {
	/**
	 * 鑾峰彇褰撳墠ip鍦板潃
	 * @return
	 */
	public static List<String> getLocalIPList() {
        List<String> ipList = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface;
            Enumeration<InetAddress> inetAddresses;
            InetAddress inetAddress;
            String ip;
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement();
                inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                        ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipList;
    }
	/**
	 * 骞挎挱鍙戦��
	 * @return
	 */
	public static Map<String,byte[]> sendAll(String hostname,int port,String hexhead, byte[] strb,int outtime){ 
		if(outtime==0)outtime = 1000;
		String[] tmps = hostname.split("\\.");
		String tmp = tmps[0]+"."+tmps[1]+"."+tmps[2]+".255";
		hostname = tmp;
		Map<String,byte[]> map = new HashMap<String,byte[]>();
		try (DatagramSocket socket = new DatagramSocket(0)) {
			socket.setSoTimeout(outtime);
			InetAddress host = InetAddress.getByName(hostname);  
			CRC16 crc = new CRC16();   
			String body = CRC16.bytesToHex(strb);
			short length	=	(short) (body.length()/2); 
			String hexlength=	CRC16.getUnsignedByte(length); 
			String hexstring = "aa"+hexhead+hexlength+body;  
			byte[] sendbt = CRC16.toBytes(hexstring);
			crc.update(CRC16.toBytes(hexstring),0,sendbt.length);
			hexstring+=crc.getHexValue(); 
			byte[] bt = CRC16.toBytes(hexstring); 
			//鎸囧畾鍖呰鍙戦�佺殑鐩殑鍦�
			DatagramPacket request = new DatagramPacket(bt, bt.length, host, port);
			//涓烘帴鍙楃殑鏁版嵁鍖呭垱寤虹┖闂�
			DatagramPacket response = new DatagramPacket(new byte[16000], 16000);
			socket.send(request);
			while(true) {
				socket.receive(response); 
				byte[] revdata = response.getData();
				byte[] data=UDP_Rec_Event_method(revdata,revdata.length);
				String ip = response.getSocketAddress().toString().substring(1);
				map.put(ip, data);
			}   
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return map; 
	}
	
	public CompletableFuture<byte[]> sendbyFuture(String hostname,int port,String hexhead, byte[] strb){
		CompletableFuture<byte[]> future = new CompletableFuture<>(); 
		Executors.newCachedThreadPool().execute(()->{
			
		});
		return future;
	}
	
	/**
	 * @param hostname
	 * @param port
	 * @param hexheat
	 * @param body
	 * @return
	 */
	public static byte[] send(String hostname,int port,String hexhead, byte[] strb) { 
		
		//浼犲叆0琛ㄧず璁╂搷浣滅郴缁熷垎閰嶄竴涓鍙ｅ彿 
		DatagramSocket socket = null;
		try {
			//System.out.println(socket.getPort());
			//DatagramSocket 
			socket = new DatagramSocket(0);
			//System.out.println(socket.getLocalPort());
			socket.setSoTimeout(200); 
			InetAddress host = InetAddress.getByName(hostname);  
			CRC16 crc = new CRC16(); 
			//byte[] strb = body.getBytes(); 
			String body = CRC16.bytesToHex(strb);
			short length	=	(short) (body.length()/2); 
			String hexlength=	CRC16.getUnsignedByte(length); 
			String hexstring = "aa"+hexhead+hexlength+body;  
			byte[] sendbt = CRC16.toBytes(hexstring);
			crc.update(CRC16.toBytes(hexstring),0,sendbt.length); 
			hexstring+=crc.getHexValue();
			System.out.println(hexstring);
			byte[] bt = CRC16.toBytes(hexstring);
			//byte[] bt = CRC16.toBytes("aa000d0000db89");  
			//鎸囧畾鍖呰鍙戦�佺殑鐩殑鍦�
			DatagramPacket request = new DatagramPacket(bt, bt.length, host, port);
			//涓烘帴鍙楃殑鏁版嵁鍖呭垱寤虹┖闂�
			DatagramPacket response = new DatagramPacket(new byte[16000], 16000);
			socket.send(request);
			socket.receive(response);  
			byte[] revdata = response.getData(); 
			//response.getData() 
			
			
			byte[] data=UDP_Rec_Event_method(revdata,revdata.length);
			String result = CRC16.bytesToHex(data);
			System.out.println("out:"+result);
			/*if(data!=null) {
				System.out.println("new:"+new String(data,"utf-8"));
			}*/
			socket.close();
			return data; 
			//String result = new String(response.getData(), 0, response.getLength(), "ASCII"); 
		} catch (IOException e) { 
			socket.close();
			System.out.println("错误");
			// System.out.println("鍙戠敓閿欒");
			e.printStackTrace();
		}

		return null;
	} 
	
	public static byte[]  UDP_Rec_Event_method(byte[] revdata, int length)
	{
		 
		if (revdata[0] == (byte)0xaa && length >= 9)
		{
			int dataLen = revdata[5] * 256 + revdata[6];
			byte[] data = new byte[dataLen];
			int packageLen = dataLen + 9;
			//byte[] packge = new byte[packageLen];

			if (length >= packageLen)
			{
				CRC16 crc16 = new CRC16(); 
				crc16.update(revdata, 0, packageLen - 2);
				 
				int crc = (int)crc16.getValue();//McuCommon.CRC16_Calculate(revdata, 0, packageLen - 2);
				//System.out.println(crc16.getHexValue());
				
				if (revdata[packageLen - 2] == (byte)(crc / 256) && revdata[packageLen - 1] == (byte)(crc % 256))
				{
					System.arraycopy(revdata, 7, data, 0, dataLen);
					//System.out.println(CRC16.bytesToHex(data));
					return data;
					//String temp = revdata[1].ToString("X2"); 
					//temp += revdata[2].ToString("X2"); 
					//AddAppdebugInfo("UDP鏀跺埌鍛戒护锛�" + temp);
				}
				else
				{
					return null;
				} 
				//int intRC = revdata[3] * 256 + revdata[4];
 
			}
		} 
		return null;
	}
	/**
	 * @param hostname
	 * @param port
	 * @param hexheat
	 * @param body
	 * @return
	 */
	public static byte[] send(String hostname,int port,String hexhead,String body) {
		return Udp.send(hostname, port, hexhead, body.getBytes());
	}
	/**
	 * @param hostname
	 * @param port
	 * @param hexheat
	 * @param body
	 * @return
	 */
	public static Map<String,byte[]> sendAll(String hostname,int port,String hexhead,String body,int outtime) {
		return Udp.sendAll(hostname, port, hexhead, body.getBytes(), outtime);
	}
	/**
	 * 鑾峰彇骞挎挱鍦板潃
	 * @return
	 */
	public static List<String> getBcstAddr(){
		List<String> ls = Udp.getLocalIPList();
		List<String> addr = new ArrayList<String>();
		for(String adr:ls) {
			String[] tmps = adr.split("\\.");
			String tmp = tmps[0]+"."+tmps[1]+"."+tmps[2]+".255";
			addr.add(tmp);
		}
		return addr;
	}
	/**
	 * 鑾峰彇鍦ㄧ嚎璁惧
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static Map<String,String> getOnline() throws UnsupportedEncodingException {
		Map online = new HashMap<String,String>();
		List<String> ls = Udp.getBcstAddr();
		for(String addr : ls) {
			//System.out.println(addr);
			byte[] bt = Udp.send(addr, PORT, "0006", "1");
			if(bt!=null) {
				//String result = CRC16.bytesToHex(bt);
				byte[] p = new byte[1];
				p[0] = 0;
				String tmp = new String(bt);
				online.put(tmp.split(new String(p))[1], tmp); 
			} 
		}
		return online;
	}
	public final static int PORT = 50000;
	//private static final String  HOSTNAME= "192.168.8.255"; 
	public static void main(String[] args) throws UnsupportedEncodingException {
		Map map = Udp.getOnline();
		System.out.println(map);
		//byte[] bt = Udp.send("192.168.8.112", 50000, "a00c","");0300
		//byte[] bt = Udp.send("192.168.8.112",50000, "0006","");
		/*if(bt==null) {
			
		}else {
			String result = CRC16.bytesToHex(bt);
			System.out.println(result.length());
			System.out.println(result);
			System.out.println(new String(bt));//0101010101010101010101010101
		} */
		
		//Udp.send(HOSTNAME, PORT, "0006", "b");
	}
}
