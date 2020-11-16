package test;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.vsdata.melsec.client.MelsecClientConfig;
import com.vsdata.melsec.client.MelsecTcpClient;

public class MCtest3 {
	public static int key = 1;
	public static Map<String,MelsecTcpClient> clients 			= new ConcurrentHashMap<String,MelsecTcpClient>(); 
	public static MelsecClientConfig config ;//= new MelsecClientConfig.Builder("172.28.12.8").setPort(8000).build();
	public static MelsecTcpClient client ;//= MelsecTcpClient.create3EBinary(config);
	public static long time = new Date().getTime(); 
	public static long sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
	    config =  new MelsecClientConfig.Builder("172.28.12.6").setPort(8000).build();
    	client = MelsecTcpClient.create3EBinary(config);  
    	read();
	} 
	public static void read() { 
		sum++;
		time = new Date().getTime();
		client.batchRead("D301"+(sum%2), 10).thenAccept(response->{
    		System.out.println("D301"+(sum%2)+":"+response.array().length);
    		System.out.println(new Date().getTime()-time);
    		read();
    	}).exceptionally(ex -> {
    		System.out.println("xd");
    		ex.printStackTrace();
            return null;
        });  
	}

}
