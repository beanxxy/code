package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 测试2 
 * @title      : Test2.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:51:40
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_test2")
@App(query = "test12", name = "测试2",size=10)
public class Test2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	@field(text = "测试12",index=1)	
	public String test12;
	@field(text = "测试22",index=1)	
	public String test22;
	@field(text = "测试32",index=1)	
	public String test32;
	@field(text = "测试42",index=1)	
	public String test42;
}
