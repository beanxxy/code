import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import gateway.core.config.AddressConfig;
import gateway.core.imp.ClientTcp;
import gateway.core.redis.Config;

public class pp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressConfig address = new AddressConfig();
		address.protocal = "mc";
		address.ip 	     = "192.168.3.200";
		address.port	 = 8000;
		address.dataModel= "order";
		address.dataAddr = "D2402";//1 0
		//2221 0 1 2
		ClientTcp cp = new ClientTcp();
		
		/*cp.batchRead(address).thenAccept(s->{
			System.out.println(s);
		});*/
		Map<String,String> map = new HashMap(); 
		map.put("head", "2");
		map.put("qt1", "0");
		map.put("qt2", "0");
		map.put("id", "1");
		map.put("time", "5");
		map.put("temp","4");
		map.put("taskid","6");
		map.put("basket", "4");
		Gson gson = new Gson();
		String st =  gson.toJson(map);
		cp.batchWrite(address,st).thenAccept(c->{ 
			System.out.println("xx");
		    /*cp.batchRead(address).thenAccept(s->{
		    	  System.out.println(s);
		    });*/
	    });
		/* Gson gson = new Gson();
		 Map<String,String> map = new HashMap();
		 map.put("deviceId", address.deviceId);
		 map.put("parentName", address.parentName);
		 map.put("estimateName", address.estimateName);
		 map.put("estimateValue", "1");
		 map.put("datatime", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date())); 
		 System.out.println("SSs:"+"1");
		 String sjosn = gson.toJson(map);
		 //Config.jedis.lpush("gateway:device:state:historical-data",sjosn); 
		
		 */
		 System.out.println("xxx");
		//cp.batchWrite(address, "0"); 
	}

}
