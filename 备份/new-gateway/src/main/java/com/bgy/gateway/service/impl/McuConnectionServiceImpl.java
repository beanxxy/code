package com.bgy.gateway.service.impl;

import java.util.concurrent.CompletableFuture;

import com.bgy.gateway.model.vo.BasePlcDataModelVO;
import com.bgy.gateway.model.vo.DataModelVO;
import com.bgy.gateway.service.ConnectionService;
import com.bgy.gateway.util.CRC16Util;
import com.bgy.gateway.util.CoderUtil;
import com.bgy.gateway.util.LittleByteUtil;
import com.bgy.gateway.util.ToolUtil;
import com.bgy.gateway.util.UdpUtil;



/**
 * @author bean
 * 2020年11月14日
 */
public class McuConnectionServiceImpl implements ConnectionService{

	@Override
	public CompletableFuture<String> batchRead(BasePlcDataModelVO basePlcDataModelVO) {
		return batchWrite(basePlcDataModelVO,null);
	} 
 
	@Override
	public CompletableFuture<String> batchWrite(BasePlcDataModelVO basePlcDataModelVO, String data) {
		CompletableFuture<String> future = new CompletableFuture<>(); 
		String addr	=	"";
		int length	=	0;
		int templen	=	0;
		int min		=	99999;
		// 获取第一个地址位
		for(DataModelVO model	:	basePlcDataModelVO.getArrayDataModelVo()) {
			if(min > model.getSort()) {
				addr 	= 	model.getAddress();
				min 	= 	model.getSort();
				length	=	model.getLength();
			}
			templen	  += 	model.getLength();
		}
		byte[] bt = null; 
		byte[] senddata = "".getBytes();
		if(data!=null && data.length() > 0) {
			senddata = CoderUtil.encode(data, basePlcDataModelVO.getArrayDataModelVo(), basePlcDataModelVO.getEndian());
		} 
		do
		{
			bt = UdpUtil.send(basePlcDataModelVO.getIp(), basePlcDataModelVO.getPort(), addr,senddata); 
			try {
				if(bt==null && ToolUtil.ping(basePlcDataModelVO.getIp())) {
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				break;
				//e.printStackTrace();
			}
		} while (bt==null);
		if(bt==null) { 
			future.completeExceptionally(new Exception());
		}else {
			String ans = CoderUtil.decode(bt, basePlcDataModelVO.getArrayDataModelVo(), basePlcDataModelVO.getEndian());  
			future.complete(ans); 
		}
		return future;
	}

	 
	
	 
}
