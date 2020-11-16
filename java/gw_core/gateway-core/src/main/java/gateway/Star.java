package gateway;

import java.util.concurrent.ConcurrentHashMap;

import gateway.core.Client;
import gateway.core.Event;
import gateway.core.Ioinfo;
import gateway.core.imp.ClientTcp;


public class Star {
	public static void main(String[] args) { 
		class DevEvent extends Event{

			@Override
			public void action(Ioinfo info) {
				// TODO Auto-generated method stub
				System.out.println("sdfsdf");
				info.event.remove(info.value);
				//.get(info.value)
			} 
			 
		} 
		class DevInfo extends Ioinfo{ 
			@Override
			public void change(String value) {
				// TODO Auto-generated method stub
				System.out.println("xdfd:"+value);
			}
		} 
		
		// TODO Auto-generated method stub
		Client ct 		= new ClientTcp();  
		Ioinfo info 	= new DevInfo();
		info.ip 		= "172.28.13.13";
		info.dataAddr 	= "A026";
		info.port 		= 50000;
		info.protocal	= "mcu";
		info.dataModel	= "short";  
		ct.read(info); 
		info.event = new ConcurrentHashMap<String,Event>();
		info.event.put("1", new DevEvent()); 
		ct.read(info);
	}
}
