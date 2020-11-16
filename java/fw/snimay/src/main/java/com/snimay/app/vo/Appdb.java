package com.snimay.app.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;
 
/**   
 * 功能信息
 * @title      : Appdb.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:48:43
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_appdb")
@App(name="功能信息",query="name")
public class Appdb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 功能名称
	 * @author     : xxy
	 */
	@field(text = "功能名称",flex=3)
	public String name;
	/**
	 * 功能路径
	 * @author     : xxy
	 */
	@field(text = "功能路径",inurl="[GET][/app/get]")
	public String url; 
	/**
	 * 前端模板
	 * @author     : xxy
	 */
	@field(text = "前端模板",inurl="[GET][/app/getjs]")
	public String js;  
	/**
	 * 数据模型
	 * @author     : xxy
	 */
	@field(text = "数据模型",inurl="[GET][/class/get]")
	public String clazz;
	/**
	 * 类型
	 * @author     : xxy
	 */
	@field(text = "类型"   ,inurl="[GET][/app/gettype]")
	public String type;
	/**
	 * : 功能上级
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "功能上级",vfield="name")
	public Appdb parent;
	/**
	 * 功能备注
	 * @author     : xxy
	 */
	@field(text = "功能备注",anchor=1,index=3,length=255)
	public String remark;
}
