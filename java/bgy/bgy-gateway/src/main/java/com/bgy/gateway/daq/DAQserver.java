package com.bgy.gateway.daq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bgy.gateway.daq.muc.OnDataCheck;
@Component
public class DAQserver implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//LOGGER.info("服务启动，端口：{}，{}", 12, "扫码端");
		new Thread(new OnDataCheck()).start();
	}

}
