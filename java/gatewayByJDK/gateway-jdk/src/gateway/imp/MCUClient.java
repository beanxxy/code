package gateway.imp;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import gateway.Client;
import gateway.config.DataModel;
import gateway.config.Ioinfo;
import gateway.model.McuData;
import gateway.util.CRC16;
import gateway.util.LittleByteUtil;
import gateway.util.Udp;
 

public class MCUClient implements Client{
	static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
	//ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
	public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); 
	//public static  Deque<McuData> rqueue = new LinkedList<McuData>();
	//public static  Deque<McuData> wqueue = new LinkedList<McuData>();
	public static  int MAX = 100;
	public static Map<String,Deque<McuData>> rmaxmap = new HashMap<String,Deque<McuData>>();
	public static Map<String,Deque<McuData>> wmaxmap = new HashMap<String,Deque<McuData>>();
	
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

	/*
	 * public static String encode(Ioinfo address,String json) {
	 * 
	 * return ""; }
	 */
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
	//public static Map<String,List>
	/*
	 * public String getDataByModel(String datamodel,byte[] bt,String addr) {
	 * List<DataModel> ls = ClientTcp.datamap.get(datamodel); if(ls==null)return "";
	 * Map<String,String> map = new HashMap<String,String>(); //ls.sort(c);
	 * Collections.sort(ls,new Comparator<DataModel>() {
	 * 
	 * @Override public int compare(DataModel o1, DataModel o2) { // TODO
	 * Auto-generated method stub if(o1.index > o2.index) { return 1; }else
	 * if(o1.index < o2.index) { return -1; } return 0; } }); for(DataModel dm : ls)
	 * { //dm.length //dm.datatype } return ""; }
	 */
	public static void execute(Deque<McuData> queue) {
		if(queue.size()!=0) {
			McuData md = queue.poll();
			CompletableFuture<String> future = md.future; 
			Ioinfo address = md.address; 
			String[] addr = address.dataAddr.split("-");  
			
			byte[] bt = null;
			if(md.wdata==null) {
				md.wdata="";
				bt = Udp.send(address.ip, address.port, addr[0],md.wdata); 
			} else {
				bt = Udp.send(address.ip, address.port, addr[0],encode(address.dataModel, md.wdata,getByType(address.dataModel))); 
			} 
			if(bt==null) { 
				queue.addFirst(md);
			} 
			String r =  decode(address,bt); 
			future.complete(r); 
		}
		//return queue;
	}
    static { 
		scheduledThreadPool.scheduleAtFixedRate(()->{
			for(String skey:rmaxmap.keySet()) {
				try { 
					Deque<McuData> rqueue  = rmaxmap.get(skey);
					//System.out.println(skey+"读:"+rqueue.size());
					execute(rqueue); 
				} catch (Throwable t) {
					//System.out.println("Error");
				}
			}
			
			
		}, 500, 100, TimeUnit.MILLISECONDS);
		
		scheduledThreadPool.scheduleAtFixedRate(()->{ 
			for(String skey:wmaxmap.keySet()) {
				try { 
					
					Deque<McuData> wqueue = wmaxmap.get(skey); 
					//System.out.println(skey+"写:"+wqueue.size());
					execute(wqueue);
				} catch (Throwable t) {
					//System.out.println("Error");
				} 
			}
		}, 500, 100, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public CompletableFuture<String> batchRead(Ioinfo address) { 
		// TODO Auto-generated method stub
		CompletableFuture<String> future = new CompletableFuture<>(); 
		
		//System.out.println(rqueue.size());
		Deque<McuData> rqueue = rmaxmap.get(address.ip);
		if(rqueue==null) {
			rqueue = new LinkedList<McuData>();
		}
		if(rqueue.size()>MAX)rqueue.poll();
		rqueue.addLast(new McuData(future,address));
		rmaxmap.put(address.ip, rqueue);
		/*cachedThreadPool.execute(()->{
			System.out.println("op"+address.ip);
			String[] addr = address.dataAddr.split("-"); 
			byte[] bt = Udp.send(address.ip, address.port, addr[0],""); 
			if(bt==null) {
				future.complete("空白");
			}
			System.out.println(address.ip);
			//System.out.println(bt.length);
			String r = "";
			switch (address.dataModel) {
			case "bit": 
				int adi = 0;
				if(addr.length>1) {
					adi = Integer.parseInt(addr[1]);
				} 
				r = CRC16.bytesToBinAll(bt).charAt(15-adi)+"";
				break;
			case "short": 
				r = LittleByteUtil.getShort(bt)+"";
				break; 
			case "int": 
				r = LittleByteUtil.getInt(bt)+"";
				break; 
			case "float":  
				r = LittleByteUtil.getFloat(bt)+"";
				break; 
			case "double": 
				r = LittleByteUtil.getDouble(bt)+"";
				break;  
			case "string":
				r = new String(bt);
				break;  
			} 
			future.complete(r);
		});
		System.out.println(address.ip);
		String[] addr = address.dataAddr.split("-"); 
		byte[] bt = Udp.send(address.ip, address.port, addr[0],""); 
		System.out.println(bt.length);
		String r = "";
		switch (address.dataModel) {
		case "bit": 
			int adi = 0;
			if(addr.length>1) {
				adi = Integer.parseInt(addr[1]);
			} 
			r = CRC16.bytesToBinAll(bt).charAt(15-adi)+"";
			break;
		case "short": 
			r = LittleByteUtil.getShort(bt)+"";
			break; 
		case "int": 
			r = LittleByteUtil.getInt(bt)+"";
			break; 
		case "float":  
			r = LittleByteUtil.getFloat(bt)+"";
			break; 
		case "double": 
			r = LittleByteUtil.getDouble(bt)+"";
			break;  
		case "string":
			r = new String(bt);
			break;  
		}  
		future.complete(r);*/
		return future;
	}

	@Override
	public CompletableFuture<String> batchWrite(Ioinfo address, String data) {
		// TODO Auto-generated method stub
		CompletableFuture<String> future = new CompletableFuture<>(); 
		Deque<McuData> wqueue = wmaxmap.get(address.ip);
		if(wqueue==null) {
			wqueue = new LinkedList<McuData>();
		}
//		if(rqueue.size()>MAX)rqueue.poll();
//		rqueue.addLast(new McuData(future,address));
//		 
		if(wqueue.size()>MAX)wqueue.poll();
		wqueue.addLast(new McuData(future,address,data));
		wmaxmap.put(address.ip, wqueue);
		return future;
	}
 
}
