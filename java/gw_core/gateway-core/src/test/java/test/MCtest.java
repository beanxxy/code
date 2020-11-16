package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.vsdata.melsec.client.MelsecClientConfig;
import com.vsdata.melsec.client.MelsecTcpClient;

public class MCtest {
	public static int key = 1;
	public static Map<String,MelsecTcpClient> clients 			= new ConcurrentHashMap<String,MelsecTcpClient>(); 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MelsecClientConfig config ;//= new MelsecClientConfig.Builder("172.28.12.8").setPort(8000).build();
	    MelsecTcpClient client ;//= MelsecTcpClient.create3EBinary(config);
	    config =  new MelsecClientConfig.Builder("172.28.12.6").setPort(8000).build();
    	client = MelsecTcpClient.create3EBinary(config);
    	config =  new MelsecClientConfig.Builder("172.28.12.6").setPort(8000).build();
     	client = MelsecTcpClient.create3EBinary(config);
    	while(true) { 
    		if(key==1) {
    			//key = 0;
		    	client.batchRead("D3011", 2).thenAccept(response->{
		    		key=1;
		    		System.out.println("D3011:"+response.readShort()); 
		    	}).exceptionally(ex -> {
		    		key=1;
		            ex.printStackTrace();
		            return null;
		        });
		    	
		    	client.batchRead("D3010", 2).thenAccept(response->{
		    		key=1;
		    		System.out.println("D3010:"+response.readShort()); 
		    	}).exceptionally(ex -> {
		    		key=1;
		            ex.printStackTrace();
		            return null;
		        }); 
		    	client.batchRead("D3010", 2).thenAccept(response->{
		    		key=1;
		    		System.out.println("D3010:"+response.readShort()); 
		    	}).exceptionally(ex -> {
		    		key=1;
		            ex.printStackTrace();
		            return null;
		        });
    		}
    		
    		try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}

}
