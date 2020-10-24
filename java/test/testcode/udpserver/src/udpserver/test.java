package udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class test {

	public static void main1(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int serverPort = 50000;
        DatagramSocket ds = null;
        DatagramPacket sendDp;
        DatagramPacket receiveDp;
        ds = new DatagramSocket(serverPort);
        System.out.println("服务器创建成功！端口号为： "+ds.getLocalPort());
        
        byte[] buf = new byte[1024];
        receiveDp = new DatagramPacket(buf,buf.length);
        while(true) { 
	        ds.receive(receiveDp);
	        System.out.println("收到： "+ receiveDp.getSocketAddress());
	        System.out.println("Data is "+ new String(receiveDp.getData(),0,receiveDp.getLength()));
	        
	        InetAddress clientIp = receiveDp.getAddress();
	        System.out.println(clientIp.toString().substring(1));
	        int clientPort = receiveDp.getPort();
	
	        String respose = "aa0006000131c6d8";
	        byte[] bData = respose.getBytes();
	        sendDp = new DatagramPacket(bData,bData.length,clientIp,clientPort);
	        ds.send(sendDp);
        }
        //ds.close();
	}

}
