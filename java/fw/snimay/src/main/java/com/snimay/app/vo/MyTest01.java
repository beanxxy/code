package com.snimay.app.vo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

@Entity
@Table(name = "SYS_mytest01")
@App(query = "mytest01", name = "我的测试01",size=10)
public class MyTest01 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	@field(text="内容",index=1)
	public String context;
	
	@field(text="日期",index=2)
	public Date datetime;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@field(text="一对一测试",vfield="context",index=2)
	public MyTest02 text;
}
