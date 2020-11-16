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
 * : 用户管理 
 * @title      : User.java
 * @package    : com.snimay.users.vo
 * @author     : xxy
 * @date       : 2018年4月27日 下午5:36:41
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_User")
@App(query = "username", name = "用户管理",size=10)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 用户名名称
	 * @author     : xxy
	 */
	@field(text = "用户名称")	
	public String username;
	/**
	 * 用户密码
	 * @author     : xxy
	 */
	@field(text = "用户密码")
    public String password;
    //临时文件
	/**
	 * 临时文件
	 * @author     : xxy
	 */
	public String temp;
	
    /**
     * 用户字段
     * @author     : xxy
     */
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
	@JoinColumn(insertable=true,updatable=true)
    public Set<UserInfo> info;
    
    /**
     * 用户角色
     * @author     : xxy
     */
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "用户角色")
    public Set<UserRole> role;
    
 /* @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "路径字段")
    public Set<com.snimay.app.vo.UserPermission> permission;*/
    
    /**
     * 权限字段
     * @author     : xxy
     */
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "权限字段")
    public Set<UserField> field;
    
    /**
     * 用户菜单
     * @author     : xxy
     */
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "用户菜单")
    public Set<UserMenu> menu;
    
    
    /**
     * 功能权限
     * @author     : xxy
     */
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "功能权限")
    public Set<UserApp> apps;
    
    
}
