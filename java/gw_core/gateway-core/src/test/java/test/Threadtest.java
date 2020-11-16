package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadtest {
	public static void main(String[] avg) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(() -> {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
		
	}
}
