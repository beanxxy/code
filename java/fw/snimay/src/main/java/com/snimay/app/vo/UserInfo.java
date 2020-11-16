package com.snimay.app.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;


/**   
 * : 用户信息 
 * @title      : UserInfo.java
 * @package    : com.snimay.users.vo
 * @author     : xxy
 * @date       : 2018年4月27日 下午5:42:19
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_userinfo")
@App(query = "name", name = "用户信息",size=10)
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	/**
	 * 开始时间
	 * @author     : xxy
	 */
	@field(text = "开始时间")
	public Date starttime;
	/**
	 * 结束时间
	 * @author     : xxy
	 */
	@field(text = "结束时间")
	public Date	overtime;
	/**
	 * 用户信息
	 * @author     : xxy
	 */
	@field(text = "用户信息")
	public String key_;
	/**
	 * 信息值
	 * @author     : xxy
	 */
	@field(text = "信息值")
	public String value_;
}
