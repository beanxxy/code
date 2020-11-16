package com.snimay.app;

import org.hibernate.SessionFactory;

/**   
 * : 接口父类
 * @title      : Controller.java
 * @package    : com.snimay.app
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:53:37
 * @version    : V1.0   
 */
public class Controller {
	/**
	 * 包名
	 * @author     : xxy
	 */
	public String packages="com.snimay.app.vo";
	/**
	 * 数据工厂
	 * @author     : xxy
	 */
	public SessionFactory sessionFactory;
	/**
	 * 获取会话工厂
	 * @author     : xxy
	 * @param seesionFarctory
	 * @throws
	 */
	public void setSeesionFactory(SessionFactory seesionFarctory) {
		this.sessionFactory	=	seesionFarctory;
	}
	/**
	 * 获取包名
	 * @author     : xxy
	 * @param packages
	 * @throws
	 */
	public void setPackages(String packages) {
		this.packages	=	packages+".";
	}
	/**
	 * 通过类名获取java实体
	 * @author     : xxy
	 * @param name
	 * @return
	 * @throws
	 */
	public Class getClass(String name) {
		try {
			return Class.forName(packages+name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据名称获取实体的对象，新的对象
	 * @author     : xxy
	 * @param name
	 * @return
	 * @throws
	 */
	public Object getClassObject(String name) {
		try {
			return getClass(name).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
