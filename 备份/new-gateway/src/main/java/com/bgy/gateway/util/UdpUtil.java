package com.bgy.gateway.util;


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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * @author bean
 */
public class UdpUtil {
	private static final Logger logger = LoggerFactory.getLogger(UdpUtil.class);
	public static int interval = 50;
	
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
        	logger.error("error {}", e);
        }
        return ipList;
    }
	/**
	 * 广播发送
	 * @return
	 */
	public static Map<String,byte[]> sendAll(String hostname,int port,String hexhead, byte[] strb,int outtime){ 
		if(outtime==0) {
			outtime = 1000;
		}
		String[] tmps = hostname.split("\\.");
		String tmp = tmps[0]+"."+tmps[1]+"."+tmps[2]+".255";
		hostname = tmp;
		Map<String,byte[]> map = new HashMap<String,byte[]>();
		try (DatagramSocket socket = new DatagramSocket(0)) {
			socket.setSoTimeout(outtime);
			InetAddress host = InetAddress.getByName(hostname);  
			CRC16Util crc = new CRC16Util();   
			String body = CRC16Util.bytesToHex(strb);
			short length	=	(short) (body.length()/2); 
			String hexlength=	CRC16Util.getUnsignedByte(length); 
			String hexstring = "aa"+hexhead+hexlength+body;  
			byte[] sendbt = CRC16Util.toBytes(hexstring);
			crc.update(CRC16Util.toBytes(hexstring),0,sendbt.length);
			hexstring+=crc.getHexValue(); 
			byte[] bt = CRC16Util.toBytes(hexstring); 
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
			logger.error("error {}", e);
		}
		return map; 
	}
	
	public CompletableFuture<byte[]> sendbyFuture(String hostname,int port,String hexhead, byte[] strb){
		CompletableFuture<byte[]> future = new CompletableFuture<>(); 
		
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
			e1.printStackTrace();
		}
		
		//传入0表示让操作系统分配一个端口号 
		DatagramSocket socket = null;
		try {
			 
			socket 	= new DatagramSocket(0);
			 
			socket.setSoTimeout(1000); 
			InetAddress host = InetAddress.getByName(hostname);  
			CRC16Util crc = new CRC16Util(); 
		 
			String body = CRC16Util.bytesToHex(strb);
			short length	=	(short) (body.length()/2); 
			String hexlength=	CRC16Util.getUnsignedByte(length); 
			String hexstring = "aa"+hexhead+hexlength+body;  
			byte[] sendbt = CRC16Util.toBytes(hexstring);
			crc.update(CRC16Util.toBytes(hexstring),0,sendbt.length); 
			hexstring	+=	crc.getHexValue(); 
			byte[] bt = CRC16Util.toBytes(hexstring);
		 
			//指定包要发送的目的地
			DatagramPacket request = new DatagramPacket(bt, bt.length, host, port);
			
			byte[] revdata = getByte(hostname,port);
			
			//为接受的数据包创建空间
			DatagramPacket response = new DatagramPacket(revdata, revdata.length); 
		 
			socket.send(request);
 
			socket.receive(response); 
		 
			String result = CRC16Util.bytesToHex(revdata);
			 
			byte[] data=UDP_Rec_Event_method(revdata,revdata.length);
			 
			socket.disconnect();
			socket.close();
			return data; 
			 
		} catch (IOException e) { 
			socket.disconnect();
			socket.close(); 
			logger.error("error {}", e);
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

			if (length >= packageLen)
			{
				CRC16Util crc16 = new CRC16Util(); 
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
		return UdpUtil.send(hostname, port, hexhead, body.getBytes());
	}
	/**
	 * @param hostname
	 * @param port
	 * @param hexheat
	 * @param body
	 * @return
	 */
	public static Map<String,byte[]> sendAll(String hostname,int port,String hexhead,String body,int outtime) {
		return UdpUtil.sendAll(hostname, port, hexhead, body.getBytes(), outtime);
	}
	/**
	 * 获取广播地址
	 * @return
	 */
	public static List<String> getBcstAddr(){
		List<String> ls = UdpUtil.getLocalIPList();
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
		List<String> ls = UdpUtil.getBcstAddr();
		for(String addr : ls) {
			byte[] bt = UdpUtil.send(addr, PORT, "0006", "1");
			if(bt!=null) {
				byte[] p = new byte[1];
				p[0] = 0;
				String tmp = new String(bt);
				online.put(tmp.split(new String(p))[1], tmp); 
			} 
		}
		return online;
	}
	public final static int PORT = 50000;  
}
