package com.snimay.app;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.common.MD5;
import com.snimay.common.ToWeb;

import io.swagger.annotations.ApiOperation;
/**   
 * : 用户接口 
 * @title      : UserController.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:55:09
 * @version    : V1.0   
 */
@RestController
@RequestMapping("user")
public class UserController extends	Controller{
	/**
	 * 用户会话
	 * @author     : xxy
	 */
	@Autowired
	private HttpSession session;
	/**
	 * 查看当前用户信息
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@ApiOperation(value="用户查看", notes="查看当前用户信息")
	@GetMapping("/")
	public Object get() {
		ToWeb toweb = 	new ToWeb();
		Gson gs		=	new Gson();
		toweb.setObjData(session.getAttribute("user"));
		return new Gson().toJson(toweb);
	}
	/**
	 * 当前用户登出
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@ApiOperation(value="用户查看", notes="当前用户登出")
	@GetMapping("/out")
	public Object out() {
		ToWeb toweb = 	new ToWeb();
		session.removeAttribute("usersessionFactory");
		session.removeAttribute("processurl");
		session.removeAttribute("user");
		session.removeAttribute("packages");
		return new Gson().toJson(toweb);
	}
	/**
	 * 返回加密信息
	 * @author     : xxy
	 * @param value
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws
	 */
	@ApiOperation(value="用户加密", notes="发回加密信息")
	@GetMapping("/{value}/")
	public Object md5(@PathVariable("value") String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		ToWeb toweb = 	new ToWeb();
		toweb.setObjData(MD5.toString(value));
		return new Gson().toJson(toweb);
	}
}
