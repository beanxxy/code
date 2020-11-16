package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

@Entity
@Table(name = "SYS_ttest4")
@App(query = "name4", name = "测试4",size=10)
public class TTest4 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	/**
	 * : 类的名称 
	 * @author     : xxy
	 */
	@field(text = "名称",anchor=1)
	public String name4; 
	
	/**
	 * : 类的名称 
	 * @author     : xxy
	 */
	@field(text = "备注",length=500,anchor=1)
	public String remark4;
}
