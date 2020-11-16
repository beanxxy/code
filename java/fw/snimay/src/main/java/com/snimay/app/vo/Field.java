package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;


/**   
 * 字段 
 * @title      : Field.java
 * @package    : com.snimay.app.clazz.vo
 * @author     : xxy
 * @date       : 2018年5月2日 下午2:47:35
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_field")
@App(query = "name", name = "字段",size=10)
public class Field {
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
	 * : 类型 
	 * @author     : xxy
	 */
	@field(text = "类",index=2)
	public String clazz;
	/**
	 * : 查询字段  
	 * @author     : xxy
	 */
	@field(text = "查找字段",index=3)
	public String clazzquery;
	/**
	 * : 列名 
	 * @author     : xxy
	 */
	@field(text = "列名",index=4)
	public String text;
	/**
	 * : 校验 
	 * @author     : xxy
	 */
//	@field(text = "校验")
	//public String regex;
	
	@field(text = "模型",index=5)
	public String model;
	/**
	 * : 数据校验报错 
	 * @author     : xxy
	 */
	//@field(text = "校验")
	//public String regextext;
	
	/**
	 * : 百分百宽度 
	 * @author     : xxy
	 */
	//@field(text = "百分百",index=0)
	//public String flex;
	/**
	 * : 是否唯一 
	 * @author     : xxy
	 */
	//@field(text = "是否唯一")
	//public int isonly;
	/**
	 * : 长度
	 * @author     : xxy
	 */
	//@field(text = "长度")
	public int length_;
	/**
	 * : 排序 
	 * @author     : xxy
	 */
	@field(text = "位置",index=6)
	public int index_;
	
	@field(text = "规则",index=7)
	public String rules_;
	@field(text = "事件",index=7)
	public String changerules_;
	@field(text = "加载",index=8)
	public String changerender_;
	@field(text = "聚焦",index=9)
	public String changefocus_;
	@field(text = "失焦",index=10)
	public String changeblur_;
	
	/**
	 * : 是否在列表中查看 
	 * @author     : xxy
	 */
	//@field(text = "是否隐藏",index=0)
	public String ishide_;
	
	
	/**
	 * : 处理类型 string int list obj list 
	 * @author     : xxy
	 */
	@field(text = "类型",index=11)
	public String type;
}
