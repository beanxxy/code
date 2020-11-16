package gateway.core.imp;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vsdata.melsec.client.MelsecClientConfig;
import com.vsdata.melsec.client.MelsecTcpClient;

import gateway.core.Client;
import gateway.core.config.DataModel;
import gateway.core.config.Ioinfo;
import gateway.core.util.CRC16;
import gateway.core.util.LittleByteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class MelseClient implements Client{
	MelsecClientConfig config ;//= new MelsecClientConfig.Builder("172.28.12.8").setPort(8000).build();
    MelsecTcpClient client ;//= MelsecTcpClient.create3EBinary(config);
    static Map<String,Integer> maplength = new HashMap<String,Integer>(); 
    public MelseClient(Ioinfo address) {
    	maplength.put("short",1);
    	maplength.put("int",2);
    	maplength.put("float",2);
    	maplength.put("double",4);
    	maplength.put("bit",2); 
    	
    	config = new MelsecClientConfig.Builder(address.ip).
				setPort(address.port).build();
    	client = MelsecTcpClient.create3EBinary(config);
    }
    
	public static Client create(Ioinfo address) { 
		return new MelseClient(address);
	}
	/**
	 * 高低位
	 * 
	 * @param bt
	 * @return
	 */
	public static byte[] getByte(byte[] bt) {
		for(int i=0;i<bt.length;i+=2) {
			byte t = bt[i];
			bt[i] = bt[i+1];
			bt[i+1]=t;
		} 
		return bt;
	}
	/**
	 * 转出去的地址转换
	 * @param addr
	 * @return
	 */
	public String convertAddr(String addr) {  
		switch(addr.charAt(0)) {
		case 'x':
		case 'X':
		case 'y':
		case 'Y':
			return addr.charAt(0)+Integer.toHexString(Integer.valueOf(addr.substring(1), 8));
		}
		return addr;
	}
	@Override
	public CompletableFuture<String> batchRead(Ioinfo address) {
		// TODO Auto-generated method stub
		CompletableFuture<String> future = new CompletableFuture<>();  
		String[] addr = address.dataAddr.split("-");
		
		client.batchRead(convertAddr(addr[0]),maplength.get(address.dataModel)).thenAccept(response -> {
			byte[] bt = response.array(); 
			//System.out.println( CRC16.bytesToHex(bt)); 
			//bt = getByte(bt); 
			String r = "";
			//System.out.println(CRC16.bytesToHex(bt)); 
			switch (address.dataModel) {
			case "bit": 
				int adi = 0;
				if(addr.length>1) {
					adi = Integer.parseInt(addr[1]);
				} 
				r = CRC16.bytesToBin(bt).charAt(15-adi)+"";
				break;
			case "short":
				bt = getByte(bt); 
				r = LittleByteUtil.getShort(bt)+"";
				break; 
			case "int":
				bt = getByte(bt); 
				r = LittleByteUtil.getInt(bt)+"";
				break; 
			case "float": 
				bt = getByte(bt); 
				r = LittleByteUtil.getFloat(bt)+"";
				break; 
			case "double": 
				r = LittleByteUtil.getDouble(bt)+"";
				break;  
			}
            future.complete(r);
        }); 
		
		return future;
	}
	public void writeByModel(String data,Ioinfo address) {
		List<DataModel> ls= ClientTcp.datamap.get(address.dataModel);
		//ls.ad)
		if(ls!=null) {
			Map<String,String> map = new Gson().fromJson(data,new TypeToken<Map<String,String>>(){}.getType());
			Collections.sort(ls,new Comparator<DataModel>() { public int compare(DataModel o1, DataModel o2) { 
					if(o1.index > o2.index) { return 1;
					}else if(o1.index < o2.index) { return -1;
					} return 0;
				} 
			});
			int length = 0; 
			for(DataModel dm : ls) {
				//System.out.println(dm.name);
				//System.out.println(map.get(dm.name+"").toString()+"");
				String value = map.get(dm.name+"").toString()+"";  
				address.dataModel = dm.datatype;
				address.dataAddr = address.dataAddr.charAt(0)+""+(Integer.parseInt(address.dataAddr.substring(1))+length);
				length = (dm.length/2); 
				this.batchWrite(address, value);  
			}
		}
		 
	}
	@Override
	public CompletableFuture<Void> batchWrite(Ioinfo address, String data) {
		// TODO Auto-generated method stub
		CompletableFuture<Void> future = new CompletableFuture<>();
		String[] addr = address.dataAddr.split("-");
		ByteBuf dat = null;//Unpooled.copiedBuffer("".getBytes());
        int length = 0;
        byte[] bt; 
        System.out.println(data);
        int tmp = 0;
		switch (address.dataModel) {
		case "bit":
			//if
			if(addr[0].charAt(0)=='m'||
			   addr[0].charAt(0)=='M'||
			   addr[0].charAt(0)=='x'||
			   addr[0].charAt(0)=='X'||
			   addr[0].charAt(0)=='Y'||
			   addr[0].charAt(0)=='y'||
			   addr[0].charAt(0)=='L'||
			   addr[0].charAt(0)=='l'||
			   addr[0].charAt(0)=='V'||
			   addr[0].charAt(0)=='v'||
			   addr[0].charAt(0)=='B'||
			   addr[0].charAt(0)=='b') {
				dat = Unpooled.buffer(1);//addr[1]   16 15 14 13 12 10 11
				if(data.equals("0")) dat.writeBoolean(false);
				else dat.writeBoolean(true); 
			}else {
				Ioinfo addrs = new Ioinfo();
				addrs.dataAddr = addr[0];
				addrs.dataModel = "short";
				this.batchRead(addrs).thenAccept(s->{ 
					s= setInt(Integer.parseInt(addr[1]),Integer.parseInt(s),Integer.parseInt(data))+""; 
					this.batchWrite(addrs, s).thenAccept(ss->{
						future.complete(null);
					}); 
				}); 
				return future;
			}
			break;
		case "short": 
			bt = LittleByteUtil.getIntBytes(Integer.parseInt(data));
			bt = getByte(bt); 
			dat = Unpooled.buffer(2);
			dat.writeBytes(bt,0,2);  
			break; 
		case "int":
			bt = LittleByteUtil.getIntBytes(Integer.parseInt(data));
			bt = getByte(bt);
			dat = Unpooled.buffer(4);
			dat.writeBytes(bt); 
			break; 
		case "float": 
			bt = LittleByteUtil.getFloatBytes(Float.parseFloat(data));
			bt = getByte(bt);
			dat = Unpooled.buffer(4);
			dat.writeBytes(bt); 
			break; 
		case "double": 
			bt = LittleByteUtil.getDoubleBytes(Double.parseDouble(data));
			bt = getByte(bt);
			dat = Unpooled.buffer(8);
			dat.writeBytes(bt); 
			break;  
		default :
			writeByModel(data,address);  
			tmp=1;
		}
		//System.out.println(CRC16.bytesToHex(dat.array()));
	   //System.out.println("l"+maplength.get(address.dataModel));
		System.out.println("wr "+addr[0]+"-"+maplength.get(address.dataModel)+"-"+data);
       if(tmp==0) {
    	   client.batchWrite(convertAddr(addr[0]), maplength.get(address.dataModel), dat) 
           .thenAccept(response -> { 
           		System.out.println("over:"+addr[0]+"-"+maplength.get(address.dataModel)+"-"+data);
           		future.complete(null);
           }); 
       }else {
    	   future.complete(null);
       }
		
	   return future;
	}
	public static int setInt(int index,int num,int value) {
		int tmp = 1 << index;
		if(value==0) {
			return ~tmp & num;
		}else {
			return tmp | num;
		} 
		//System.out.println()
	}
}