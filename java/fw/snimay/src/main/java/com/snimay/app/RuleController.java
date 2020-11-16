package com.snimay.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.snimay.app.vo.Rules;
import com.snimay.common.ToWeb;
import com.snimay.hibernate.ModelService;
import com.snimay.hibernate.dao.ItemsRepository;

import io.swagger.annotations.ApiOperation;

/**   
 * : 角色接口 
 * @title      : RuleController.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:54:57
 * @version    : V1.0   
 */
@RestController
@RequestMapping("rule")
public class RuleController  extends	Controller{
	
	/**
	 * 数据库会话
	 * @author     : xxy
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 通用数据操作类
	 * @author     : xxy
	 */
	@Autowired
	ItemsRepository itemsRepository;
	
	/**
	 * 类模型类
	 * @author     : xxy
	 */
	@Autowired
	ModelService ms;
 
	/**
	 * 用户会话
	 * @author     : xxy
	 */
	@Autowired
	private HttpSession session;
	
	/**
	 * 使用规则选择
	 * @author     : xxy
	 * @param request
	 * @return
	 * @throws
	 */
	@ApiOperation(value="获取所有规则", notes="使用规则选择")
    @GetMapping("/get")   
    public  Object getRules(HttpServletRequest request) {
		ToWeb toweb = new ToWeb();
        Map<String,String> result = new HashMap<String,String>();
        List<Rules> ls	=	itemsRepository.seach(sessionFactory, getClassObject("Rules"), "1=1");
        for (Rules rules : ls) {
        	result.put(rules.name,rules.cname);
		}
        toweb.setObjData(result);
		return new Gson().toJson(toweb);
    }
	
	/**
	 * 字段数据选择
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
			Map	msx	=	(Map) ms.getMode(clazz.getMappedClass());
			//ls.add(msx);
			List<Map> lmp	=	(List<Map>) msx.get("fields");
			String tname	=	(String) msx.get("name");
			for (Map map2 : lmp) {
				result.put(msx.get("text")+"-"+map2.get("text"),tname+":"+map2.get("name"));
			}
			
		}
        
		//result
        
        
        
        toweb.setObjData(result);
		return new Gson().toJson(toweb);
    }
	
	/**
	 * 数据选择
	 * @author     : xxy
	 * @param request
	 * @return
	 * @throws
	 */
	@ApiOperation(value="获取所以事件", notes="事件选择")
    @GetMapping("/geteven")
    public  Object geteven(HttpServletRequest request) {
		ToWeb toweb = new ToWeb();
        Map<String,String> result = new HashMap<String,String>();
        result.put("值改变", "change");
		result.put("聚集后", "focus");
		result.put("失焦后", "blur");
		result.put("加载后", "load");
		result.put("提交前", "bfsubmit");
        toweb.setObjData(result);
		return new Gson().toJson(toweb);
    }
	
}
