package com.bgy.gateway.service;

import java.util.concurrent.CompletableFuture;

import com.bgy.gateway.model.vo.BasePlcDataModelVO; 
/**
 * @author bean
 * date 2020年12月1日
 */
public interface ClientService {
	 
	/**
	 * 输入，当值改变时调用change
	 * @param plcDataModelVo plc的信息集合
	 */
	void read(BasePlcDataModelVO plcDataModelVo); 
	 
	/**
	 * 关闭，监听
	 * @param plcDataModelVo
	 */
	void close(BasePlcDataModelVO plcDataModelVo);
 
	/**
	 * 写入
	 * @param plcDataModelVo plc 信息集合
	 * @param value			 写入数据
	 * @throws Exception	 错误反馈
	 */ 
	CompletableFuture<String> write(BasePlcDataModelVO plcDataModelVo,String value) throws Exception;
	
	/**
	 * 写入
	 * @param plcDataModelVo plc 	  信息集合
	 *  	  plcDataModelVo.getValue 写入数据
	 * @throws Exception	 错误反馈
	 */ 
	CompletableFuture<String> write(BasePlcDataModelVO plcDataModelVo) throws Exception;
	
}
