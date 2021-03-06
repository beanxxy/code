package gateway.core;

import com.google.gson.Gson;

import gateway.core.mqtt.Cmd;
import gateway.core.mqtt.Result;
import gateway.core.redis.Config;
import redis.clients.jedis.Jedis;

public class Dbz_Star {
	public void redisRead() {
		 Jedis jedis 	= Config.get();
		 String str 	= jedis.rpop("devtask");
		 Gson gson 		= new Gson();
		 Cmd cmd 		= gson.fromJson(str, Cmd.class);
	}
	public static void redisWrite(String r) {
		 Jedis jedis 	= Config.get(); 
		 jedis.rpush("taskans",r);
	}
	public static void main(String arg[]) throws InterruptedException {
		while(true) {
			Result r = new Result();
			r.id = "1303262303050842114";
			r.cmdId = (long) 33232;
			r.message = "成功";
			r.storeId=(long) 12323;
			Gson gson 		= new Gson();
			redisWrite(gson.toJson(r)); 
			
			Thread.sleep(100);
		}
		
		
	}
}
