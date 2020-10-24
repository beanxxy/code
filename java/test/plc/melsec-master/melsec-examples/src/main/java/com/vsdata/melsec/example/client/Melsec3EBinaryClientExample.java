package com.vsdata.melsec.example.client;

import com.vsdata.melsec.client.MelsecClientConfig;
import com.vsdata.melsec.client.MelsecTcpClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xxybean
 */
public class Melsec3EBinaryClientExample {
	public static byte[] getByte(byte[] bt) {
		for(int i=0;i<bt.length;i+=2) {
			byte t = bt[i];
			bt[i] = bt[i+1];
			bt[i+1]=t;
		} 
		return bt;
	}
    public static void main(String[] args) {
    	MelsecClientConfig config = new MelsecClientConfig.Builder("172.28.12.8").setPort(8000).build();
        MelsecTcpClient client = MelsecTcpClient.create3EBinary(config);
        /*
        //client.connect(); 
        ByteBuf data = Unpooled.buffer(8);
        data.writeBoolean(false);
        data.writeBoolean(true);
        data.writeBoolean(false);
        data.writeBoolean(false);
        data.writeBoolean(true);
        data.writeBoolean(false);
        data.writeBoolean(true);
        data.writeBoolean(true);
         
        client.batchRead("D5000", 16)
        .thenAccept(response -> {
            //System.out.println(ByteBufUtil.hexDump(response)); 
            //System.out.println(ByteBufUtil.de);  
            System.out.println("D5000: " + response.readShort()); 
            System.out.println("D5001: " + response.readShort()); 
            System.out.println("D5002: " + response.readShort());  
            //response.
            //System.out.println("M100: " + response.readInt()); 
            //System.out.println("M100: " + response.readDouble());   
        });
        client.batchWrite("M100", 8, data)
        .thenCompose(r -> client.batchRead("M100", 8))
        .thenAccept(response -> {
            System.out.println(ByteBufUtil.hexDump(response));
        })
        .exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        }); 
         Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
            client.batchRead("D100", 3)
                .thenAccept(response -> {
                    System.out.println(ByteBufUtil.hexDump(response));
                    System.out.println("D100: " + response.readShort());
                    System.out.println("D101: " + response.readShort());
                    System.out.println("D102: " + response.readShort());
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
            client.batchRead("M100", 3)
                .thenAccept(response -> {
                    System.out.println(ByteBufUtil.hexDump(response));
                    System.out.println("M100: " + response.readBoolean());
                    System.out.println("M101: " + response.readBoolean());
                    System.out.println("M102: " + response.readBoolean());
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
        }, 1000, 1000, TimeUnit.MILLISECONDS);
        
        
       */
        ByteBuf data1 = Unpooled.buffer(4);
        byte[] bt = LittleByteUtil.getIntBytes(Integer.parseInt("14320"));
        bt = getByte(bt); 
        data1.writeBytes(bt);
        //data1.writeShort(1234);
        //data1.writeShort(4610);
        //data1.writeShort(4400);

        client.batchWrite("D100", 1, data1)
        .thenCompose(r -> client.batchRead("D100", 3))
        .thenAccept(response -> {
            System.out.println("D100: " + response.readShort());
            //System.out.println("D101: " + response.readShort());
            //System.out.println("D102: " + response.readShort());
        })
        .exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        
        
        System.out.println("ore " ); 
		/*
		 * .exceptionally(ex -> { ex.printStackTrace(); return null; });
		 */
        //client.batchRead("M100", 8) 
        
        /*client.batchWrite("M100", 8, data)
            .thenCompose(r -> client.batchRead("M100", 8))
            .thenAccept(response -> {
                System.out.println(ByteBufUtil.hexDump(response));
            })
            .exceptionally(ex -> {
                ex.printStackTrace();
                return null;
            });

        ByteBuf data1 = Unpooled.buffer(6);
        data1.writeShort(6549);
        data1.writeShort(4610);
        data1.writeShort(4400);

        client.batchWrite("D100", 3, data1)
            .thenCompose(r -> client.batchRead("D100", 3))
            .thenAccept(response -> {
                System.out.println("D100: " + response.readShort());
                System.out.println("D101: " + response.readShort());
                System.out.println("D102: " + response.readShort());
            })
            .exceptionally(ex -> {
                ex.printStackTrace();
                return null;
            });

        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
            client.batchRead("D100", 3)
                .thenAccept(response -> {
                    System.out.println(ByteBufUtil.hexDump(response));
                    System.out.println("D100: " + response.readShort());
                    System.out.println("D101: " + response.readShort());
                    System.out.println("D102: " + response.readShort());
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
            client.batchRead("M100", 3)
                .thenAccept(response -> {
                    System.out.println(ByteBufUtil.hexDump(response));
                    System.out.println("M100: " + response.readBoolean());
                    System.out.println("M101: " + response.readBoolean());
                    System.out.println("M102: " + response.readBoolean());
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
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
