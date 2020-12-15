import java.nio.ByteOrder;

import com.iot.gateway.core.util.CRC16;
import com.iot.gateway.core.util.LittleByteUtil;
import com.vsdata.melsec.client.MelsecClientConfig;
import com.vsdata.melsec.client.MelsecTcpClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ttt {
	public static byte[] getByte(byte[] bt) {
		for(int i=0;i<bt.length;i+=2) {
			byte t = bt[i];
			bt[i] = bt[i+1];
			bt[i+1]=t;
		} 
		return bt;
	}
	 public static void main(String[] args) {
	    	MelsecClientConfig config = new MelsecClientConfig.Builder("192.168.8.10").setPort(8000).build();
	        MelsecTcpClient client = MelsecTcpClient.create3EBinary(config);
	        client.batchRead("D2210",2)
            .thenAccept(response -> {
            	byte[] bt = response.array();
            	System.out.println("xx");
            	//System.out.println(LittleByteUtil.getFloat(getByte(bt)));
            	//response.order().BIG_ENDIAN 
            	//System.out.println(response.order(ByteOrder.nativeOrder()).readFloat());
            	//response.set
            	//System.out.println(response.read);
            	//System.out.println("data :"+CRC16.bytesToHex(response.array()));
                //System.out.println(CRC16.bytesToBinAll(response.array()));
            	
				/*
				 * System.out.println("M100: " + response.readBoolean());
				 * System.out.println("M101: " + response.readBoolean());
				 * System.out.println("M102: " + response.readBoolean());
				 */
            })
            .exceptionally(ex -> {
                ex.printStackTrace();
                return null;
            });
//	        
//	        ByteBuf data1 = Unpooled.buffer(10);
//	        data1.writeShort(1);
//	        data1.writeShort(2);
//	        data1.writeShort(3);
//	        data1.writeShort(4);
	        //data1.writeFloat(-1919.99f);
	        //data1.writeFloatLE(-1919.99f);
	        //data1.writeBytes(getByte(LittleByteUtil.getShortBytes(Short.parseShort("2"))));
	        //data1.writeBytes(getByte(LittleByteUtil.getShortBytes(Short.parseShort("2"))));
	        //data1.writeBytes(getByte(LittleByteUtil.getShortBytes(Short.parseShort("3"))));
	       //data1.writeBytes(getByte(LittleByteUtil.getShortBytes(Short.parseShort("4"))));
	        //data1.writeBytes(getByte(LittleByteUtil.getShortBytes(Short.parseShort("5"))));
	        
	        //System.out.println("write:"+CRC16.bytesToHex(data1.array()));
//	        data1.writeShort(1);
//	        data1.writeShort(2);
//	        data1.writeShort(3);
//	        data1.writeShort(4);
//	        data1.writeShort(5);
//	        System.out.println("write:"+CRC16.bytesToHex(data1.array()));
//	        
//	        ByteBuf temp = Unpooled.copiedBuffer(data1.array());
//	        System.out.println(temp.readShort());
//	        System.out.println(temp.readShort());
//	        System.out.println(temp.readShort());
//	        System.out.println(temp.readShort());
//	        System.out.println(temp.readShort());
	        //client.batchWrite("D3030", 5, data1);
	       /*Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
	            client.batchRead("M200", 2)
	                .thenAccept(response -> {
	                    System.out.println("M200: " + response.readBoolean());
	                    System.out.println("M201: " + response.readBoolean());
	                })
	                .exceptionally(ex -> {
	                    ex.printStackTrace();
	                    return null;
	                });
	            client.batchRead("D200", 2)
	                .thenAccept(response -> {
	                    System.out.println("D200: " + response.readShort());
	                    System.out.println("D201: " + response.readShort());
	                })
	                .exceptionally(ex -> {
	                    ex.printStackTrace();
	                    return null;
	                });
	        }, 800, 800, TimeUnit.MILLISECONDS);*/
	    }
}
