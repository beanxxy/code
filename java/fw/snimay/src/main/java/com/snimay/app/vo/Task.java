package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 任务管理 
 * @title      : Task.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:51:27
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_task")
@App(query = "name", name = "任务管理" ,size=10)
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 任务名称
	 * @author     : xxy
	 */
	@field(text="任务名称",index=1)
	public String name;
/*	@field(text="流程数据",index=1)
	public String processVariables;
	@field(text="任务值",index=1)
	public String taskLocalVariables;
	@field(text="任务数据",index=1)
	public String taskVariables;*/
	/**
	 * 流向
	 * @author     : xxy
	 */
	@field(text="流向",index=1)
	public String come;
}
