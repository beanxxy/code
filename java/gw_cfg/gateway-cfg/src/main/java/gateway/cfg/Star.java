package gateway.cfg;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import gateway.cfg.mapping.DevMapper;
import gateway.cfg.model.Dev;
import gateway.cfg.mybatis.MySql;
import gateway.cfg.redis.redisCfg;
import redis.clients.jedis.Jedis;

public class Star {
	public static String cfg = "GW_in:config:";
	public static String dtm = "GW_in:datamodel:";
	public static String fun = "GW_in:function:";
	public static String ioi = "GW_in:ioinfo:";
	public static String alr = "GW_in:alarm:";
	public static String cal = "GW_in:call:"; 
	public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10); 
	public static void main(String[] args) {
		//scheduledThreadPool.allowCoreThreadTimeOut(true);
		scheduledThreadPool.scheduleAtFixedRate(()->{try { 
			//System.out.println("开始");
			//Thread.sleep(1000);
			config();
			//System.out.println("执行");
		}catch(Throwable t) {} }, 1, 1000,TimeUnit.MILLISECONDS);
		
		/*
		 * scheduledThreadPool.scheduleAtFixedRate(()->{try {
		 * //System.out.println("开始"); //Thread.sleep(1000); System.gc();
		 * //System.out.println("执行"); }catch(Throwable t) {} }, 1,
		 * 100,TimeUnit.MILLISECONDS);
		 */
	} 
	public static void config() {
		SqlSession session  = MySql.getSqlSession();
		DevMapper devMapper = session.getMapper(DevMapper.class);
		List<Dev> des 		= devMapper.getList();
		Jedis jedis 		= redisCfg.get();
		Gson gson			= new Gson();
		for(Dev dev : des) {
			String key = cfg+dev.devtype;
			jedis.hset(key,dev.devid, gson.toJson(dev)); 
		}
		session.clearCache();
		session.close();
		jedis.close();
		System.gc();
	}
}
