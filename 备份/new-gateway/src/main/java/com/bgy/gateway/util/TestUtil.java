package com.bgy.gateway.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bgy.gateway.enums.EndianEnum;
import com.bgy.gateway.model.vo.BasePlcDataModelVO;
import com.bgy.gateway.model.vo.DataModelVO;
import com.bgy.gateway.service.ClientService;
import com.bgy.gateway.service.impl.ClientServiceImpl;
import com.google.gson.Gson;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author bean
 * 2020年12月15日
 */
public class TestUtil { 
	private static final Logger log 		= LoggerFactory.getLogger(TestUtil.class);
		

 
	public static void main(String[] avg) {
		
		class ModelVo extends BasePlcDataModelVO{ 
			@Override
			public void change(String name, String address, String value) { 
				log.info(this.getValue());
				log.info(name+":"+address+":"+value);
				//log.info(msg);
			} 
		}
		
		log.debug("测试");
		ClientService  clientService 		= new ClientServiceImpl();
		ModelVo mv = new ModelVo();
		mv.setIp("172.29.255.67");
		mv.setPort(4999);
		mv.setEndian(3);
		mv.setProtocal("mc"); 
		//===================
		List<DataModelVO> arrayDataModelVo 	= new ArrayList<DataModelVO>();
		DataModelVO datav1 					= new DataModelVO();
		datav1.setSort(0);
		datav1.setDataType(15);
		datav1.setAddress("D24");
		datav1.setLength(16);
		datav1.setName("D24");
		
		DataModelVO datav2 					= new DataModelVO();
		datav2.setSort(1);
		datav2.setDataType(15);
		datav2.setAddress("D25");
		datav2.setLength(16);
		datav2.setName("D25");
		
		DataModelVO datav3 					= new DataModelVO();
		datav3.setSort(2);
		datav3.setDataType(15);
		datav3.setAddress("D26");
		datav3.setLength(16);
		datav3.setName("D26");
		
		arrayDataModelVo.add(datav1);
		arrayDataModelVo.add(datav2);
		arrayDataModelVo.add(datav3);
		
		mv.setArrayDataModelVo(arrayDataModelVo);  
		
		Map<String,String> in = new HashMap<String,String>();
		in.put("D24", "12");
		in.put("D25", "120");
		in.put("D26", "121"); 
		String test = new Gson().toJson(in);
		log.debug(test);
		
		
		// 工具封装
		ByteBuf bytebuf = Unpooled.buffer(8);
		bytebuf.writeFloat(44.22f);
		bytebuf.writeFloat(45.27f);
		
		//byte[] pw = bytebuf.array();
		//log.debug(new String(pw));
		//byte[] by=CoderUtil.endian(bytebuf.array(),EndianEnum.CDAB);
		//log.debug(new String(by));
		clientService.read(mv);
//		try {
//			clientService.write(mv,test);
//			//clientService.read(mv);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		log.debug("测试");
		
		

		
	}
	
	
}
