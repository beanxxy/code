package com.snimay.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.google.gson.Gson;
import com.snimay.app.dto.AppPath;
import com.snimay.app.vo.Appdb;
import com.snimay.app.vo.User;
import com.snimay.app.vo.UserApp;
import com.snimay.common.Status;
import com.snimay.common.ToWeb;
import com.snimay.hibernate.ModelService;
import com.snimay.hibernate.dao.ItemsRepository;

import io.swagger.annotations.ApiOperation;
/**   
 * : 功能接口 
 * @title      : AppController.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:53:09
 * @version    : V1.0   
 */
@RestController
@RequestMapping("app")
public class AppController  extends	Controller{
	/**
	 * 数据工厂
	 * @author     : xxy
	 */
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 数据操作
	 * @author     : xxy
	 */
	@Autowired
	ItemsRepository itemsRepository;
	
	/**
	 * 数据模型
	 * @author     : xxy
	 */
	@Autowired
	ModelService ms;
/*	@ApiOperation(value="功能列表", notes="获取功能列表")
	@GetMapping("/list")   
	public Object getlist() {
		ToWeb toweb = new ToWeb();
		toweb.setObjData(itemsRepository.seach(sessionFactory, getClassObject("Appdb"), "id="+id));
		return new Gson().toJson(toweb);
	}
	*/
	/**
	 * 会话
	 * @author     : xxy
	 */
	@Autowired
	private HttpSession session;
	
