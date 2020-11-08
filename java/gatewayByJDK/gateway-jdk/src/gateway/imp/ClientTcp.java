package gateway.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import gateway.Client;
import gateway.config.DataModel;
import gateway.config.Ioinfo;
 

public class ClientTcp implements Client{
	
	public static Map<String,Client> clients 			= new HashMap<String,Client>(); 
	
	//MelsecClientConfig config = new MelsecClientConfig.Builder("172.28.12.8").setPort(8000).build();
    //MelsecTcpClient client = MelsecTcpClient.create3EBinary(config);  
	static {
		/*DevData devdata 		= MySql.session.getMapper(DevData.class);
		List<DataModel> lsdata  = devdata.getModel();
		for(DataModel dm : lsdata) {
			List<DataModel> ld = datamap.get(dm.group);
			if(ld==null) {
				ld = new ArrayList<DataModel>();
			}
			ld.add(dm);
			datamap.put(dm.group, ld); 
		}*/
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
	public CompletableFuture<String> batchWrite(Ioinfo address, String data) { 
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
		case "mcu":
			client = new MCUClient();
		}
		clients.put(getKey(address), client);
		return client;
	}

}
