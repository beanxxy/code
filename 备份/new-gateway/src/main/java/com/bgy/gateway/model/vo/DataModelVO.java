package com.bgy.gateway.model.vo;



import com.bgy.gateway.enums.DataTypeEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bean
 * date 2020年12月1日
 */
@Getter
@Setter
public class DataModelVO {
	/**
	 * 数据排序
	 */
	private int sort;  
	/**
	 * 数据名称
	 */
	private String name;
	/**
	 * 数据地址
	 */
	private String address; 
	/**
	 * 数据类型
	 */
	private int dataType; 
	/**
	 * 数据长度 按位计算
	 */
	private int length;
}
