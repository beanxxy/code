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
 * : 功能信息 
 * @title      : UserApp.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:52:27
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_userapp")
@App(name="功能信息",query="name")
public class UserApp {
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
	 * 功能信息
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "功能信息",vfield="name")
	public Appdb data;
	
	public String db;
}
