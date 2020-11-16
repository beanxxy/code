package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 工作流程 
 * @title      : Process.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:50:28
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_process")
@App(query = "id", name = "工作流程",size=10)
public class Process {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID")
	public Long id;
	/**
	 * 版本号
	 * @author     : xxy
	 */
	@field(text = "版本号",index=2)
	public int deploymentId;
	/**
	 * 资源名称 
	 * @author     : xxy
	 */
	@field(text = "资源名称",index=2)
	public String diagramResourceName;
	/**
	 * 官网地址 
	 * @author     : xxy
	 */
	@field(text = "官网地址",index=2)
	public String category;
	/**
	 * 流程版本 
	 * @author     : xxy
	 */
	@field(text = "流程版本",index=2)
	public String resourceName;
	/*@field(text = "流程版本",index=2)
	public String tenantId;*/
	/**
	 * 流程版本 
	 * @author     : xxy
	 */
	@field(text = "流程版本",index=2)
	public int	version;
	
	
	
	
	
	
	
	
	
	
}
