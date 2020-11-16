package com.snimay.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.app.vo.Permission;
import com.snimay.app.vo.User;
import com.snimay.common.Status;
import com.snimay.common.ToWeb;
import com.snimay.hibernate.EntityRepository;

import io.swagger.annotations.ApiOperation;

/**   
 * : 用户字段 
 * @title      : UserFieldController.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:14:13
 * @version    : V1.0   
 */
@RestController
@RequestMapping("UserField")
public class UserFieldController extends	Controller{
	
	/**
	 * 通用数据操作
	 * @author     : xxy
	 */
	@Autowired
	EntityRepository entityRepository;
	
	/**
	 * 获取用户权限
	 * @author     : xxy
	 * @param id
	 * @return
	 * @throws
	 */
	@ApiOperation(value="查看权限", notes="提供用户id，获取用户权限")
	@GetMapping("/")
	public Object get(@PathVariable("id") String id) {
		ToWeb toweb 	= 	new ToWeb();
		List<User> ls  	=	entityRepository.seach(sessionFactory, getClassObject("User"), "id="+id);
		if(ls.size()==0) {
			toweb.setMsg("不存在当前用户");
			toweb.setStatus(Status.ENABLE+"");
		}else {
			//toweb.setObjData(ls.get(0).permission);
		}
		return new Gson().toJson(toweb);
	}
	
	/**
	 * 给指定的用添加权限
	 * @author     : xxy
	 * @param id
	 * @param pid
	 * @return
	 * @throws
	 */
	@ApiOperation(value="添加权限", notes="给指定的用户添加权限")
	@PostMapping("/")
	public Object add(@PathVariable("id") String id,@PathVariable("pid") String pid) {
		ToWeb toweb 		= 	new ToWeb();
		List<User> ls  		=	entityRepository.seach(sessionFactory, getClassObject("User"), "id="+id);
		List<Permission>  lp=	entityRepository.seach(sessionFactory, getClassObject("Permission"), "id="+id);
		if(ls.size()==0||lp.size()==0) {
			String msg = "";
			if(ls.size()==0)
				msg +=  "不存在当前用户:"+id;
			if(lp.size()==0)
				msg +=  "不存在权限:"+pid;
			toweb.setMsg(msg);
			toweb.setStatus(Status.ENABLE+"");
		}else {
			User u		=	ls.get(0);
			com.snimay.app.vo.UserPermission p = new com.snimay.app.vo.UserPermission();
			p.data		=	lp.get(0);
			p.starttime	= 	new Date(); 
			p.overtime	=	new Date(p.starttime.getTime()+1000*60*60*24*365*50);//50年
			/*if(u.permission==null)
				u.permission = new HashSet<com.snimay.app.vo.UserPermission>();
		    u.permission.add(p);*/
			entityRepository.save(sessionFactory,  u);
		}
		return new Gson().toJson(toweb);
	}
	
	
}
