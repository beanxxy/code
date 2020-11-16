package com.snimay.app.vo;

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
 * : 测试3额 
 * @title      : Test3.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:51:48
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_test3")
@App(query = "test3", name = "测试3额",size=10)
public class Test3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	@field(text = "测试3",index=1)	
	public String test12;
	@field(text = "测试23",index=1)	
	public String test23;
	@field(text = "测试33",index=1)	
	public String test33;
	@field(text = "测试43",index=1)	
	public String test43;
	
	
/*
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "一对一测试",vfield="test44",index=2)
	public Test4 data;*/
}
