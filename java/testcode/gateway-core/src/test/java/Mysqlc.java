import java.io.IOException;
import java.util.List;

import gateway.core.config.AddressConfig;
import gateway.core.config.ServerConfig;
import gateway.core.mapper.DevAddress;
import gateway.core.mapper.DevServer;
import gateway.core.mybatis.MySql; 

 

public class Mysqlc{
	public static void main(String[] args) throws IOException {

		DevAddress devaddr = MySql.session.getMapper(DevAddress.class);
		
		List<AddressConfig> ls = devaddr.getAddr();
		for(AddressConfig ac : ls) { 
			System.out.println(ac.dataAddr);
			System.out.println(ac.ip);
			System.out.println(ac.dataAddr); 
		}
		
		DevServer server = MySql.session.getMapper(DevServer.class);
		
		List<ServerConfig> sc = server.getServer();
		for(ServerConfig cg : sc) { 
			System.out.println(cg.dataAddr);
			System.out.println(cg.id); 
		}
		
	}
	
}