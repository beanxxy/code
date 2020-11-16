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
 * : 角色菜单 
 * @title      : RoleMenu.java
 * @package    : com.snimay.app.role.vo
 * @author     : xxy
 * @date       : 2018年5月2日 下午3:13:04
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_rolemenu")
@App(query = "id", name = "角色菜单",size=10)
public class RoleMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 菜单
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "菜单")
	public Menu data;
}
