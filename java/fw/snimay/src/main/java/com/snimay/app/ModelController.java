package com.snimay.app;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.common.RestServiceController;
import com.snimay.common.ToWeb;

import io.swagger.annotations.ApiOperation;

/**   
 * : 模板接口 
 * @title      : ModelController.java
 * @package    : com.snimay.app.model
 * @author     : xxy
 * @date       : 2018年5月8日 上午10:22:57
 * @version    : V1.0   
 */
@RestController
@RequestMapping("model")
public class ModelController extends Controller implements  RestServiceController<Model, String>  {
	/**
	 * 操作类
	 * @author     : xxy
	 */
	@Autowired
	RepositoryService repositoryService;

	/**
	 * 获取
	 * @author     : xxy
	 * @param id
	 * @return
	 * @throws
	 */
	@Override
	@GetMapping("/")
	public Object getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@ApiOperation(value="获取模型", notes="模型")
	@Override
	@GetMapping("/{name}")
	public Object getList(Integer rowSize, Integer page) {
		// TODO Auto-generated method stub
		ToWeb toweb = new ToWeb();
		List<Model> deployments = repositoryService.createModelQuery().list();
		toweb.setObjData(deployments);
		return new Gson().toJson(toweb);
	}

	/**
	 * 修改一个模型
	 * @author     : xxy
	 * @param entity
	 * @return
	 * @throws
	 */
	@Override
	public Object postOne(Model entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object putOne(String id, Model entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object patchOne(String id, Model entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deleteOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
