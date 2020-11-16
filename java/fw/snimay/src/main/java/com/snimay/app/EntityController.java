package com.snimay.app;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.snimay.common.ToWeb;
import com.snimay.hibernate.EntityRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**   
 * : 通用接口 
 * @title      : ItemsController.java
 * @package    : com.snimay.app.entity
 * @author     : xxy
 * @date       : 2018年5月26日 下午12:01:09
 * @version    : V1.0   
 */
@RestController
@RequestMapping("entity")
@Scope("session")
public class EntityController extends Controller {
	
	/**
	 * 通用操作
	 * @author     : xxy
	 */
	@Autowired
	EntityRepository entityRepository;
	
	
	
	/**
	 * 获取实体，单个实体的详细
	 * @author     : xxy
	 * @param name
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws
	 */
	@ApiOperation(value="获取实体", notes="查看单个实体")
	@GetMapping("/{name}/{id}")
	public Object getone(@PathVariable("name") String name,@PathVariable("id") String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ToWeb toweb = new ToWeb();
		toweb.setObjData(entityRepository.seach(sessionFactory,Class.forName(packages+name).newInstance(), "id="+id));
		return new Gson().toJson(toweb);
	}
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
	@ApiOperation(value="实体列表", notes="查看实体列表")
	@GetMapping("/{name}/")
	public Object get(@PathVariable("name") String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ToWeb toweb = new ToWeb();
		toweb.setObjData(entityRepository.seach(sessionFactory,Class.forName(packages+name).newInstance(), "1=1"));
		return new Gson().toJson(toweb);
	}
	
	/**
	 * : 将实体提交到指定的资源轻武器
	 * @author     : xxy
	 * @param name
	 * @param entity
	 * @return
	 * @throws ClassNotFoundException
	 * @throws
	 */
	@ApiOperation(value="提交实体", notes="通过类名提交一个实体")
	@PostMapping("/{name}/")
	public Object post(@PathVariable("name") String name,@RequestBody String entity) throws ClassNotFoundException {
		ToWeb toweb = new ToWeb();
		Object ob	=	new Gson().fromJson(entity, Class.forName(packages+name));
		//sessionFactory.merge(ob);
		//sessionFactory
		Object o= entityRepository.save(sessionFactory,ob);
		toweb.setObjData(o);
		return new Gson().toJson(toweb);
	}
	/**
	 * : 对资源进行整体覆盖
	 * @author     : xxy
	 * @param name
	 * @param entity
	 * @return
	 * @throws JsonSyntaxException
	 * @throws ClassNotFoundException
	 * @throws
	 * @ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String",paramType = "path"),
			@ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "String")
	})
	 */
	@ApiOperation(value="覆盖实体", notes="提交一个实体，覆盖当前实体")
	@PutMapping("/{name}/")
	public Object put(@PathVariable("name") String name,@RequestBody String entity) throws JsonSyntaxException, ClassNotFoundException {
		ToWeb toweb = new ToWeb();
		toweb.setObjData(entityRepository.saveOrUpdate(sessionFactory,new Gson().fromJson(entity, Class.forName(packages+name))));
		return new Gson().toJson(toweb);
	} 
	
	/**
	 * : 对资源部分修改
	 * @author     : xxy
	 * @param name
	 * @param entity
	 * @return
	 * @throws JsonSyntaxException
	 * @throws ClassNotFoundException
	 * @throws
	 */
	@ApiOperation(value="更新实体", notes="对资源部分修改")
	@PatchMapping("/{name}/")
	public Object patch(@PathVariable("name") String name,@RequestBody String entity) throws JsonSyntaxException, ClassNotFoundException {
		ToWeb toweb = new ToWeb();
		toweb.setObjData(entityRepository.saveOrUpdate(sessionFactory,new Gson().fromJson(entity, Class.forName(packages+name))));
		return new Gson().toJson(toweb);
	}
	
	/**
	 * : 删除指定的资源
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @author     : xxy
	 * @param name
	 * @param entity
	 * @return
	 * @throws JsonSyntaxException
	 * @throws ClassNotFoundException
	 * @throws
	 */
	@ApiOperation(value="删除实体", notes="根据实体id进行删除")
	@DeleteMapping("/{name}/{id}")
	public Object delecte(@PathVariable("name") String name,@PathVariable("id") String id) throws JsonSyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ToWeb toweb = new ToWeb();
		List ls	=	entityRepository.seach(sessionFactory,Class.forName(packages+name).newInstance(), "id="+id);
		if(ls.size()>0)
		entityRepository.delecte(sessionFactory,ls.get(0));
		return new Gson().toJson(toweb);
	}
}
