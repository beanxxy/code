package com.snimay.app.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

@Entity
@Table(name = "SYS_mytest02")
@App(query = "context", name = "我的测试02",size=10)
public class MyTest02 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	@field(text="内容",index=1)
	public String context;
	
	@field(text="日期")
	public Date datetime;
	
}
