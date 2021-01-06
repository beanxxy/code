package com.iot.gateway.core.imp;

import java.util.Date;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.iot.check.Star;
import com.iot.gateway.core.Client;
import com.iot.gateway.core.Connection;
import com.iot.gateway.core.Ioinfo;
import com.iot.gateway.core.enums.State;
import com.iot.gateway.core.util.Tool;

/**
 * @author bean
 * 2020年11月14日
 */
 
public class ClientTcp  implements Client{
	static Logger logger = Logger.getLogger(ClientTcp.class.getName());
	/** 
	 * 优先扫描超时 毫秒
	 */
	public static Long MAXTIME = 900000L;
	/**
	 * 扫描间隔 毫秒
	 */
	public static Long SLEEPTIME = 20L;
	/**
	 * 客户端链接
	 */
	public static Map<String,Connection> Conns 			= new ConcurrentHashMap<String,Connection>(); 
	/**
	 * 线程池
	 */ 
	public static ScheduledExecutorService scheduledThreadPool  = Executors.newScheduledThreadPool(1); 
	public static ScheduledExecutorService scheduledThreadPool1  = Executors.newScheduledThreadPool(1); 
	public static ScheduledExecutorService scheduledThreadPool2  = Executors.newScheduledThreadPool(1); 
	/*
	 * 优先
	 */
	public static Map<String,Deque<Ioinfo>> rDeque0  = new ConcurrentHashMap<String,Deque<Ioinfo>>();
	
	
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
	/*
	 * 状态 0 空闲 1 忙碌 3 故障
	 */
	public static Map<String,State> STATE  = new ConcurrentHashMap<String,State>();
	
	public static Gson gs = new Gson(); 
	
	/**
	 * 获取状态
	 * @param key 
	 * @return
	 */
	public static State  getState(String key) {
		return STATE.get(key);
	}
	
	/**
	 * 设置状态
	 * @param key
	 * @param state
	 */
	public static void setState(String key ,State state) {
		STATE.put(key, state);
	}
	
	
	/**
	 * 是否空闲
	 * @param key
	 * @return
	 */
	public static boolean isFree(String key) {
		if(getState(key)==null) return true;
		if(getState(key).equals(State.free))return true;
		return false;
	}
	
	/**
	 * 设置不空闲
	 * @param key
	 */
	public static void setBusy(String key) {
		setState(key,State.busy);
	}
	
	public static void setFree(String key) {
		setState(key,State.free);
	}
	
