import gateway.core.config.AddressConfig;
import gateway.core.imp.MCUClient;

public class tttt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AddressConfig address = new AddressConfig();
		address.protocal 	= "mcu";
		address.ip 	     	= "172.28.13.29";
		address.port	 	= 50000;
		address.dataModel	= "hex";
		//address.dataModel= "string";
		address.dataAddr 	= "A004"; 
		//address.dataAddr = "000D"; 
		
		while(true) {
			new MCUClient().batchRead(address)
			.thenAccept(s->{ System.out.println("x1x:"+s+"-"+s.length());  });
			System.out.println(MCUClient.rqueue.size());
			Thread.sleep(50);
		}
		
		/*while(true) {
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x1x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x1x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x2x"+s);  });
		//Thread.sleep(1000);
		System.out.println("x2x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x3x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x3x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x4x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x4x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x5x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x5x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x6x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x6x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x7x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x7x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x8x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x7x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x9x"+s);  });
		//Thread.sleep(1000);
		//System.out.println("x7x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x10x"+s);  });
		//Thread.sleep(1000);
		System.out.println("x7x");
		new MCUClient().batchRead(address)
		.thenAccept(s->{ System.out.println("x11x"+s);  });
		Thread.sleep(500);
		System.out.println("==========="+MCUClient.rqueue.size());
		//System.out.println("x9x");
		}
		/*.thenAccept(s->{
			System.out.println("1-"+s);
		});
		new MCUClient().batchRead(address).thenAccept(s->{
			System.out.println("2-"+s);
		});
		new MCUClient().batchRead(address).thenAccept(s->{
			System.out.println("3-"+s);
		});
		new MCUClient().batchRead(address).thenAccept(s->{
			System.out.println("3-"+s);
		});*/
		/*AddressConfig a1 = new AddressConfig();
		a1.protocal = "mcu";
		a1.ip 	     = "192.168.8.112";
		a1.port	 = 50000;
		a1.dataModel= "float";
		a1.dataAddr = "030F"; 
		System.out.println("x1");
		new MCUClient().batchRead(a1).thenAccept(s->{
			System.out.println("2-"+s);
		});
		
		AddressConfig a2 = new AddressConfig();
		a2.protocal = "mcu";
		a2.ip 	     = "192.168.8.112";
		a2.port	 = 50000;
		a2.dataModel= "float";
		a2.dataAddr = "030F";  
		System.out.println("x2");
		new MCUClient().batchRead(a2).thenAccept(s->{
			System.out.println("3-"+s);
		});
		AddressConfig a3 = new AddressConfig();
		a3.protocal = "mcu";
		a3.ip 	     = "192.168.8.112";
		a3.port	 = 50000;
		a3.dataModel= "float";
		a3.dataAddr = "0300";  
		System.out.println("x3");
		new MCUClient().batchRead(a3).thenAccept(s->{
			System.out.println("4-"+s);
		});*/
	}

}
