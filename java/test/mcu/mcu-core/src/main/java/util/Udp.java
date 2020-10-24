package util;

 
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
/**
 * @author bean
 */
public class Udp {
	/**
	 * 获取当前ip地址
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
	 * 广播发送
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
			byte[] bttmp = CRC16.toBytes(hexstring);
			crc.update(bttmp,0,bttmp.length);
			hexstring+=crc.getHexValue(); 
			byte[] bt = CRC16.toBytes(hexstring); 
			//指定包要发送的目的地
			DatagramPacket request = new DatagramPacket(bt, bt.length, host, port);
			//为接受的数据包创建空间
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
	
	/**
	 * @param hostname
	 * @param port
	 * @param hexheat
	 * @param body
	 * @return
	 */
	public static byte[] send(String hostname,int port,String hexhead, byte[] strb) { 
		//传入0表示让操作系统分配一个端口号
		try (DatagramSocket socket = new DatagramSocket(0)) {
			socket.setSoTimeout(500);
			InetAddress host = InetAddress.getByName(hostname);  
			CRC16 crc = new CRC16(); 
			//byte[] strb = body.getBytes(); 
			String body = CRC16.bytesToHex(strb);
			short length	=	(short) (body.length()/2); 
			String hexlength=	CRC16.getUnsignedByte(length); 
			String hexstring = "aa"+hexhead+hexlength+body; 
			byte[] bttmp = CRC16.toBytes(hexstring);
			crc.update(bttmp,0,bttmp.length); 
			hexstring+=crc.getHexValue();
			//System.out.println(hexstring);
			
			byte[] bt = CRC16.toBytes(hexstring);
			//byte[] bt = CRC16.toBytes("aa000d0000db89");  
			//指定包要发送的目的地
			DatagramPacket request = new DatagramPacket(bt, bt.length, host, port);
			//为接受的数据包创建空间
			DatagramPacket response = new DatagramPacket(new byte[16000], 16000);
			socket.send(request);
			socket.receive(response);  
			byte[] revdata = response.getData(); 
			//response.getData() 
			//String result = CRC16.bytesToHex(revdata);
			//System.out.println(result);
			byte[] data=UDP_Rec_Event_method(revdata,revdata.length);
			/*if(data!=null) {
				System.out.println("new:"+new String(data,"utf-8"));
			}*/
			return data; 
			//String result = new String(response.getData(), 0, response.getLength(), "ASCII"); 
		} catch (IOException e) {
			//e.printStackTrace();
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
					//AddAppdebugInfo("UDP收到命令：" + temp);
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
	 * 获取广播地址
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
	 * 获取在线设备
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
