package com.bgy.gateway.daq.muc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bgy.gateway.util.Udp;

public class OnDataCheck implements Runnable{
	public static String addr = "";
	public static Map<String,byte[]> mucAddr = new HashMap<String,byte[]>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			List<String> ips = Udp.getLocalIPList();
    		for(String ip : ips) {
    			Map<String,byte[]> map = Udp.sendAll(ip,Udp.PORT, "0300","",1000);
    			for(String tmp : map.keySet()) {
    				mucAddr.put(tmp, map.get(tmp));
    			}
    		}
		}
	}

}
