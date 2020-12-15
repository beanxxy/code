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

import com.google.gson.Gson;

import com.iot.gateway.core.Client;
import com.iot.gateway.core.Connection;
import com.iot.gateway.core.Ioinfo;
import com.iot.gateway.core.util.Tool;

/**
 * @author bean
 * 2020年11月14日
 */
 
public class ClientTcp  implements Client{
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
	public static ExecutorService fixedThreadPool 				= Executors.newFixedThreadPool(100); 
	public static ScheduledExecutorService scheduledThreadPool  = Executors.newScheduledThreadPool(100); 
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
	
	public static Gson gs = new Gson(); 
	
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
			//System.out.println(key+":"+rq.size());
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
			//System.out.println(key+":"+rq.size());
			
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
		
		Deque<Ioinfo> deq = rDeque0.get(key); //优先
		
		if(deq!=null&&deq.size()!=0)
			System.out.println("====>"+key+":"+deq.toString()+":"+deq.size());
		 
		if(deq==null || deq.size() == 0) { 
			 deq = rDeque.get(key); 
		}else {
			//System.out.println();
		}
		
		if(deq==null) return ;
		
		Ioinfo infoT 	  = null;
		
		if(IoinfoData!=null) {
			Ioinfo tempio	=	 deq.pop();
			if(tempio!=null) {
				infoT = IoinfoData.get(getKeyInfo(tempio));
			}else {
				excute(key);
			}
		}
		
		if(infoT==null) { 
			excute(key);
			return ;
		}
		Ioinfo info = infoT;
		// 超时去掉
		if(info.lifetime!=0 && info.lifetime < (new Date().getTime())) {
			IoinfoData.remove(getKeyInfo(info));
			excute(key);
		};
		
		
		Connection con = getConn(info); 
		Long lg = new Date().getTime();
		
		//System.out.println("read==>"+info.dataAddr+"/"+info.dataModel);
		
		con.batchRead(info).thenAccept(s->{ 
			
			//System.out.println(info.dataAddr+"==>"+s);
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
				if(info.lifetime < (new Date().getTime())) { 
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
			ipspeed.put(key, new Date().getTime() -  lg);
			excute(key);//下一个
		}).exceptionally(ex -> {
			ipspeed.put(key, (long) -1);//断线
			
			System.out.println(ex.getMessage());
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
			if(ipspeed.get(str)==-1 && Tool.ping(str.split("-")[0])) { 
				final String key = str;
				fixedThreadPool.execute(() -> {
					try {
						excute(key);
					}catch(Throwable t) { 
						ipspeed.put(key, (long) -1);
						System.out.println("线程错误:"+t.getMessage()); 
						System.out.println(t.getLocalizedMessage());  
						System.out.println(key); 
					}
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
