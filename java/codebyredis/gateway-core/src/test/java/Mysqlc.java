import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import gateway.core.config.Alert;
import gateway.core.config.DataModel;
import gateway.core.config.Function;
import gateway.core.config.Ioinfo;
import gateway.core.config.ServerConfig;
import gateway.core.mapper.AlertData;
import gateway.core.mapper.DevData;
import gateway.core.mapper.DevServer;
import gateway.core.mapper.FunctionMapper;
import gateway.core.mapper.IoinfoMapper;
import gateway.core.mybatis.MySql;
import waste.AddressConfig;
import waste.DevAddress; 

 

public class Mysqlc{
	public static void main(String[] args) throws IOException { 
		Gson gson = new Gson(); 
		AlertData alertData = MySql.session.getMapper(AlertData.class);
		DevData devData = MySql.session.getMapper(DevData.class);
		//DevServer devServer = MySql.session.getMapper(DevServer.class);
		FunctionMapper functionMapper = MySql.session.getMapper(FunctionMapper.class);
		IoinfoMapper ioinfoMapper = MySql.session.getMapper(IoinfoMapper.class);
		 
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{   
		List<Alert> ls = alertData.getList();
			for(Alert ac : ls) { 
				System.out.println(gson.toJson(ac));
			}
			
			List<DataModel> ls1 = devData.getModel();
			for(DataModel ac : ls1) { 
				System.out.println(gson.toJson(ac));
			}
			
			/*
			 * List<ServerConfig> ls2 = devServer.getServer(); for(ServerConfig ac : ls2) {
			 * System.out.println(gson.toJson(ac)); }
			 */
			
			List<Function> ls3 = functionMapper.getAddrFun("4001", "5122","2");
			for(Function ac : ls3) { 
				System.out.println(gson.toJson(ac));
			}
			
			List<Ioinfo> ls4 = ioinfoMapper.getList();
			for(Ioinfo ac : ls4) { 
				System.out.println(gson.toJson(ac));
			} 
		},1000, 1000, TimeUnit.MILLISECONDS);
	} 
}
