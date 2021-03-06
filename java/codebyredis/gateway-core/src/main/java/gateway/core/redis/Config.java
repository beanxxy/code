package gateway.core.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Config {
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
		if(Config.jedisPool==null) {
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
				//System.out.println(pw);
				/*jedis = new Jedis(host,port,0); 
				//jedis.
				jedis.auth(pw); 
				jedis.select(11); */ 
				JedisPoolConfig config = new JedisPoolConfig();
				//最大空闲连接数, 应用自己评估，不要超过ApsaraDB for Redis每个实例最大的连接数
				config.setMaxIdle(5000);
				config.setMinIdle(1000);
				//最大连接数, 应用自己评估，不要超过ApsaraDB for Redis每个实例最大的连接数
				config.setMaxTotal(6000);
				config.setMaxWaitMillis(5000);
				//每timeBetweenEvictionRunsMillis毫秒秒检查一次连接池中空闲的连接,把空闲时间超过minEvictableIdleTimeMillis毫秒的连接断开,直到连接池中的连接数到minIdle为止
				config.setTimeBetweenEvictionRunsMillis(600);
				config.setMinEvictableIdleTimeMillis(100);
				config.setTestOnBorrow(true);
				config.setTestOnReturn(false);
				jedisPool = new JedisPool(config, host, port, 5000, pw);
				//.select(11);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Jedis jedis= jedisPool.getResource();
		jedis.select(database);
		return jedis;
	}
	/*static {
		try {
			Yaml yaml = new Yaml();
			InputStream inputStream  = Resources.getResourceAsStream("app.yaml");
			Map<String, Object> map = (Map<String, Object>) yaml.loadAs(inputStream, Map.class).get("redis"); 
			int database = Integer.parseInt(map.get("database")+""); 
			String host = map.get("host")+"";
			int port = Integer.parseInt(map.get("post")+"");
			String pw = map.get("password")+""; 
			System.out.println(pw);
			jedis = new Jedis(host,port); 
			jedis.auth(pw); 
			jedis.select(11); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */
}
