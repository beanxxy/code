import java.util.List;

import gateway.core.Server;
import gateway.core.config.AddressConfig;
import gateway.core.imp.ClientTcp;
import gateway.core.imp.ServerHttp;
import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		 
		
		//System.out.println();
		
		AddressConfig address = new AddressConfig();
		address.protocal = "mc";
		address.ip 	     = "172.28.12.8";
		address.port	 = 8000;
		address.dataModel= "bit";
		address.dataAddr = "D2250";
		//
		
		//Server s = new ServerHttp();
		
		//s.bind(address);
		/*Jedis jedis = new Jedis("39.108.91.105",17097);
		
		jedis.auth("myRedisqx123C9876"); 
		jedis.select(11);
        System.out.println("连接成功");
        */
        //jedis.del("gateway:device:state:historical-data");
        
        
        //存储数据到列表中S
        //jedis.set(key, value)
        /*jedis.set("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 1011,\r\n"
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"顶端接近开关1（磁性）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:22:07.198690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.set("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 1011,\r\n"
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"顶端接近开关1（磁性）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:21:07.198690\"\r\n"
        		+ " }\r\n"
        		+ "");*/
       // hash.hset("key", "field", "value");
		//System.out.println(hash.hget("key", "field"));
        //jedis.hdel(key, fields)
        //jedis.hdel("gateway:device:state:historical-data","20150518161807");
        //jedis.hdel("gateway:device:state:historical-data","20150518161820");
        //jedis.hdel("gateway:device:state:historical-data","20150518161809");
        //jedis.h
        /*jedis.lpush("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"推杆开关2（凹槽光电）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.898690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.lpush("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"推杆开关2（凹槽光电）\",\r\n"
        		+ "  \"estimateValue\": 0,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.798690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.lpush("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"推杆开关2（凹槽光电）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.698690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.lpush("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"推杆开关2（凹槽光电）\",\r\n"
        		+ "  \"estimateValue\": 0,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.598690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.lpush("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"推杆开关2（凹槽光电）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.498690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.lpush("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"推杆开关2（凹槽光电）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.398690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.lpush("gateway:device:state:historical-data", "{\r\n"
        		+ "  \"deviceId\": 5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"推杆开关2（凹槽光电）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.298690\"\r\n"
        		+ " }\r\n"
        		+ "");
         /*jedis.hset("gateway:device:state:historical-data","20150518161809", "{\r\n"
        		+ "  \"deviceId\":4001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"顶端接近开关1（磁性）\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.198690\"\r\n"
        		+ " }\r\n"
        		+ "");
        jedis.hset("gateway:device:state:historical-data","20150518161820", "{\r\n"
        		+ "  \"deviceId\":5001,\r\n" 
        		+ "  \"parentName\": \"云轨下菜口机构\",\r\n"
        		+ "  \"estimateName\": \"拉绳电机报警\",\r\n"
        		+ "  \"estimateValue\": 1,\r\n"
        		+ "  \"datatime\": \"2015-05-18 16:18:07.198690\"\r\n"
        		+ " }\r\n"
        		+ "");
        		*/
 
        //jedis.lpush("site-list", "Google");
        //jedis.lpush("site-list", "Taobao");
        //System.out.println(jedis.hget("gateway:device:state:historical-data","123"));
		// 获取存储的数据并输出
       /* String tmp;
        while((tmp = jedis.rpop("site-list"))!=null) {
        	System.out.println(tmp);
        }
        List<String> list = jedis.lrange("gateway:device:state:historical-data", 0 ,0);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }*/
        /**List<String> list = jedis.lrange("site-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }**/
		
		//ClientTcp cp = new ClientTcp();
		//System.out.println("xx");
		/*cp.batchRead(address).thenAccept(c->{
		    System.out.println(c);
	    });
		
		cp.batchWrite(address,"0").thenAccept(s->{
			//System.out.println(s);
			cp.batchRead(address).thenAccept(c->{
			    System.out.println(c);
		    });
		});
		*/
		/*Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{
			cp.batchRead(address).thenAccept(s->{
				System.out.println(s);
			});
		} ,1000, 1000, TimeUnit.MILLISECONDS);*/
	}

}
