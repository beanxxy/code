import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.vsdata.melsec.client.MelsecClientConfig;
import com.vsdata.melsec.client.MelsecTcpClient;

import io.netty.buffer.ByteBufUtil;

public class tt {
	static MelsecClientConfig config ;// new MelsecClientConfig.Builder("172.28.12.6").setPort(8000).build();
    static MelsecTcpClient client ;//= MelsecTcpClient.create3EBinary(config);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**String bint = "0010";
		int i = Integer.parseInt(bint, 2);
		int i1 = 1<<0;
				//Integer.parseInt("100", 2);
		System.out.println((i&i1)==i1);*/
		config = new MelsecClientConfig.Builder("172.28.12.6").setPort(8000).build();
        client = MelsecTcpClient.create3EBinary(config);
        List<String> ls = new ArrayList<String>();
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
			
			client.connect();
	        ls.add("D2250");
	        ls.add("D3010");
			for(String s : ls) {
				client.batchRead(s, 2) .thenAccept(response -> {
	            	 System.out.println(s+":" + response.readShort());
	            }).exceptionally(ex -> {
	                ex.printStackTrace();
	                
	                client.disconnect();
	                config = new MelsecClientConfig.Builder("172.28.12.6").setPort(8000).build();
	                MelsecTcpClient.create3EBinary(config);
	                return null;
	            }); 
	           /*client.batchRead(s, 2) .thenAccept(response -> {
	                //System.out.println(ByteBufUtil.hexDump(response));
	                System.out.println("D3010: " + response.readShort());
	                //System.out.println("M101: " + response.readBoolean());
	                //System.out.println("M102: " + response.readBoolean());
	            })
	            .exceptionally(ex -> {
	                ex.printStackTrace();
	                return null;
	            });*/
			}
			//client.disconnect();
	     }, 1000, 1000, TimeUnit.MILLISECONDS);
		
	}

}
