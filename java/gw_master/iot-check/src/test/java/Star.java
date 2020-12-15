

import com.iot.check.DevInfo;
import com.iot.gateway.core.Ioinfo;
import com.iot.gateway.core.imp.McuConn;

 
public class Star {
	public static McuConn mcu 	= new McuConn();
	public static Ioinfo address 	= new DevInfo(); 
	public static void read() { 
		address.ip 			= "192.168.8.10";
		address.dataModel 	= "short";
		address.port 		= 8000;
		address.protocal 	= "mc";
		address.dataAddr 	= "D2210";
		//System.gc();
		mcu.batchRead(address).thenAccept(s->{ 
			System.out.println(s); 
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			read();
		}).exceptionally(ex -> {
			//ipspeed.put(key, (long) -1);//断线
			//deq.addLast(info);
			System.out.println("ttt");
			System.out.print(ex.toString());
            return null;
        }); 
	}
	
	public static void main(String[] args) { 
		
		read();
		
		
		
		
		
		
		
		
		
		
//		class DevEvent extends Event{
//
//			@Override
//			public void action(Ioinfo info) {
//				// TODO Auto-generated method stub
//				System.out.println("sdfsdf");
//				info.event.remove(info.value);
//				//.get(info.value)
//			} 
//			 
//		} 
//		class DevInfo extends Ioinfo{ 
//			@Override
//			public void change(String value) {
//				// TODO Auto-generated method stub
//				System.out.println("xdfd:"+value);
//			}
//		} 
		
		// TODO Auto-generated method stub
//		Client ct 		= new ClientTcp();  
//		Ioinfo info 	= new DevInfo();
//		info.ip 		= "172.28.12.6";
//		info.dataAddr 	= "D2050-0";
//		info.port 		= 8000;
//		info.protocal	= "mc";
//		info.dataModel	= "bit";  
//		ct.read(info); 
//		
//		Ioinfo info1 	= new DevInfo();
//		info1.ip 		= "172.28.12.6";
//		info1.dataAddr 	= "D3011";
//		info1.port 		= 8000;
//		info1.protocal	= "mc";
//		info1.dataModel	= "short";  
//		ct.read(info1); 
//		info.event = new ConcurrentHashMap<String,Event>();
//		info.event.put("1", new DevEvent()); 
//		ct.read(info);
	}
}
