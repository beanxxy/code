import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import gateway.core.config.Ioinfo;
import gateway.core.imp.ClientTcp;
import gateway.core.imp.MCUClient;
import gateway.core.mapper.IoinfoMapper;
import gateway.core.mybatis.MySql;
import waste.AddressConfig;

public class tttt {
	public static int tee = 0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Ioinfo address = new Ioinfo();
		address.protocal 	= "mcu";
		address.ip 	     	= "172.28.13.2";
		address.port	 	= 50000;
		address.dataModel	= "short";
		//address.dataModel= "string";
		address.dataAddr 	= "A023"; 
		//address.dataAddr = "000D"; 
		IoinfoMapper ioinfoMapper =MySql.getSqlSession().getMapper(IoinfoMapper.class);
		List<Ioinfo> ios = ioinfoMapper.getList();
		ClientTcp cp = new ClientTcp(); 
//		new MCUClient().batchRead(address)
//		.thenAccept(s->{ System.out.println("x1x"+s);  });
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{   
			for(Ioinfo ac : ios) {
				String dbkey =ac.ip + ac.deviceid+"."+ac.parentName+"."+ac.estimateName;
				if(ac.parentName.equals("下菜口点检")||ac.ip.equals("172.28.12.8")) 
				{
					System.out.println(dbkey+":"); 
					cp.batchRead(ac).thenAccept(s->{
						tttt.tee++;
						System.out.println(tttt.tee+"====="+dbkey+":"+s); 
					});
				}
				/*
				 * cp.batchRead(ac).thenAccept(s->{
				 * 
				 * });
				 */
			}
			/*
			 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			tttt.tee=0;
		},1000, 1000, TimeUnit.MILLISECONDS);
		
//		while(true) {
//			new MCUClient().batchRead(address)
//			.thenAccept(s->{ System.out.println("x1x:"+s+"-"+s.length());  });
//			System.out.println(MCUClient.rqueue.size());
//			Thread.sleep(50);
//		}
		
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
