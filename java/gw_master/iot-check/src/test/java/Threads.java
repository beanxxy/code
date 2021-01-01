import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Threads {
	static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5); 
	static int i = 1;
	static String str = "xx";
	public static void test() {
		try {
			log.info(str+i);
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test();
	}
	public static void main(String ars[]) {
		//test();
		scheduledThreadPool.scheduleAtFixedRate(()-> { 
			//while(true) {
				log.info(str+i);
				i++;
				if(i==1000) {
					i=1;
					//System.gc();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
		},1, 10, TimeUnit.MICROSECONDS); /**/
	}
}
