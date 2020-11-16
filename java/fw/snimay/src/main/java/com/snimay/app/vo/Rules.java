package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 规则管理 
 * @title      : Rules.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:51:01
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_roles")
@App(query = "name", name = "规则管理",size=10)
public class Rules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	/**
	 * 规则代号
	 * @author     : xxy
	 */
	@field(text = "规则代号",index=1,anchor=1L)	
	public String cname;
	/**
	 * 规则名称
	 * @author     : xxy
	 */
	@field(text = "规则名称",index=3,anchor=1L)	
	public String name;
	/**
	 * 规则代码
	 * @author     : xxy
	 */
	@field(text = "规则代码",index=3,anchor=1L,length=255)	
	public String codes;
	
}
