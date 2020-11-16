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
 * : 菜单 
 * @title      : Menu.java
 * @package    : com.snimay.app.menu.vo
 * @author     : xxy
 * @date       : 2018年5月29日 下午12:03:40
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_menu")
@App(query = "text", name = "菜单",size=10)
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * : 目录名称 
	 * @author     : xxy
	 */
	@field(text = "菜单名称")
	public String text;
	/**
	 * : 目录功能 
	 * @author     : xxy
	 */
	@field(text = "菜单功能",inurl="[GET][/app/getselect]")
	public String app;
	
//	@field(text = "功能类型")
	public String type;//按钮（抬头目录），目录，搜索框 
/*	*//**
	 * : 目录类型
	 * @author     : xxy
	 *//*
	@field(text = "目录类型")
	public String clazz;*/
	/**
	 * : 上级目录
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "上级目录",vfield="text")
	public Menu parent;
}
