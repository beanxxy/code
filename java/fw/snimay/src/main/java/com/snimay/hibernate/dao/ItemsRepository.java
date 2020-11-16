package com.snimay.hibernate.dao;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

/**   
 * : 通用数据库操作 
 * @title      : ItemsRepository.java
 * @package    : com.snimay.app.entity.repository
 * @author     : xxy
 * @date       : 2018年5月29日 上午11:57:40
 * @version    : V1.0  
 * @param <T> 
 */
@Repository
public class ItemsRepository<T> {
	/*@Autowired(required=true)
	private SessionFactory sessionFactory;*/
	
	/*public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	public Session getSession() {
		return  sessionFactory.openSession();
	}*/
	/**
	 * 保存
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @return
	 * @throws
	 */
	public Object save(SessionFactory sessionFactory,T paramT) {
		Session session = sessionFactory.openSession();
		Transaction tc = session.beginTransaction();
		Object obj= session.save(paramT);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} 
		session.close();
		return obj;
	}
	/**
	 * 保存和修改
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @return
	 * @throws
	 */
	public Object saveOrUpdate(SessionFactory sessionFactory,T paramT) {
		Session session = sessionFactory.openSession();
		Transaction tc = session.beginTransaction();
		session.saveOrUpdate(paramT);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} 
		session.close();
		return "";
	}
	/**
	 * 修改
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @return
	 * @throws
	 */
	public Object update(SessionFactory sessionFactory,T paramT) {
		Session session = sessionFactory.openSession();
		Transaction tc = session.beginTransaction();
		session.update(paramT);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} 
		session.close();
		return "";
	}
	/**
	 * 删除
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @return
	 * @throws
	 */
	public Object del(SessionFactory sessionFactory,T paramT) {
		Session session = sessionFactory.openSession();
		Transaction tc = session.beginTransaction();
		session.delete(paramT);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} 
		session.close();
		return "";
	}
	/**
	 * 删除
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @param paramString
	 * @throws
	 */
	public void delecte(SessionFactory sessionFactory,T paramT, String paramString) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		// TODO Auto-generated method stub
		List<T> ts = new ArrayList<T>();
		String[] className = paramT.getClass().toString().split("\\.");
		paramString = "id="+paramString;
		Query query  = session.createSQLQuery("delete From sys_"+ className[className.length-1] 
				+" where "+paramString	+"");
		query.executeUpdate();
		session.close();
	}
	/**
	 * 删除
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @throws
	 */
	public void delecte(SessionFactory sessionFactory,T paramT) {
		Session session = sessionFactory.openSession();
		Transaction tc = session.beginTransaction();
		session.delete(paramT);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	
	/**
	 * 查找
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @param paramString
	 * @return
	 * @throws
	 */
	public List<T> seach(SessionFactory sessionFactory,T paramT, String paramString) {
		Session session = sessionFactory.openSession();
		// TODO Auto-generated method stub
		List<T> ts = new ArrayList<T>();
		String[] className = paramT.getClass().toString().split("\\.");
		//System.out.println(paramT.toString());
		@SuppressWarnings("unchecked")
		List<T> list = session.createQuery("From "+ className[className.length-1] 
			+" where "+paramString	+" order by id desc").list();
		session.close();
		return list;
	}
	 
	
	/**
	 * 查找
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramString1
	 * @param paramString2
	 * @return
	 * @throws
	 */
	public List<T> seach(SessionFactory sessionFactory,String paramString1, String paramString2) {
		Session session = sessionFactory.openSession();
		List<T> ts = new ArrayList<T>();
		Transaction tc = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> list = session.createQuery("From "+ paramString1 
			+" where "+paramString2+" order by id desc").list();
		session.close();
		return list;
	}

	/**
	 * 
	 */
	/**
	 * 查找
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @param paramString1
	 * @param paramString2
	 * @param paramString3
	 * @return
	 * @throws
	 */
	public Map<String, Object> seach(SessionFactory sessionFactory,T paramT, String paramString1,
			String paramString2, String paramString3) {
		Session session = sessionFactory.openSession();
		List<T> ts = new ArrayList<T>();
		Transaction tc = session.beginTransaction();
		//serverBybean.mliss
		String[] className = paramT.getClass().toString().split("\\.");
		
		String queryString = "from " + className[className.length-1] + " where " + paramString1;
		
		Map<String,Object> map = new HashMap<String,Object>();
		int key = Integer.parseInt(session.createQuery("select count(*)"+
		" from " + className[className.length-1] + " where " + paramString1 +" order by id desc").list().get(0).toString());
		//优化
		//String queryStr = "from " + className[className.length-1] + " where " + paramString1 ;
		Query queryObject = session.createQuery(queryString);
		queryObject.setFirstResult(Integer.parseInt(paramString2));
		queryObject.setMaxResults(Integer.parseInt(paramString3)); 
		
		map.put("list", queryObject.list());
		map.put("size",key+"");
		session.close();
		return map;
	}
 
	
	public class OutData{
		public int count;
		public Object list;
	}
	/**
	 * 查找
	 * @author     : xxy
	 * @param sessionFactory
	 * @param paramT
	 * @param paramString1
	 * @param paramString2
	 * @param paramString3
	 * @return
	 * @throws
	 */
	public OutData seachByPage(SessionFactory sessionFactory,T paramT, String paramString1,String paramString2, String paramString3) {
		Session session = sessionFactory.openSession();
		List<T> ts = new ArrayList<T>();
		Transaction tc = session.beginTransaction();
		//serverBybean.mliss
		String[] className = paramT.getClass().toString().split("\\.");
		
		String queryString = "from " + className[className.length-1] + " where " + paramString1;
		Query queryObject = session.createQuery(queryString);
	
		OutData map = new OutData();
		int key = Integer.parseInt(session.createQuery("select count(*)"+
		" from " + className[className.length-1] + " where " + paramString1 +" order by id desc").list().get(0).toString());
		//优化
		//String queryStr = "from " + className[className.length-1] + " where " + paramString1 ;
		queryObject.setFirstResult(Integer.parseInt(paramString2));
		queryObject.setMaxResults(Integer.parseInt(paramString3));
		map.count = key;
		queryObject.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		map.list = queryObject.list();
		 
		session.close();
		return map;
	}
	 
	/**
	 * 执行存储过程
	 * @author     : xxy
	 * @param sessionFactory
	 * @param cp
	 * @param parameter
	 * @param keys
	 * @return
	 * @throws Exception
	 * @throws
	 */
	public Object call(SessionFactory sessionFactory,String cp,List<String> parameter,List<String> keys)  throws Exception{
		Gson gson = new Gson();
		String parameters = "";
		int columns ;int key = 0; 
		ResultSet rs;
		CallableStatement cs = null;
		ResultSetMetaData mataData = null;
		Map<String,List<Map>> data = new HashMap<String,List<Map>>();
		
		if(keys==null){
			keys = new ArrayList<String>();
		}
		for(int i=1;i<30;i++){
			keys.add("item"+i);
		} 
		
		if(parameter!=null)
		for(String temp:parameter){
			if(parameters.length()>0){
				parameters+=",";
			}
			try {
				parameters+="'"+java.net.URLDecoder.decode(temp, "UTF-8")+"'";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(parameters);
		Session session 	= 	sessionFactory.openSession();
		//Session session = SessionFactory.getSessionFactory().openSession();
		Connection conn = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
		try {
			cs = conn.prepareCall("call "+cp+"("+parameters+")");
			cs.execute();
			rs=cs.getResultSet();
			if(rs!=null){
				mataData = rs.getMetaData();
				List<Map> dals = new ArrayList<Map>();
				while(rs.next()){
					 //rs.getString(0);
					Map dat = new HashMap<String,Object>();
					for(int i=0;i<mataData.getColumnCount();i++){
						dat.put(mataData.getColumnName(i+1), rs.getObject(i+1));
					}
					dals.add(dat);
			    }
				data.put(keys.get(key), dals);key++;
				while(cs.getMoreResults()){
					List<Map> dals1 = new ArrayList<Map>();
					rs=cs.getResultSet();
					mataData = rs.getMetaData();
					while(rs.next()){
						Map dat = new HashMap<String,Object>();
						for(int i=0;i<mataData.getColumnCount();i++){
							dat.put(mataData.getColumnName(i+1), rs.getObject(i+1));
							//System.out.println(mataData.getColumnName(i));
						}
						dals1.add(dat);
					}
					data.put(keys.get(key), dals1);key++;
				}
			}
			cs.close();
			conn.close();
			session.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}
