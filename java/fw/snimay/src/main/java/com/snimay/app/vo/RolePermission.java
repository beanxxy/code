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
 * : 用户权限 
 * @title      : RolePermission.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:50:53
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_rolepermission")
@App(query = "data", name = "用户权限",size=10)
public class RolePermission {
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
	 * 权限路径
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "权限路径")
	public Permission data;
}
