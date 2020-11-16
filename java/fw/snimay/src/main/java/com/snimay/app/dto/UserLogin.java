package com.snimay.app.dto;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;
/**   
 * 用户登录数据模板
 * @title      : UserLogin.java
 * @package    : com.snimay.app.dto
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:43:41
 * @version    : V1.0   
 */
@App(name="用户登录")
public class UserLogin {
	/**
	 * 用户名称
	 * @author     : xxy
	 */
	@field(text = "用户名称",anchor=1f)	
	public String username;
	/**
	 * 用户密码，已经加密的
	 * @author     : xxy
	 */
	@field(text = "用户密码",anchor=1f)
	public String password;
	
}
