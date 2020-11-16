package com.snimay.app.vo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 测试 
 * @title      : Test.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:51:34
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_test")
@App(query = "test1", name = "测试",size=10)
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 测试1
	 * @author     : xxy
	 */
	@field(text = "测试1",index=1)	
	public String test1;
	@field(text = "测试2",index=1)	
	public String test2;
	@field(text = "测试3",index=1)	
	public String test3;
	@field(text = "测试4",index=1)	
	public String test4;
	
	@field(text = "测试int",index=1)	
	public int test6;
	
	@field(text = "日期",index=2)	
	public Date timess;
	
	@field(text = "测试5",index=3,length=255)	
	public String test5;
	
	
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "一对一测试",vfield="test12",index=2)
	public Test2 data;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "测试3")
    public Set<Test3> tests;
	
}
