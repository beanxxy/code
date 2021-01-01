package com.iot.gateway.core.util; 


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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import com.iot.check.AlarmEvent;

 
/**
 * @author bean
 */
public class Udp {
	static Logger logger = Logger.getLogger(Udp.class.getName());
	public static int interval = 200;
	
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
                    // IPV4
                    if (inetAddress != null && inetAddress instanceof Inet4Address) { 
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
			byte[] sendbt = CRC16.toBytes(hexstring);
			crc.update(CRC16.toBytes(hexstring),0,sendbt.length);
			hexstring+=crc.getHexValue(); 
			byte[] bt = CRC16.toBytes(hexstring); 
			//指定包要发送的目的地
			DatagramPacket request = new DatagramPacket(bt, bt.length, host, port);
			//为接受的数据包创建空间
			DatagramPacket response = new DatagramPacket(new byte[100], 100);
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
	
	
	public static Map<String,byte[]> hostdata = new ConcurrentHashMap<String,byte[]>();
	public static byte[] getByte(String hostname,int port) {
		byte[] tmp = hostdata.get(hostname+port); 
		if(tmp==null) {
			tmp = new byte[100];
			hostdata.put(hostname+port, tmp);
		}
		return tmp;
	}
	
	public static Map<String,DatagramSocket> DatagramSocketData = new ConcurrentHashMap<String,DatagramSocket>();
	public static DatagramSocket getDatagramSocketData(String hostname,int port) throws SocketException {
		DatagramSocket socket = DatagramSocketData.get(hostname+port);
		if(socket==null) {
			socket = new DatagramSocket(0); 
			DatagramSocketData.put(hostname+port, socket);
		}
		return socket; 
	}
	public static void closeDatagramSocketData(String hostname,int port) {
		DatagramSocketData.remove(hostname+port);
	}
	
	
	public static Map<String,DatagramPacket> requestDatagramPacket = new ConcurrentHashMap<String,DatagramPacket>();
	public static DatagramPacket getRequestDatagramPacket(int port,byte[] bt,InetAddress host,String hostname ) {
		String key = hostname+port;
		DatagramPacket tmp = requestDatagramPacket.get(key);  
		if(tmp==null) {
			tmp = new DatagramPacket(bt, bt.length, host, port); 
		}else {
			tmp.setAddress(host);
			tmp.setData(bt);
			tmp.setLength(bt.length);
			tmp.setPort(port);
		}
		requestDatagramPacket.put(key, tmp);
		return tmp;
	}
	
	public static Map<String,DatagramPacket> responseDatagramPacket = new ConcurrentHashMap<String,DatagramPacket>();
	public static DatagramPacket getResponseDatagramPacket(int port,byte[] bt,InetAddress host ,String hostname) {
		String key =hostname+port; 
		DatagramPacket tmp = responseDatagramPacket.get(key);  
		if(tmp==null) {
			tmp = new DatagramPacket(bt, bt.length); 
		}else { 
			tmp.setData(bt);
			tmp.setLength(bt.length); 
		}
		responseDatagramPacket.put(key, tmp);
		return tmp;
	}
	
	/**
	 * @param hostname
	 * @param port
	 * @param hexheat
	 * @param body
	 * @return
	 */
	public static byte[] send(String hostname,int port,String hexhead, byte[] strb) { 
		
		
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//传入0表示让操作系统分配一个端口号 
		DatagramSocket socket = null;
		try { 
			//DatagramSocket 
			//new DatagramSocket(0);
			socket 			= getDatagramSocketData(hostname,port) ;
			socket.setSoTimeout(1000); 
			InetAddress host = InetAddress.getByName(hostname);  
			//CRC16 crc = new CRC16(); 
			//byte[] strb = body.getBytes(); 
			String body 		= CRC16.bytesToHex(strb);
			short length		= (short) (body.length()/2); 
			String hexlength	= CRC16.getUnsignedByte(length); 
			String hexstring 	= "aa"+hexhead+hexlength+body;  
			//byte[] sendbt = CRC16.toBytes(hexstring);
			//crc.update(CRC16.toBytes(hexstring),0,sendbt.length); 
			//hexstring	+=	crc.getHexValue(); 
			hexstring	+= CRC16.update2(CRC16.toBytes(hexstring),0,hexstring.length() / 2); 
			byte[] bt 	=  CRC16.toBytes(hexstring);   
			//指定包要发送的目的地  new DatagramPacket(bt, bt.length, host, port);
			DatagramPacket request 	=  getRequestDatagramPacket( port,bt,host,hostname); 
			byte[] revdata 			=  getByte(hostname,port); 
			//为接受的数据包创建空间int port,byte[] bt,InetAddress host 	new DatagramPacket(revdata, revdata.length); 
			DatagramPacket response = getResponseDatagramPacket(port,revdata,host,hostname);
			socket.send(request); 
			socket.receive(response);  
			 
			return UDP_Rec_Event_method(revdata,revdata.length);  
		} catch (IOException e) { 
			//socket.disconnect();
			//socket.close();
			//closeDatagramSocketData( hostname, port);
			//logger.warning("发生错误:"+e.getMessage()+":"+hostname+":"+hexhead); 
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
				 
				int crc = (int)crc16.getValue(); 
				 
				
				if (revdata[packageLen - 2] == (byte)(crc / 256) && revdata[packageLen - 1] == (byte)(crc % 256))
				{
					System.arraycopy(revdata, 7, data, 0, dataLen); 
					return data; 
				}
				else
				{
					return null;
				} 
				 
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
	 
}