	/**
	 * 获取功能信息
	 * @author     : xxy
	 * @param id
	 * @return
	 * @throws
	 */
	@ApiOperation(value="功能信息", notes="获取功能信息")
	@GetMapping("/{id}")   
	public Object getAppdbbyid(@PathVariable("id") String id) {
		
		ToWeb toweb = new ToWeb();
		Gson  gson	= new Gson();
		
		User	user = (User) session.getAttribute("user");
		//user = null;
		if(user!=null) {
			Set<UserApp> apps = user.apps;
			Map<String,Appdb>	amap	=	new HashMap();
			Map<String,List>	pmap	=	new HashMap();
			for(Object obje: apps) {
				UserApp ua= (UserApp) obje;
				amap.put(ua.db+"",ua.data);
				
				
				if(ua.data.parent!=null) {
					if(pmap.get(ua.data.parent.id+"")==null) {
						List<Appdb> ls = new ArrayList<Appdb>();
						ls.add(ua.data);
						pmap.put(ua.data.parent.id+"", ls);
					}else {
						List<Appdb> ls = pmap.get(ua.data.parent.id+"");
						ls.add(ua.data);
						pmap.put(ua.data.parent.id+"", ls);
					}
				}
				//ua.data.parent.id
			}
			if(amap.get(id)==null) {
				toweb.setMsg("没有权限");
				toweb.setStatus(Status.NO_PRIVILEGE);
			}else {
				Appdb ap = amap.get(id);
				Map mp	= gson.fromJson(gson.toJson(ap), Map.class);
				mp.put("apps", pmap.get(id+""));
				toweb.setObjData(mp);
			}
		}else { 
			List<Appdb> ls	=	itemsRepository.seach(sessionFactory, getClassObject("Appdb"), "id="+id);
			if(ls!=null&&ls.size()>0) {
				Appdb ap = ls.get(0);
				List<Appdb> apps	=	itemsRepository.seach(sessionFactory, getClassObject("Appdb"), "parent="+id);
				Map mp	= gson.fromJson(gson.toJson(ap), Map.class);
				mp.put("apps", apps);
				toweb.setObjData(mp);
			}
		}
	
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
    @GetMapping("/get")   
    public  Object getAllUrl(HttpServletRequest request) {
		ToWeb toweb = new ToWeb();
        Map<String,String> result = new HashMap<String,String>();
        result.put("实体列表", "[GET][/entity/{name}/]");
    	result.put("实体添加", "[POST][/entity/{name}/]");
    	result.put("实体修改", "[PUT][/entity/{name}/]");    	
    	result.put("实体删除", "[DELETE][/entity/{name}/{id}]");
        
       /* WebApplicationContext wc = (WebApplicationContext) request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        RequestMappingHandlerMapping bean = wc.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = bean.getHandlerMethods(); 
        
        for (Iterator<RequestMappingInfo> iterator = map.keySet().iterator(); iterator.hasNext();) {
            RequestMappingInfo info = iterator.next();  
            String str = info.getMethodsCondition().toString()+info.getPatternsCondition();
            result.put(str, str);
        }  */
        toweb.setObjData(result);
		return new Gson().toJson(toweb);
    }
	
	/**
	 * 获取功能信息
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@ApiOperation(value="功能信息", notes="获取功能信息")
	@GetMapping("/")   
	public Object getApp() {
		ToWeb toweb = new ToWeb();
		toweb.setObjData(itemsRepository.seach(sessionFactory, getClassObject("Appdb"), "1=1"));
		return new Gson().toJson(toweb);
	}
	
	
	/**
	 * 获取选功能信息
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@ApiOperation(value="功能选择", notes="获取功能信息")
	@GetMapping("/getselect")   
	public Object getselect() {
		ToWeb toweb = new ToWeb();
		Map<String,String> result = new HashMap<String,String>();
		List<Appdb> lsap = itemsRepository.seach(sessionFactory, getClassObject("Appdb"), "1=1");
		for(Appdb ap : lsap) {
			result.put(ap.name, ap.id+"");
		}
		toweb.setObjData(result);
		return new Gson().toJson(toweb);
	}
	
	/**
	 * 获取功能信息
	 * @description: TODO
	 * @author     : xxy
	 * @param value
	 * @param key
	 * @param start
	 * @param result
	 * @param model
	 * @return
	 * @throws
	 */
	@ApiOperation(value="功能信息", notes="获取功能信息")
	@GetMapping("/{value}/{key}/{start}/{result}/{model}")   
	public Object getAppdb(
		@PathVariable("value") 	String value,
		@PathVariable("key") 	String key,	
		@PathVariable("start")	String start,
		@PathVariable("result") String result,
		@PathVariable("model") 	String model
	) {
		System.out.println(new Gson().toJson(value));
		ToWeb toweb = new ToWeb();
		toweb.setObjData(itemsRepository.seach(sessionFactory, getClassObject("Appdb"), "1=1"));
		return new Gson().toJson(toweb);
	}
	
	
	/**
	 * 添加一个功能
	 * @author     : xxy
	 * @param app
	 * @return
	 * @throws
	 */
	@ApiOperation(value="具体功能", notes="所以路径")
	@PostMapping("/add")   
	public Object add(@RequestBody Appdb app) {  
		ToWeb toweb = new ToWeb();
		itemsRepository.save(sessionFactory, app);
		return new Gson().toJson(toweb);
	}
	
	
	/**
	 * 通过路径获取功能信息
	 * @author     : xxy
	 * @param name
	 * @param request
	 * @return
	 * @throws
	 */
	@ApiOperation(value="具体功能", notes="所以路径")
	@PostMapping("/")   
	public Object getUrlMapping(@RequestBody AppPath name,HttpServletRequest request) {  
		ToWeb toweb = new ToWeb();
		WebApplicationContext wc = getWebApplicationContext(request.getSession().getServletContext());  
        RequestMappingHandlerMapping rmhp = wc.getBean(RequestMappingHandlerMapping.class);  
        Map<RequestMappingInfo, HandlerMethod> map = rmhp.getHandlerMethods();  
        List<Object> ls = new ArrayList<Object>();
        for (Iterator<RequestMappingInfo> iterator = map.keySet().iterator(); iterator.hasNext();) {
            RequestMappingInfo info = iterator.next();  
            String str = info.getMethodsCondition().toString()+info.getPatternsCondition();
           // System.out.println(str);
            if(name.path.equals(str)) {
            	HandlerMethod method = map.get(info);
            	Class[] clazzs = method.getMethod().getParameterTypes();
            	
            	for (Class class1 : clazzs) {
            		ls.add(ms.getMode(class1));
				}
            }
        }  
    	toweb.setObjData(ls);
    	return new Gson().toJson(toweb);
    }  
	
	/**
	 * 获取js模板
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@ApiOperation(value="获取模板", notes="js模板")
	@GetMapping("/getjs")   
	public Object String ()	{
		ToWeb toweb = new ToWeb();
		Map<String,String> result = new HashMap<String,String>();
		result.put("表格列表", "entity.panel");
		result.put("树形列表", "entity.tree");
		result.put("添加界面", "entity.add");
		result.put("修改界面", "entity.add");
		result.put("删除界面", "entity.del");
		toweb.setObjData(result);
		return new Gson().toJson(toweb);
	}
	/**
	 * 获取js模板
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@ApiOperation(value="获取模板", notes="js模板")
	@GetMapping("/gettype")   
	public Object Stringe ()	{
		ToWeb toweb = new ToWeb();
		Map<String,String> result = new HashMap<String,String>();
		result.put("列表按钮", "listButton");
		result.put("抬头按钮", "topButton");
		toweb.setObjData(result);
		return new Gson().toJson(toweb);
	}
	/**
	 * 获取server的webapplicationContext;
	 * @author     : xxy
	 * @param sc
	 * @return
	 * @throws
	 */
	public WebApplicationContext getWebApplicationContext(ServletContext sc) {  
        return WebApplicationContextUtils.getRequiredWebApplicationContext(sc);  
    }  
}
