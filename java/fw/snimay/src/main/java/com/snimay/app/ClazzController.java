package com.snimay.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.app.repository.ClazzRepository;
import com.snimay.app.repository.TablesRepository;
import com.snimay.app.vo.Clazz;
import com.snimay.app.vo.Tables;
import com.snimay.common.ToWeb;
import com.snimay.compiler.compiler.JavaFile;
import com.snimay.freemarker.FreemarkerUtil;
import com.snimay.hibernate.ModelService;
import com.snimay.hibernate.dao.ItemsRepository;

import io.swagger.annotations.ApiOperation;
/**   
 * : 数据类型接口 
 * @title      : ClazzController.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:53:28
 * @version    : V1.0   
 */
@RestController
@RequestMapping("class")
public class ClazzController extends	Controller{
	@Autowired
	ItemsRepository itemsRepository;

	@Autowired
	ModelService modelService;
	
	@Autowired
	TablesRepository repository;
	@Autowired
	FreemarkerUtil freemarkerUtil;
	@Autowired
	JavaFile javaFile;
	
	/**
	 * 获取类型结构
	 * @author     : xxy
	 * @param name
	 * @return
	 * @throws
	 */
	@ApiOperation(value="获取类型", notes="查看类型结构")
	@GetMapping("/{name}")
	public Object getOneByname(@PathVariable("name") String name) {
		ToWeb toweb = new ToWeb();
		Gson gs	=	new Gson();
		Class clazz	=	 getClass(name);
		//ModelService ms= new ModelService();
		toweb.setObjData(modelService.getMode(clazz));
		return new Gson().toJson(toweb);
	}
	
	/**
	 * 根据表格生成实体类
	 * @author     : xxy
	 * @param id
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws
	 */
	@ApiOperation(value="表的生成", notes="提供class表里的id,根据表id生成数据")
	@GetMapping("/createTable/{id}")
	public Object getOneBy(@PathVariable("id") Long id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ToWeb toweb = new ToWeb();
		Gson gs	=	new Gson();
		List ls	=	itemsRepository.seach(sessionFactory,Class.forName(packages+"Tables").newInstance(), "id="+id);
		Tables clazz = (Tables) ls.get(0);
		Map<String,Object> mp = gs.fromJson(gs.toJson(clazz),Map.class);
		String s =freemarkerUtil.getString("Entity.java", mp);
		toweb.setObjData(javaFile.setFile(s));
		
		//Configuration cfge = new Configuration().configure();
		/*StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources( serviceRegistry );
		sources.addAnnotatedClass(Class.forName(packages+clazz.name));
		SessionFactory sf  =sources.getMetadataBuilder().build().getSessionFactoryBuilder().build();*/
		//itemsRepository.seach(sf,Class.forName(packages+clazz.name).newInstance(), "1=1");
		//javaFile.setFile(s);
		return new Gson().toJson(toweb);
	}
	
	/**
	 * 获取实体类型，现在客户的权限范围内的实体类型
	 * @author     : xxy
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws
	 */
	@GetMapping("/")
	@ApiOperation(value="获取类型", notes="获取当前权限可以操作的类型")
	public Object get() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ToWeb toweb = new ToWeb();
		Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		List<Map> ls			=	new ArrayList<Map>();
		for(String s:map.keySet()) {
			//System.out.println(s);
			ClassMetadata clazz= map.get(s);
			Map	ms	=	(Map) modelService.getMode(clazz.getMappedClass());
			ls.add(ms);
		}
		toweb.setObjData(ls);
		return new Gson().toJson(toweb);
	}
	/**　
	 * 获取当前实体类型，现在客户的权限范围内的实体类型
	 * @author     : xxy
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws
	 */
	@GetMapping("/get")
	@ApiOperation(value="获取类型", notes="获取当前权限可以操作的类型")
	public Object getMap() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ToWeb toweb = new ToWeb();
		Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		Map<String, String>		mp	=	new HashMap<String,String>();
		for(String s:map.keySet()) {
			//System.out.println(s);
			ClassMetadata clazz= map.get(s);
			Map	ms	=	(Map) modelService.getMode(clazz.getMappedClass());
			mp.put(ms.get("text").toString(), ms.get("name").toString());
		}
		toweb.setObjData(mp);
		return new Gson().toJson(toweb);
	}
	
	/**
	 * 吧原有　的ｊａｖａ原形写入数据表格
	 * @author     : xxy
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws
	 */
	@PostMapping("/")
	@ApiOperation(value="写入表格", notes="把原有的java原形写入数据表")
	public Object post() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ToWeb toweb = new ToWeb();
		Gson	gn	= new Gson();
		Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		List<Map> ls			=	new ArrayList<Map>();
		for(String s:map.keySet()) {
			//System.out.println(s);
			ClassMetadata clazz= map.get(s);
			Map	ms		=	(Map) modelService.getMode(clazz.getMappedClass());
			Clazz cla	=	gn.fromJson(gn.toJson(ms), Clazz.class);
			System.out.println(gn.toJson(cla));
			itemsRepository.save(sessionFactory, cla);
			//repository.save(cla);
			//
			
			//ls.add(ms);
		}
		toweb.setObjData(ls);
		return new Gson().toJson(toweb);
	}
	
	/**
	 * 获取所有路径
	 * @author     : xxy
	 * @param request
	 * @return
	 * @throws
	 */
	@ApiOperation(value="获取所有", notes="所以路径")
    @GetMapping("/gettype")   
    public  Object gettype(HttpServletRequest request) {
		ToWeb toweb = new ToWeb();
        Map<String,String> result = new HashMap<String,String>();
        result.put("字符串", "string");
        result.put("长字符串", "text");
        result.put("整数", 	"int");
        result.put("浮点", 	"float");
        result.put("字符串", "string");
    	result.put("对象", 	"obj");
    	result.put("多个对象", "list");
        toweb.setObjData(result);
		return new Gson().toJson(toweb);
    }
	
	
	
	/**
	 * 获取选择字段
	 * @author     : xxy
	 * @param request
	 * @return
	 * @throws
	 */
	@ApiOperation(value="获取所字段", notes="使用字段选择")
    @GetMapping("/getfield")   
    public  Object getField(HttpServletRequest request) {
		ToWeb toweb = new ToWeb();
        Map<String,String> result =new TreeMap<String, String>(
	        new Comparator<String>() {
	            public int compare(String obj1, String obj2) {
	                // 降序排序
	                return obj2.compareTo(obj1);
	            }
	        });

        Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		List<Map> ls			=	new ArrayList<Map>();
		for(String s:map.keySet()) {
			//System.out.println(s);
			ClassMetadata clazz= map.get(s);
			Map	msx	=	(Map) modelService.getMode(clazz.getMappedClass());
			//ls.add(msx);
			List<Map> lmp	=	(List<Map>) msx.get("fields");
			String tname	=	(String) msx.get("name");
			for (Map map2 : lmp) {
				result.put(msx.get("text")+"-"+map2.get("text"),map2.get("name")+"");
			}
			
		}
        
		//result
        
        
        
        toweb.setObjData(result);
		return new Gson().toJson(toweb);
    }
	
	
	
	
	
}
