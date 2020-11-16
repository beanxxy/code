package com.snimay.app;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.app.dto.UserLogin;
import com.snimay.app.vo.User;
import com.snimay.common.MD5;
import com.snimay.common.Status;
import com.snimay.common.ToWeb;
import com.snimay.hibernate.dao.ItemsRepository;

import io.swagger.annotations.ApiOperation;
/**   
 * : 登录接口 
 * @title      : LoginController.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:54:43
 * @version    : V1.0   
 */
@RestController
@RequestMapping("login")
public class LoginController {
	/**
	 * 工厂会话
	 * @author     : xxy
	 */
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 通用操作类
	 * @author     : xxy
	 */
	@Autowired
	ItemsRepository itemsRepository;
	/**
	 * : 将实体提交到指定的资源轻武器
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchAlgorithmException 
	 * @author     : xxy
	 * @param name
	 * @param entity
	 * @return
	 * @throws ClassNotFoundException
	 * @throws
	 */
	@ApiOperation(value="用户登录", notes="提交用户帐户和密码进行登录")
	@PostMapping("/")
	public  Object post(@RequestBody UserLogin user) throws NoSuchAlgorithmException, UnsupportedEncodingException   {
		Gson gs								=	new Gson();
		ToWeb toweb 						= 	new ToWeb();
		String ps							=	MD5.toString(user.password);
		List<User>  us						= 	itemsRepository.seach(sessionFactory, new User(),"username = '"+user.username+"'");
		com.snimay.app.vo.User		  u		=	us.size()>0? us.get(0):null;
		if(u!=null&&u.password.equals(ps)) {
			toweb.setObjData(u);
		}else {
			toweb.setMsg("用户或者密码错误！");
			toweb.setStatus(Status.NO_LOGIN);
		}
		//toweb.setObjData(user);
		return gs.toJson(toweb);
	}
	
	
}
