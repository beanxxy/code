package com.snimay.app.dto;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * 分页查询数据模板 
 * @title      : ListByPage.java
 * @package    : com.snimay.app.dto
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:42:25
 * @version    : V1.0   
 */
@App(name="分页查询")
public class ListByPage {
	/**
	 * 数据类型
	 * @author     : xxy
	 */
	@field(text = "数据类型")
	public String model;
	/**
	 * 开始数据
	 * @author     : xxy
	 */
	@field(text = "开始数据")
	public String start;
	/**
	 * 返回条数
	 * @author     : xxy
	 */
	@field(text = "返回条数")
	public String result;
	/**
	 * 查询键
	 * @author     : xxy
	 */
	@field(text = "查询键")
	public String key;
	/**
	 * 查询值
	 * @author     : xxy
	 */
	@field(text = "查询值")
	public String value;
}
