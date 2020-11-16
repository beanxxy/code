package com.snimay.hibernate.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**   
 * : 字段注释 
 * @title      : field.java
 * @package    : com.snimay.hibernate.Annotation
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:18:17
 * @version    : V1.0   
 */
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
//@Target({ElementType.FIELD,ElementType.METHOD})//定义注解的作用目标**作用范围字段、枚举的常量/方法
@Documented//说明该注解将被包含在javadoc中
public @interface field {
	
	//
	/**
	 * value的类
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	Class value() default Object.class;
	
	/**
	 * 列名
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	String text() default "未知字段";
	/**
	 * 校验
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	String regex() default "";
	//
	/**
	 * 百分比宽度
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int flex() default 1;
	//
	/**
	 * 是否唯一
	 * @description: TODO
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int isonly() default 1;
	//
	/**
	 * 关联字段显示的列值
	 * @description: TODO
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	String vfield() default "";
	//;
	/**
	 * 长度
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int length() default 30;
	//
	/**
	 * 是否隐藏
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int ishide() default 0;
	//
	/**
	 * 排序
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	int index() default 0;
	//
	/**
	 * 校验提示信息
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	String regexText() default "数据格式不对!";
	
	/**
	 * 输入百分比
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	float anchor() default 0.5f;
	// 
	/**
	 * 选择输入
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	String inurl() default "";
}

