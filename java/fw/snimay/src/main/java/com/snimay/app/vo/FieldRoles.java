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
 * : 字段规则 
 * @title      : FieldRoles.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:49:17
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_fieldroles")
@App(query = "db", name = "字段规则",size=10)
public class FieldRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 字段
	 * @author     : xxy
	 */
	@field(text = "字段",index=2,inurl="[GET][/rule/getfield]")
	public String db;
	/**
	 * 事件 
	 * @author     : xxy
	 */
	@field(text = "事件",index=3,inurl="[GET][/rule/geteven]")
	public String even_;
	
	/**
	 * 规则
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "规则",vfield="name",index=3)
	public Rules data;
	/*@field(text = "规则",index=3,inurl="[GET][/rule/get]")
	public String rules_;*/
	/**
	 * 备注
	 * @author     : xxy
	 */
	@field(text = "备注",index=11,length=255,anchor=1L)
	public String remarks;
}
