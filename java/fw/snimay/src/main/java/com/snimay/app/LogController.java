package com.snimay.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.common.ToWeb;
import com.snimay.hibernate.EntityRepository;

import io.swagger.annotations.ApiOperation;

/**   
 * : 日志 
 * @title      : ItemsController.java
 * @package    : com.snimay.app.entity
 * @author     : xxy
 * @date       : 2018年5月26日 下午12:01:09
 * @version    : V1.0   
 */
@RestController
@RequestMapping("log")
public class LogController extends Controller {
	
	/**
	 * 通用数据操作
	 * @author     : xxy
	 */
	@Autowired
	EntityRepository entityRepository;
	/**
	 * : 用于获取数据.
	 * @author     : xxy
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws @ApiImplicitParam(name = "name", value = "用户ID", required = true, dataType = "String", paramType = "path")
	 */
	@ApiOperation(value="日志列表", notes="查看系统日志")
	@GetMapping("/sys/")
	public Object sys() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String name	=	"Log";
		ToWeb toweb = new ToWeb();
		toweb.setObjData(entityRepository.seach(sessionFactory,Class.forName(packages+name).newInstance(), "1=1" ));
		return new Gson().toJson(toweb);
	}
	/**
	 * 登录日志
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@ApiOperation(value="日志列表", notes="查看登录日志")
	@GetMapping("/login/")
	public Object get() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String name	=	"Log";
		ToWeb toweb = new ToWeb();
		toweb.setObjData(entityRepository.seach(sessionFactory,Class.forName(packages+name).newInstance(),"url='/login/'"));
		return new Gson().toJson(toweb);
	}
	/**
	 * 错误日志
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@ApiOperation(value="日志列表", notes="查看系统错误日志")
	@GetMapping("/error/")
	public Object err() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String name	=	"SysLog";
		ToWeb toweb = new ToWeb();
		toweb.setObjData(entityRepository.seach(sessionFactory,Class.forName(packages+name).newInstance(), "1=1"));
		return new Gson().toJson(toweb);
	}
}
