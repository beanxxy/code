package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import gateway.Client;
import gateway.config.DataModel;
import gateway.config.Ioinfo;
import gateway.imp.MCUClient;

public class MCUtest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gson gson = new Gson();

		{
			List<DataModel> ls = new ArrayList<DataModel>();
			for (int i = 0; i < 6; i++) {
				DataModel dm = new DataModel();
				dm.index = i + 1;
				dm.name = "气泵吹气检测" + i;
				dm.datatype = "short";
				dm.length = 2;
				dm.group = "stateDB";
				ls.add(dm);
			}
			Client.datamap.put("stateDB", ls);
		}
		{
			List<DataModel> ls = new ArrayList<DataModel>();
			for (int i = 0; i < 2; i++) {
				DataModel dm = new DataModel();
				dm.index = i + 1;
				dm.name = "value" + i;
				dm.datatype = "byte";
				dm.length = 1;
				dm.group = "indb";
				ls.add(dm);
			}
			Client.datamap.put("indb", ls);
		}
		// System.out.println(gson.toJson(ls));
		Client clinet = new MCUClient();

		Ioinfo io = new Ioinfo();

		io.deviceid = "1";
		io.dataAddr = "A011";
		io.dataModel = "stateDB";
		io.ip = "192.168.1.191";
		io.port = 50000;

		/*
		 * clinet.batchRead(io).thenAccept(c -> { System.out.println(c);
		 * 
		 * cp.batchRead(address).thenAccept(s->{ System.out.println(s); });
		 * 
		 * });
		 */

		Ioinfo io2 = new Ioinfo();

		io2.deviceid = "1";
		io2.dataAddr = "A030";
		io2.dataModel = "indb";
		io2.ip = "192.168.1.191";
		io2.port = 50000;

		Map inmap = new HashMap<String, String>();
		inmap.put("value1", "1");
		inmap.put("value2", "2");
		clinet.batchWrite(io2, new Gson().toJson(inmap)).thenAccept(c -> {
			// System.out.println(c);
			/*
			 * cp.batchRead(address).thenAccept(s->{ System.out.println(s); });
			 */
		});
		/*
		 * clinet.batchWrite(io2, new Gson().toJson(inmap)).thenAccept(()->{
		 * System.out.println("ok"); //System.out.println(c);
		 * cp.batchRead(address).thenAccept(s->{ System.out.println(s); }); });
		 */

	}

}
