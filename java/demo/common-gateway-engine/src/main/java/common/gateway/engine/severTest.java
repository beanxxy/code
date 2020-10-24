package common.gateway.engine;

import com.comon.gateway.protocol.Std;
import com.comon.gateway.protocol.http.HttpServer;

public class severTest {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Hi,");
		Std std = new HttpServer();
		std.start(8000, "xx");
		std.start(8001, "xxx");
		std.start(8002, "xx");
	} 
}