	/**
	 * 设置错误
	 * @param key
	 */
	public static void setError(String key) {
		setState(key,State.error);
	}
	
	
	/**
	 * 读取注册
	 */
	@Override
	public void read0(Ioinfo iofo) {
		// TODO Auto-generated method stub
		iofo.lifetime = new Date().getTime()+MAXTIME;
		if(IoinfoData.get(getKeyInfo(iofo))==null) {
			IoinfoData.put(getKeyInfo(iofo), iofo);
			String key 			= getKey(iofo);
			Deque<Ioinfo> rq 	= rDeque0.get(key);
			if(rq == null ) rq 	= new LinkedBlockingDeque<Ioinfo>(); 
			rq.addLast(iofo);
			rDeque0.put(key, rq);  
			if(ipspeed.get(key)	==	null)ipspeed.put(key, (long) -1);
		}else {
			IoinfoData.put(getKeyInfo(iofo), iofo);
		} 
	}
	/**
	 * 读取注册
	 */
	@Override
	public void read(Ioinfo iofo) {  
		iofo.lifetime = 0l;
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
			if(Star.debug)logger.info("------"+new Gson().toJson(iofo));
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
		
		// 不在状态 
		if(!isFree(key)) {
			return;
		}
		
		Deque<Ioinfo> deq = rDeque0.get(key); //优先
		
		if(deq!=null&&deq.size()!=0) 
			if(Star.debug)logger.info("====>"+key+":"+deq.toString()+":"+deq.size());
		if(deq==null || deq.size() == 0) { 
			 deq = rDeque.get(key); 
		}else {
			 
		}
		
		if(deq==null) return ;
		
		Ioinfo infoT 	  = null;
		
		if(IoinfoData!=null) {
			Ioinfo tempio	=	 deq.pop();
			if(tempio!=null) {
				infoT = IoinfoData.get(getKeyInfo(tempio));
			}else {
				//excute(key);
				setFree(key);
			}
		}
		
		if(infoT==null) { 
			//excute(key);
			setFree(key);
			return ;
		}
		Ioinfo info = infoT;
		// 超时去掉
		if(info.lifetime!=0 && info.lifetime < (System.currentTimeMillis())) {
			IoinfoData.remove(getKeyInfo(info));
			//excute(key);
			setFree(key);
		};
		 
		Connection con = getConn(info); 
		
		Long lg = System.currentTimeMillis();
		
		setBusy(key);
		con.batchRead(info).thenAccept(s->{ 
			//线程回调
			Executors.newCachedThreadPool().execute(()->{try { 	
				info.call(s); 
			}catch(Throwable t) { t.getStackTrace(); }});
			 
			if(info.value==null || (!info.value.equals(s))) {
				info.value = s;
				Executors.newCachedThreadPool().execute(()->{try { 	//线程回调
					info.change(s);
					if(info.event !=null && info.event.get(s)!=null) {	//事件触发
						info.event.get(s).action(info);
					}
				}catch(Throwable t) { t.getStackTrace(); }});
			}
			
			
			if(info.lifetime!=0) {
				// 超时去掉
				if(info.lifetime < (System.currentTimeMillis())) { 
					IoinfoData.remove(getKeyInfo(info));
				}else { 
					rDeque0.get(key).addLast(info);
				}
			}else {
				rDeque.get(key).addLast(info);
			}
			
			try {
				Thread.sleep(SLEEPTIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ipspeed.put(key, System.currentTimeMillis() -  lg);
			//excute(key);
			setFree(key);//下一个
		}).exceptionally(ex -> {
			ipspeed.put(key, (long) -1);//断线 
			setError(key);
			logger.warning("Client:276"+ex.getMessage()+"-"+key); 
			if(info.lifetime!=0) {
				rDeque0.get(key).addLast(info);
			}else {
				rDeque.get(key).addLast(info);
			}
			//deq.addLast(info);
            return null;
        });
	}

	/**
	 * 扫描字段
	 * @throws Exception 
	 */
	public static void execute() throws Exception {
		for(String str : ipspeed.keySet()) {
			final String key = str;
			if(ipspeed.get(str)!=-1) {
				try {
					excute(key);
				}catch(Exception e){
					logger.warning("线程错误:"+e.getMessage());
				}catch(Throwable t) { 
					ipspeed.put(key, (long) -1); 
					logger.warning("线程错误:"+t.getMessage());
					logger.warning(t.getLocalizedMessage()); 
					logger.warning(key);  
				}
			}
		}
		
		
		/*for(String str : ipspeed.keySet()) {
			if(ipspeed.get(str)==-1 && Tool.ping(str.split("-")[0])) { 
				final String key = str;
				fixedThreadPool.execute(() -> {
					try {
						excute(key);
					}catch(Throwable t) { 
						ipspeed.put(key, (long) -1); 
						logger.warning("线程错误:"+t.getMessage());
						logger.warning(t.getLocalizedMessage()); 
						logger.warning(key);  
					}
				});
			}
		}*/
	}
	public static void check() {
		for(String str : ipspeed.keySet()) {
			try {
				if(ipspeed.get(str)==-1 && Tool.ping(str.split("-")[0])) {
					ipspeed.put(str, 9999l);
					setFree(str);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	 
    public static void log() { 
    	//System.gc();
    	if(Star.debug)logger.info("ipspeed:"+gs.toJson(ipspeed));
    	if(Star.debug)logger.info("rDeque:"+rDeque.size()); 
    } 
	static {
		scheduledThreadPool1.scheduleAtFixedRate(()->{try {  
			execute(); 
		}catch(Throwable t) { t.getStackTrace(); } }, 1, 50, TimeUnit.MICROSECONDS); 
		 
		scheduledThreadPool2.scheduleAtFixedRate(()->{try {  
			check(); 
		}catch(Throwable t) { t.getStackTrace(); } }, 1, 10, TimeUnit.SECONDS); 
		
		scheduledThreadPool.scheduleAtFixedRate(()->{try { log(); }catch(Throwable t)
		{ t.getStackTrace(); } }, 1, 10, TimeUnit.SECONDS);
	 
	}
	@Override
	public void write(Ioinfo info, String value) throws Exception { 
		//try {
			Connection con = getConn(info);
			
			if((getKey(info)!=null&&ipspeed.get(getKey(info))!=null&&ipspeed.get(getKey(info))!=-1) || Tool.ping(info.ip)) {
				con.batchWrite(info, value);
			}else {
				 ipspeed.put(getKey(info),(long) -1);
				 throw new Exception("设备不在线!"); 
			}
		/*} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
	@Override
	public void close(Ioinfo info) {
		// TODO Auto-generated method stub
		IoinfoData.remove(getKeyInfo(info));
	}

	
}
