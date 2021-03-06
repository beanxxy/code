package com.bgy.gateway.service.impl;

import java.util.concurrent.CompletableFuture;


import com.bgy.gateway.model.vo.BasePlcDataModelVO;
import com.bgy.gateway.model.vo.DataModelVO;
import com.bgy.gateway.service.ConnectionService;
import com.bgy.gateway.util.CoderUtil;
import com.vsdata.melsec.client.MelsecClientConfig;
import com.vsdata.melsec.client.MelsecTcpClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author bean
 * 2020年11月14日
 */
public class MelseConnectionServiceImpl implements ConnectionService{
	/**
	 * 配置
	 */
	MelsecClientConfig config ; 
    /**
     * 链接客户端
     */
    MelsecTcpClient client ;
 
    /**
     * @param address 新建
     */
    public MelseConnectionServiceImpl(BasePlcDataModelVO address) { 
    	config = new MelsecClientConfig.Builder(address.getIp()).setPort(address.getPort()).build();
    	client = MelsecTcpClient.create3EBinary(config);
    }
	/**
	 * @param address
	 * @return
	 */
	public static ConnectionService create(BasePlcDataModelVO address) { 
		return new MelseConnectionServiceImpl(address);
	}

 
	@Override
	public CompletableFuture<String> batchRead(BasePlcDataModelVO basePlcDataModelVO) { 
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
			templen	  += model.getLength();
		}
		addr = this.convertAddr(addr); 
		length = templen;
		length = (length/8+(length%8==0?0:1)) / 2; 
		
		if(length < 2) {
			length = 2;
		}
		this.client.batchRead(addr, length).thenAccept(response -> {
			// 翻译成json
			String ans = CoderUtil.decode(response.array(), basePlcDataModelVO.getArrayDataModelVo(), basePlcDataModelVO.getEndian()); 
			future.complete(ans);
		}).exceptionally(ex -> { 
        	future.completeExceptionally(ex); 
        	return null;
        });
		return future;
	}
	 
	/**
	 * 转出去的地址转换
	 * @param addr
	 * @return
	 */
	public String convertAddr(String addr) {  
		switch(addr.charAt(0)) {
		case 'x':
		case 'X':
		case 'y':
		case 'Y':
			return addr.charAt(0)+Integer.toHexString(Integer.valueOf(addr.substring(1), 8));
		default:
			return addr;
		} 
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
			templen	  += model.getLength();
		}
		addr = this.convertAddr(addr);
		if(length==0) {
			length = templen;
		}
		length = templen;
		length = (length/8+(length%8==0?0:1)) / 2; 
		if(length < 2) {
			length = 2;
		}
		ByteBuf bytes =Unpooled.copiedBuffer(CoderUtil.encode(data, basePlcDataModelVO.getArrayDataModelVo(), basePlcDataModelVO.getEndian()));
		this.client.batchWrite(addr, length,bytes).thenAccept(response -> { 
			future.complete("1");
		}).exceptionally(ex -> { 
        	future.completeExceptionally(ex); 
        	return null;
        }); 
		return future;
	}
}
