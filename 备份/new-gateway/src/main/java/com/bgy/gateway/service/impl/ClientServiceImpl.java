package com.bgy.gateway.service.impl;

import java.util.Date;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bgy.gateway.model.vo.BasePlcDataModelVO;
import com.bgy.gateway.model.vo.DataModelVO;
import com.bgy.gateway.service.ClientService;
import com.bgy.gateway.service.ConnectionService;
import com.bgy.gateway.util.ToolUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author bean
 * 2020年11月14日
 */
@Service
public class ClientServiceImpl  implements ClientService{
	/**
	 * 扫描间隔
	 */
	@Value("${plc.interval}")
	public static Long INTERVAL;// 
	/**
	 * 客户端链接
	 */
	public static Map<String,ConnectionService> Conns 			= new ConcurrentHashMap<String,ConnectionService>();
	/**
	 * 线程池
	 */
	public static ExecutorService fixedThreadPool 				= Executors.newFixedThreadPool(100);
	public static ScheduledExecutorService scheduledThreadPool  = Executors.newScheduledThreadPool(100);
	/**
	 * 根据ip和端口分开
	 */
	public static Map<String,Deque<BasePlcDataModelVO>> rDeque  = new ConcurrentHashMap<String,Deque<BasePlcDataModelVO>>();
	
	/**
	 * 所有的监听
	 */
	public static Map<String,BasePlcDataModelVO> IoinfoData 	= new ConcurrentHashMap<String,BasePlcDataModelVO>();
	/**
	 * 链接速度
	 */
	public static Map<String,Long> ipspeed = new ConcurrentHashMap<String,Long>();

	public static Gson gs = new Gson();
	/**
	 * 读取注册
	 */
	@Override
	public void read(BasePlcDataModelVO iofo) {
		Map<String,String> addressNames = new ConcurrentHashMap<String,String>(); 
		for(DataModelVO dv : iofo.getArrayDataModelVo()) {
			addressNames.put(dv.getName(), dv.getAddress());
		}
		iofo.setAddressNames(addressNames);
		
		if(IoinfoData.get(getKeyInfo(iofo))==null) {
			IoinfoData.put(getKeyInfo(iofo), iofo);
			String key 						= getKey(iofo);
			Deque<BasePlcDataModelVO> rq 	= rDeque.get(key);
			if(rq == null ) {
				rq 				= new LinkedBlockingDeque<BasePlcDataModelVO>();
			}
			rq.addLast(iofo);
			rDeque.put(key, rq); 
			if(ipspeed.get(key)	==	null) {
				ipspeed.put(key, (long) -1);
			}
		}else {
			IoinfoData.put(getKeyInfo(iofo), iofo);
		}
	}

	/**
	 * 返回键
	 * @param iofo
	 * @return
	 */
	public static String getKey(BasePlcDataModelVO iofo) {
		return iofo.getIp()+"-"+iofo.getPort();
	}
	/**
	 * 返回键
	 * @param iofo
	 * @return
	 */
	public static String getKeyInfo(BasePlcDataModelVO iofo) {
		return iofo.getIp()+"-"+iofo.getPort()+"+"+iofo.getArrayDataModelVo().get(0).getAddress();
	}

	/**
	 * 扫描字段
	 * @param key
	 */
	public static void excute(String key) {
		Deque<BasePlcDataModelVO> deq = rDeque.get(key);
		BasePlcDataModelVO info 	  = IoinfoData.get(getKeyInfo(deq.pop()));
		
		//deq.remove(info);
		
		if(info==null) {
			return ;
		}
		ConnectionService con = getConn(info);
		Long lg = System.currentTimeMillis();
		con.batchRead(info).thenAccept(s->{
			if(info.getValue()==null || (!info.getValue().equals(s))) { 
				if(info.getValue()==null) {
					info.setValue("{}");
				}
				if(info.getValue()!=null) {
					Map<String,String> tmp1 = gs.fromJson(info.getValue(), new TypeToken<Map<String,String>>(){}.getType());
					Map<String,String> tmp2 = gs.fromJson(s, new TypeToken<Map<String,String>>(){}.getType()); 
					
					for(String str:tmp2.keySet()) {
						String stemp = tmp2.get(str);
						if(stemp==null) {
							stemp="";
						}
						if(!stemp.equals(tmp1.get(str))) {
							//线程回调 
							Executors.newCachedThreadPool().execute(()->{	
								String EventKey =  tmp2.get(str)+info.getAddressNames().get(str)	;
								info.change(str, info.getAddressNames().get(str), tmp2.get(str));
								if(info.getEvent() !=null && info.getEvent().get(EventKey)!=null) {	//事件触发
									info.getEvent().get(EventKey).action(info, info.getAddressNames().get(str), tmp2.get(str));
								}
							});
						}
					} 
				} 
				info.setValue(s);
				
			}
			deq.addLast(info);
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ipspeed.put(key, System.currentTimeMillis() -  lg);
			excute(key);//下一个
		}).exceptionally(ex -> {
			ipspeed.put(key, (long) -1);//断线
			deq.addLast(info);
            return null;
        });
	}

	/**
	 * 扫描字段
	 * @throws Exception
	 */
	public static void execute() throws Exception {
		for(String str : ipspeed.keySet()) {
			if(ipspeed.get(str)==-1 && ToolUtil.ping(str.split("-")[0])) {
				final String key = str;
				fixedThreadPool.execute(() -> {
					try {
						excute(key);
					}catch(Throwable t) { 
						ipspeed.put(key, (long) -1); 
						//log("线程错误:"+t.getMessage());  
					}
				});
			}
		}
	}

 

	static {
		scheduledThreadPool.scheduleAtFixedRate(()->{
			try {
				execute();
			}catch(Throwable t) { 
				t.getStackTrace(); 
			}
		}, 1, 20, TimeUnit.SECONDS); 

	}
	@Override
	public CompletableFuture<String> write(BasePlcDataModelVO info) throws Exception {
		return this.write(info, info.getValue());
	}
	@Override
	public CompletableFuture<String> write(BasePlcDataModelVO info, String value) throws Exception {
		ConnectionService con = getConn(info);
		boolean tmp = (getKey(info)!=null&&ipspeed.get(getKey(info))!=null&&ipspeed.get(getKey(info))!=-1) || ToolUtil.ping(info.getIp());
		if(tmp) {
			return con.batchWrite(info, value);
		}else {
			 ipspeed.put(getKey(info),(long) -1);
			 throw new Exception("设备不在线!");
		}
	}

	/**
	 * 获取链接
	 * @param iofo
	 * @return
	 */
	public static ConnectionService getConn(BasePlcDataModelVO iofo) {
		ConnectionService conn = Conns.get(getKey(iofo));
		if(conn==null) {
			switch (iofo.getProtocal()) {
			case "mc":
			case "melsec":
				conn = new MelseConnectionServiceImpl(iofo);
				break;
			case "mcu":
				conn = new McuConnectionServiceImpl();
				break;
			default:
				break;
			}
		}else {
			return conn;
		}
		Conns.put(getKey(iofo), conn);
		return conn;
	}

	@Override
	public void close(BasePlcDataModelVO plcDataModelVo) {
		// TODO Auto-generated method stub
		IoinfoData.remove(getKeyInfo(plcDataModelVo));
	}
}

