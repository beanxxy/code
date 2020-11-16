package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;


/**   
 * @title      : Field.java
 * @package    : com.snimay.app.clazz.vo
 * : 表单字段 
 * @author     : xxy
 * @date       : 2018年5月2日 下午2:47:35
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_fields")
@App(query = "name", name = "表单字段",size=10)
public class Fields {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	/**
	 * : 字段名称 
	 * @author     : xxy
	 */
	@field(text = "名称",index=1)
	public String name;
	

	/**
	 * : 列名 
	 * @author     : xxy
	 */
	@field(text = "列名",index=2)
	public String text;
	/**
	 * : 处理类型 string int list obj list 
	 * @author     : xxy
	 */
	@field(text = "类型",index=3,inurl="[GET][/class/gettype]")
	public String type;

	 
	@field(text = "长度",index=4)
	public int length_;
	
	/**
	 * : 排序 
	 * @author     : xxy
	 */
	@field(text = "位置",index=5)
	public int index_;
	
	/**
	 * : 类型 
	 * @author     : xxy
	 */
	@field(text = "类",index=6,inurl="[GET][/class/get]")
	public String clazz;
	
	/**
	 * : 查询字段  
	 * @author     : xxy
	 */
	@field(text = "查找字段",index=7,inurl="[GET][/class/getfield]")
	public String clazzquery;
	
}
