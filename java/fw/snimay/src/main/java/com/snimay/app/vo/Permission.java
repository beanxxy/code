package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;


/**   
 * : 权限 
 * @title      : Permission.java
 * @package    : com.snimay.users.vo
 * @author     : xxy
 * @date       : 2018年4月27日 下午5:44:02
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_permission")
@App(query = "id", name = "权限",size=10)
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	/**
	 * 权限路径
	 * @author     : xxy
	 */
	@field(text = "权限路径")
	public String path;
	/**
	 * 访问类型 
	 * @author     : xxy
	 */
	@field(text = "访问类型")
	public String type;
}
