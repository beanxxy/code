package gateway.core.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import gateway.core.Client;
import gateway.core.config.DataModel;
import gateway.core.config.Ioinfo;
import gateway.core.mapper.DevData;
import gateway.core.mybatis.MySql;

public class ClientTcp implements Client{
	
	public static Map<String,Client> clients 			= new HashMap<String,Client>(); 
	public static Map<String,List<DataModel>> datamap 	= new HashMap<String,List<DataModel>>();
	//MelsecClientConfig config = new MelsecClientConfig.Builder("172.28.12.8").setPort(8000).build();
    //MelsecTcpClient client = MelsecTcpClient.create3EBinary(config);  
	static {
		DevData devdata 		= MySql.session.getMapper(DevData.class);
		List<DataModel> lsdata  = devdata.getModel();
		for(DataModel dm : lsdata) {
			List<DataModel> ld = datamap.get(dm.group);
			if(ld==null) {
				ld = new ArrayList<DataModel>();
			}
			ld.add(dm);
			datamap.put(dm.group, ld); 
		}
	}
	
	/**
	 * ��ѯ
	 * 
	 * @param address
	 * @return
	 */
	public static String getKey(Ioinfo address) {
		return address.protocal+address.ip+address.port;
	}
	@Override
	public CompletableFuture<String> batchRead(Ioinfo address) {  
		Client clt = clients.get(getKey(address));
		if(clt==null) {
			clt = ClientTcp.create(address);
		}
		return clt.batchRead(address);
	}

	@Override
	public CompletableFuture<Void> batchWrite(Ioinfo address, String data) { 
		Client clt = clients.get(getKey(address));
		if(clt==null) {
			clt = ClientTcp.create(address);
		}
		return clt.batchWrite(address, data);
	}

	public static Client create(Ioinfo address) {
		// TODO Auto-generated method stub
		Client client = null;
		switch (address.protocal) {
		case "mc":
		case "melsec":
			client = new MelseClient(address);
			break; 
		case "mcu":
			client = new MCUClient();
		}
		clients.put(getKey(address), client);
		return client;
	}

}
