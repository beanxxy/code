package com.bgy.gateway.service;

import java.util.concurrent.CompletableFuture;

import com.bgy.gateway.model.vo.BasePlcDataModelVO;

/**
 * @author bean
 * data 2020年12月1日
 */
public interface ConnectionService {
	/**
	 * @param plcDataModelVo 设备的内存地址
	 * @return 回调数据值
	 */
	CompletableFuture<String> batchRead(BasePlcDataModelVO plcDataModelVo);
	
	/**
	 * @param plcDataModelVo 设备的内存地址
	 * @param data 数据值
	 * @return
	 */
	CompletableFuture<String> batchWrite(BasePlcDataModelVO plcDataModelVo, String data);
}
