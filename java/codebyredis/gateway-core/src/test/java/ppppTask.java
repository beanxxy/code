import java.util.Map;

import com.google.gson.Gson;

import gateway.core.mqtt.Cmd;

public class ppppTask {
	public static void main(String[] arg) {
		 Gson gson 		= new Gson();
		String str = "{\"id\":\"1111\",\"type\":700,\"cmd\":\"2\",\"cmdParam\":{\"head\":\"3\",\"qt1\":\"0\",\"qt2\":\"0\",\"id\":\"1\",\"time\":\"5\",\"temp\":\"200\",\"taskid\":\"5\",\"basket\":\"10\"},\"cmdId\":12}";
		Map cmd 		= gson.fromJson(str, Map.class); 
	}
}
