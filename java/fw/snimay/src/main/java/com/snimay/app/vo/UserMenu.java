package com.snimay.app.vo;

import java.util.Date;

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
 * : 用户菜单 
 * @title      : UserRole.java
 * @package    : com.snimay.users.vo
 * @author     : xxy
 * @date       : 2018年4月27日 下午5:36:35
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_usermenu")
@App(query = "data", name = "用户菜单",size=10)
public class UserMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 开始时间
	 * @author     : xxy
	 */
	@field(text = "开始时间",index=2)
	public Date starttime;
	/**
	 * 结束时间
	 * @author     : xxy
	 */
	@field(text = "结束时间",index=3)
	public Date	overtime;
	/**
	 * 菜单数据
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "菜单数据",vfield="text",index=-1)
	public Menu data;
	
	/**
	 * 数据
	 * @author     : xxy
	 */
	public String db;
}
