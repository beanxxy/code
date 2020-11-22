package com.iot.gateway.core.imp;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;

import com.iot.gateway.core.Connection;
import com.iot.gateway.core.DataModel;
import com.iot.gateway.core.Ioinfo;
import com.iot.gateway.core.util.CRC16;
import com.iot.gateway.core.util.LittleByteUtil;
import com.iot.gateway.core.util.Udp;

/**
 * @author bean
 * 2020年11月14日
 */
public class McuConn implements Connection{

	@Override
	public CompletableFuture<String> batchRead(Ioinfo address) {
		CompletableFuture<String> future = new CompletableFuture<>(); 
		String[] addr = address.dataAddr.split("-");  
		byte[] bt = null;
		bt = Udp.send(address.ip, address.port, addr[0],""); 
		if(bt==null) {
			future.completeExceptionally(new Exception());
		}else {
			String r =  decode(address,bt); 
			future.complete(r); 
		} 
		return future;
	}

	@Override
	public CompletableFuture<String> batchWrite(Ioinfo address, String data) {
		CompletableFuture<String> future = new CompletableFuture<>(); 
		String[] addr = address.dataAddr.split("-");  
		byte[] bt = null;
		bt = Udp.send(address.ip, address.port, addr[0],data); 
		if(bt==null) {
			future.completeExceptionally(new Exception());
		}else {
			//String r =  decode(address,bt); 
			future.complete(""); 
		} 
		return future;
	}

	public static String decode(String dataAddr,String datamodel,byte[] bt) {
		String r = "";
		String[] addr = null;
		if(dataAddr!=null&&dataAddr.length()>0)addr = dataAddr.split("-"); 
		switch (datamodel) {
		case "bit": 
			int adi = 0;
			if(addr.length>1) {
				adi = Integer.parseInt(addr[1]);
				r = CRC16.bytesToBinAll(bt).charAt(15-adi)+"";
			}else {
				r = CRC16.bytesToBinAll(bt).charAt(0)+"";
			}
			break;
		case "byte":
			r = bt[0]+"";
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
			bt = getByte(bt);
			r = LittleByteUtil.getDouble(bt)+"";
			break;  
		case "string": 
			r = new String(bt);
			break;  
		case "hex":
			r = CRC16.bytesToHex(bt);
			break;
		 default :
			List<DataModel> ls= ClientTcp.datamap.get(datamodel);
			Collections.sort(ls,new Comparator<DataModel>() { public int compare(DataModel o1, DataModel o2) { 
				if(o1.index > o2.index) { return 1;
				}else if(o1.index < o2.index) { return -1;
				} return 0;
				} 
			});
			if(ls!=null) {
				int istar = 0;
				Map ans = new HashMap<String,String>();
				Gson gson = new Gson();
				for(DataModel dm : ls) {
					byte[] bts = new byte[dm.length];
					System.arraycopy(bt, istar, bts, 0, dm.length);
					istar+=dm.length;
					String value = decode(dataAddr,dm.datatype,bts);
					ans.put(dm.name, value);
				}
				r = gson.toJson(ans);
				//JSONObject jsonObj = JSONObject.fromObject(json); 
			}
		}
		return r;
	}
	public static String decode(Ioinfo address,byte[] bt) { 
		return decode(address.dataAddr,address.dataModel,bt);
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
	
	public static byte[] encode(String datamodel,String data,int len) {
		byte[] ans = new byte[len];
		switch (datamodel) {
		case "bit": 
			if(data.equals("1")){
				ans[0] = 1;
			}else {
				ans[0] = 0;
			}
			break;
		case "byte": 
			ans[0] = LittleByteUtil.getIntBytes(Integer.parseInt(data))[1];
			break; 
		case "short": 
			ans = LittleByteUtil.getShortBytes(Short.parseShort(data));
			ans = getByte(ans);
			break;
		case "int": 
			ans = LittleByteUtil.getIntBytes(Integer.parseInt(data));
			ans = getByte(ans);
			break;
		case "float": 
			ans  = LittleByteUtil.getFloatBytes(Float.parseFloat(data));
			ans  = getByte(ans);
			break;
		case "double": 
			ans = LittleByteUtil.getDoubleBytes(Double.parseDouble(data));
			ans = getByte(ans);
			break;
		case "string": 
			ans = data.getBytes();
			break; 
		 default :
			List<DataModel> ls= ClientTcp.datamap.get(datamodel);
			Collections.sort(ls,new Comparator<DataModel>() { public int compare(DataModel o1, DataModel o2) { 
				if(o1.index > o2.index) { return 1;
				}else if(o1.index < o2.index) { return -1;
				} return 0;
				} 
			});
			Map map = new Gson().fromJson(data, Map.class);
			int length = 0;
			for(DataModel dm : ls) { length+=dm.length; } 
			ans = new byte[length];
			int tmplenth = 0;
			for(DataModel dm : ls) { 
				String value = map.get(dm.name)+"";
				if(value.equals(""))	value="";
				byte[] valuebt = encode(dm.datatype, value, dm.length);
				System.arraycopy(valuebt, 0, ans,tmplenth, dm.length);
				tmplenth+= dm.length;
			}
		}
		return ans;
	} 
	public static int getByType(String type) {
		int length = 0;
		switch(type) {
		case "bit": 
			length = 1;
			break;
		case "byte": 
			length = 1;
			break; 
		case "short": 
			length = 2;
			break;
		case "int": 
			length = 4;
			break;
		case "float": 
			length = 4;
			break;
		case "double": 
			length = 8;
			break;
		case "string": 
			length = 1;
			break; 
		 default :
		}
		return length;
	}
}
