package com.snimay.app.vo;




import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;


/**   
 * : 角色 
 * @title      : Role.java
 * @package    : com.snimay.users.vo
 * @author     : xxy
 * @date       : 2018年4月27日 下午5:36:50
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_role")
@App(query = "rolename", name = "角色",size=10)
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
 
	/**
	 * 角色目录
	 * @author     : xxy
	 */
	@field(text = "角色目录")
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
	@JoinColumn(insertable=true,updatable=true)
	public Set<RoleMenu> menus;
	
	 
	/**
	 * 角色名称
	 * @author     : xxy
	 */
	@field(text = "角色名称")
	public String rolename;
	/**
	 * 角色备注
	 * @author     : xxy
	 */
	@field(text = "角色备注")
	public String remarks;
	
	/**
	 * 路径字段
	 * @author     : xxy
	 */
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "路径字段")
    public Set<RolePermission> permission;
    
    /**
     * 权限字段
     * @author     : xxy
     */
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "权限字段")
    public Set<RoleField> field;
	
}
