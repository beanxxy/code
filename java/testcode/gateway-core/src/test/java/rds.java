import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import gateway.core.config.AddressConfig;
import gateway.core.redis.Config;

public class rds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressConfig ac = new AddressConfig();
		ac.deviceId="4001";
		ac.estimateName="x";
		 Gson gson = new Gson();
		 Map<String,String> map = new HashMap();
		 map.put("deviceId", ac.deviceId);
		 map.put("parentName", ac.parentName);
		 map.put("estimateName", ac.estimateName);
		 map.put("estimateValue", "sd");
		 map.put("datatime", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date())); 
		 System.out.println("SSs:");
		 String sjosn = gson.toJson(map);
		 System.out.println(":"+sjosn+""); 
		 Config.jedis.lpush("gateway:device:state:historical-data",sjosn);
		 System.out.println(":"+sjosn+""); 
	}

}
