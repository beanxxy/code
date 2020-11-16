package gateway.core.imp;

import java.util.Date;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import gateway.core.Client;
import gateway.core.Connection;
import gateway.core.Ioinfo;
import gateway.core.util.Tool;

/**
 * @author bean
 * 2020年11月14日
 */
 
public class ClientTcp  implements Client{
	/**
	 * 扫描间隔
	 */
	public static Long SLEEPTIME = (long) 500;
	/**
	 * 客户端链接
	 */
	public static Map<String,Connection> Conns 			= new ConcurrentHashMap<String,Connection>(); 
	/**
	 * 线程池
	 */
	public static ExecutorService fixedThreadPool 				= Executors.newFixedThreadPool(100); 
	public static ScheduledExecutorService scheduledThreadPool  = Executors.newScheduledThreadPool(100); 
	/**
	 * 根据ip和端口分开
	 */
	public static Map<String,Deque<Ioinfo>> rDeque  = new ConcurrentHashMap<String,Deque<Ioinfo>>();
	/**
	 * 所有的监听
	 */
	public static Map<String,Ioinfo> IoinfoData 	= new ConcurrentHashMap<String,Ioinfo>();
	/**
	 * 链接速度
	 */
	public static Map<String,Long> ipspeed = new ConcurrentHashMap<String,Long>();
	/**
	 * 读取注册
	 */
	public static Gson gs = new Gson(); 
	@Override
	public void read(Ioinfo iofo) { 
		if(IoinfoData.get(getKeyInfo(iofo))==null) {
			IoinfoData.put(getKeyInfo(iofo), iofo);
			String key 			= getKey(iofo);
			Deque<Ioinfo> rq 	= rDeque.get(key);
			if(rq == null ) rq 	= new LinkedBlockingDeque<Ioinfo>(); 
			rq.addLast(iofo);
			rDeque.put(key, rq); 
			if(ipspeed.get(key)	==	null)ipspeed.put(key, (long) -1);
		}else {
			IoinfoData.put(getKeyInfo(iofo), iofo);
		} 
	}
	
	/**
	 * 返回键
	 * @param iofo
	 * @return
	 */
	public static String getKey(Ioinfo iofo) {
		return iofo.ip+"-"+iofo.port;
	}
	/**
	 * 返回键
	 * @param iofo
	 * @return
	 */
	public static String getKeyInfo(Ioinfo iofo) {
		return iofo.ip+"-"+iofo.port+"+"+iofo.dataAddr;
	}
	
	/**
	 * 扫描字段
	 * @param key
	 */
	public static void excute(String key) { 
		Deque<Ioinfo> deq = rDeque.get(key); 
		Ioinfo info 	  = IoinfoData.get(getKeyInfo(deq.pop()));
		if(info==null) return ;
		Connection con = getConn(info); 
		Long lg = new Date().getTime();
		con.batchRead(info).thenAccept(s->{ 
			//if(info.value==null || (!info.value.equals(s))) {
				info.value = s;
				Executors.newCachedThreadPool().execute(()->{	//线程回调
					info.change(s);
					if(info.event !=null && info.event.get(s)!=null) {	//事件触发
						info.event.get(s).action(info);
					}
				});
			//}
			deq.addLast(info);
			try {
				Thread.sleep(SLEEPTIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ipspeed.put(key, new Date().getTime() -  lg);
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
			if(ipspeed.get(str)==-1 && Tool.ping(str.split("-")[0])) { 
				final String key = str;
				fixedThreadPool.execute(() -> {
					try {
						excute(key);
					}catch(Throwable t) { ipspeed.put(key, (long) -1); System.out.println("线程错误:"+t.getMessage());  }
				});
			}
		}
	}
	public static void log() { 
		System.out.println("ipspeed:"+gs.toJson(ipspeed)); 
		System.out.println("rDeque:"+rDeque.size());
	}
	static {
		scheduledThreadPool.scheduleAtFixedRate(()->{try { 
			execute(); 
		}catch(Throwable t) { t.getStackTrace(); } }, 1, 20, TimeUnit.SECONDS); 
		scheduledThreadPool.scheduleAtFixedRate(()->{try {
			log(); 
		}catch(Throwable t) { t.getStackTrace(); } }, 1, 1, TimeUnit.SECONDS);
	}
	@Override
	public void write(Ioinfo info, String value) { 
		try {
			Connection con = getConn(info);
			if(ipspeed.get(getKey(info))!=-1 || Tool.ping(info.ip)) {
				con.batchWrite(info, value);
			}else {
				 ipspeed.put(getKey(info),(long) -1);
				 throw new Exception("设备不在线!"); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取链接
	 * @param iofo
	 * @return
	 */
	public static Connection getConn(Ioinfo iofo) {
		Connection conn = Conns.get(getKey(iofo));
		if(conn==null) {
			switch (iofo.protocal) {
			case "mc":
			case "melsec":
				conn = new MelseConn(iofo);
				break; 
			case "mcu":
				conn = new McuConn();
				break;
			}
		}else return conn; 
		Conns.put(getKey(iofo), conn);
		return conn;
	}
}
