package com.snimay.hibernate.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**   
 * : app模板注释 
 * @title      : App.java
 * @package    : com.snimay.hibernate.Annotation
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:18:04
 * @version    : V1.0   
 */
@Retention(RetentionPolicy.RUNTIME) 
@Documented//表格
public @interface App {
	/**
	 * 分页大小
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int size() default 25;
	/**
	 * 查询字段
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	String query() default "name";
	/**
	 * 界面长度
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int height() default 612;
	
	/**
	 * 界面宽度
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int width() default 502;
	/**
	 * 表名
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	String name() default "信息";
}
