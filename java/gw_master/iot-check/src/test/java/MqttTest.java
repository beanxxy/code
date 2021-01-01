import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.iot.check.Star;

public class MqttTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		com.iot.check.Star  st= new com.iot.check.Star();
		com.iot.check.Star.mqttRead();
		int i=0; 
		while(true) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());// calendar.get(Calendar.MINUTE)
			test(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
	}
	public static void test(int i) {
		Gson gs 						= new Gson();
		Map<String,Object> outmap 		= new HashMap<String,Object>(); 
		outmap.put("storeId",Star.STOREID);
		outmap.put("id","82900000000000176_1");
		outmap.put("name","");
		outmap.put("partId", "1"); 
		
		Map iomap = new HashMap<String,String>();
		iomap.put("parentName", "测试设备");
		iomap.put("estimateName", "D2225-肉饼上扒炉4温度℃");
		
		 int max=100,min=1;
		 long randomNum = System.currentTimeMillis();  
		 int ran3 = (int) (randomNum%(max-min)+min);  
		iomap.put("estimateValue", ran3);
		List<Map> point 	= new ArrayList<Map>();  
		point.add(iomap); 
		outmap.put("measuredList", point);
		Star.mqttSend("devicePartMeasuredValue", gs.toJson(outmap));  
		System.out.println(gs.toJson(outmap));
	}

}
