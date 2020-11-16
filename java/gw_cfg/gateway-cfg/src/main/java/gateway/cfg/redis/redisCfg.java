package gateway.cfg.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.yaml.snakeyaml.Yaml;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redisCfg {
	public static JedisPool jedisPool;
	public static int database = 0;
	public static String host;
	public static int port;
	public static String pw;
	public static String key;
	public static String getKey() {
		return key;
	}
	public static Jedis get()  { 
		if(redisCfg.jedisPool==null) {
			Yaml yaml = new Yaml();
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("app.yaml"); 
				Map<String, Object> map = (Map<String, Object>) yaml.loadAs(inputStream, Map.class).get("redis"); 
				database = Integer.parseInt(map.get("database")+""); 
				host 	 = map.get("host")+"";
				port 	 = Integer.parseInt(map.get("post")+"");
				pw 		 = map.get("password")+""; 
				key		 = map.get("key")+""; 
				JedisPoolConfig config = new JedisPoolConfig();
				//最大空闲连接数
				config.setMaxIdle(500);
				config.setMinIdle(100);
				//最大连接数
				config.setMaxTotal(600);
				config.setMaxWaitMillis(500);
				//每timeBetweenEvictionRunsMillis毫秒秒检查一次连接池中空闲的连接,把空闲时间超过minEvictableIdleTimeMillis毫秒的连接断开,直到连接池中的连接数到minIdle为止
				config.setTimeBetweenEvictionRunsMillis(600);
				config.setMinEvictableIdleTimeMillis(100);
				config.setTestOnBorrow(true);
				config.setTestOnReturn(false);
				jedisPool = new JedisPool(config, host, port, 5000, pw);  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Jedis jedis= jedisPool.getResource();
		jedis.select(database);
		return jedis;
	}
}
