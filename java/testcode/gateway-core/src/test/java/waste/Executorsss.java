package waste;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import gateway.core.model.McuData;

public class Executorsss {
	public static void main(String[] arg) {
		System.out.println("xxx");
		int max = 100;
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(max); 
		//ScheduledExecutorService testService = Executors.newSingleThreadScheduledExecutor();
		int i=0;
		Map<String,String> db = new HashMap<String,String>();
		Deque<String> dq = new LinkedBlockingDeque<String>();
		for(i=0;i<max;i++) {
			dq.add(i+"");
			System.out.println(i);
			//db.put(i+"",i+"");
		}
		Long startime = new Date().getTime();
		//ConcurrentHashMap 线程安全；
		for(i=0;i<max;i++) {
			scheduledThreadPool.scheduleAtFixedRate(()->{try { 
				String threadName = dq.pop();
				if(threadName!=null) {
					System.out.println("开始执行:"+threadName);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println((new Date().getTime()-startime)+"执行完:"+threadName);
					dq.addLast(threadName);
				} 
				
			}catch(Throwable t) {} }, 1, 3, TimeUnit.SECONDS);
		}
		
	}
}
