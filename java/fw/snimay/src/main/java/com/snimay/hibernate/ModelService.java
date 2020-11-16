package com.snimay.hibernate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.snimay.app.vo.User;
import com.snimay.app.vo.UserField;
import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;


 
 
/**   
 * : 数据模板
 * @title      : ModelService.java
 * @package    : com.snimay.heibernate
 * @author     : xxy
 * @date       : 2018年5月29日 下午4:12:40
 * @version    : V1.0   
 */
@Repository
public class ModelService {
	
	
	/*
	public static void main(String[] args) {
		ModelService ms = new ModelService();
		Object obj = ms.getMode(plksys.model.Entity.class);
		System.out.println(new Gson().toJson(obj));
	}*/
	
	@Autowired
	private HttpSession session;
	
	
	class Dat{
		public String text;
		public String dataIndex;
		public int flex = 1;
	} 
	/**
	 * 根据类返回字段
	 * @param clazz
	 * @return
	 */
	public List<Dat> getcolumnsByClass(Class clazz){
		List<Dat> ls = new ArrayList<Dat>();
		Field[] fields = clazz.getFields();
		for(Field f : fields){
		    String filedName = f.getName();
		    Annotation  annotation = f.getAnnotation(field.class);
		    if (annotation!=null) {
		    	Dat dat = new Dat();
		    	field xmlElement = (field)annotation;
		    	dat.text = xmlElement.text();
		    	dat.dataIndex = filedName;
		    	dat.flex = xmlElement.flex();
		    	ls.add(dat);
		    }
		}
		return ls;
	}
	
	/**
	 * 获取模型
	 * @author     : xxy
	 * @param clazz
	 * @return
	 * @throws
	 */
	public Object getMode(Class clazz){
		User	user = session.getAttribute("user")==null?null:(User) session.getAttribute("user");
		Map<String,String> fmap=new HashMap();
		Set<UserField> uf	=	null;
		if(user!=null) {
			uf	=	user.field;
			if(uf!=null)
			for (UserField userField : uf) {
				if(userField.starttime.getTime()<new Date().getTime()&&new Date().getTime()<userField.overtime.getTime()) {
					//mset.add(r);
					fmap.put(userField.db, "1");
				}
			}
		}
		
		
		Map<String,Object> data = new HashMap();
		List<Object>	   list	= new ArrayList<Object>();
		//================================================
		App  tableann 	= (App) clazz.getAnnotation(App.class);
		if(tableann!=null){
			String[] models = clazz.getName().toString().split("\\.");
			data.put("model",models[models.length-1]);
			data.put("name",models[models.length-1]);
			data.put("size"	,tableann.size());
			data.put("text"	,tableann.name());
			//data.put("sever_",tableann.sever());
			data.put("height",tableann.height());
			data.put("width",tableann.width());
			data.put("query_",tableann.query());
			
		}
		//================================================
		Field[] fields = clazz.getFields();
		for(Field f : fields){
			field fd= f.getAnnotation(field.class);
			if(fd!=null){
				Map<String,Object> objs = new HashMap();
				String modelstr = "";
				String[] clazzsname=f.getType().getName().split("\\.");
				String temp 	=f.getGenericType().toString();
				objs.put("name", f.getName());
				
				if(temp.length()>0){
					String[] models = temp.toString().split("\\.");
					modelstr 		= models[models.length-1].replaceAll(">", "");
				}
				objs.put("model", modelstr);
				
			//	System.out.println("sdfdf+"+f.getType().getName());
				if(clazzsname[clazzsname.length-1].equals("Long")) {
					objs.put("type", "int");
				}else if(clazzsname[clazzsname.length-1].equals("Date")) {
					objs.put("type", "date");
				}else if(clazzsname[clazzsname.length-1].equals("String")) {
					objs.put("type", "string");
				}else if(clazzsname[clazzsname.length-1].equals("Set")) {
					objs.put("type", "list");
				}else if(clazzsname[clazzsname.length-1].equals("int")) {
					objs.put("type", "int");
				}else if(clazzsname[clazzsname.length-1].equals("Int")) {
					objs.put("type", "int");
				}else if(clazzsname[clazzsname.length-1].equals("Float")) {
					objs.put("type", "float");
				}else {
					objs.put("type", "obj");
				}
				objs.put("flex", fd.flex());
				objs.put("clazz", f.getType().getName());
				objs.put("text", fd.text());
				objs.put("regex", fd.regex());
				objs.put("ishide", fd.ishide());
				objs.put("clazzquery", fd.vfield());
				objs.put("vfield", fd.vfield());
				objs.put("length_", fd.length());
				objs.put("index_", fd.index());
				objs.put("regextext", fd.regexText());
				objs.put("isonly", fd.isonly());
				objs.put("anchor", fd.anchor());
				objs.put("value",fd.value().getName());
				objs.put("inurl",fd.inurl());
				if(user!=null&&user.id!=-99999L) {
					if(fmap.get(data.get("name")+":"+objs.get("name"))!=null) {
						list.add(objs);
					}
				}else {
					list.add(objs);
				}
				
			}
		}
		data.put("fields", list);
		return data;
	}
	
	
}
