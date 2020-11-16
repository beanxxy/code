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
 * : 用户角色 
 * @title      : UserRole.java
 * @package    : com.snimay.users.vo
 * @author     : xxy
 * @date       : 2018年4月27日 下午5:36:35
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_userrole")
@App(query = "name", name = "用户角色",size=10)
public class UserRole {
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
	 * 角色数据
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "角色数据",vfield="rolename",index=-1)
	public Role data;
}
