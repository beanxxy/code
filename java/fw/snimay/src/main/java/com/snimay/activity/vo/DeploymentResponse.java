package com.snimay.activity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.activiti.engine.repository.Deployment;
import org.activiti.rest.common.util.DateToStringSerializer;

import java.util.Date;

/**   
 * 流程类映射 
 * @title      : DeploymentResponse.java
 * @package    : com.snimay.activiti.vo
 * @author     : xxy
 * @date       : 2018年4月27日 上午11:57:57
 * @version    : V1.0   
 */
public class DeploymentResponse {
	private String id;
	private String name;
	@JsonSerialize(using = DateToStringSerializer.class, as=Date.class)
	private Date deploymentTime;
	private String category;
	private String tenantId;
  
	/**
	 * 初始化
	 * @author     : xxy
	 * @param deployment
	 * @throws
	 */
	public DeploymentResponse(Deployment deployment) {
		setId(deployment.getId());
		setName(deployment.getName());
		setDeploymentTime(deployment.getDeploymentTime());
		setCategory(deployment.getCategory());
		setTenantId(deployment.getTenantId());
	}
  
	 public String getId() {
	    return id;
	 }
	 public void setId(String id) {
	    this.id = id;
	 }
	 public String getName() {
	    return name;
	 }
	 public void setName(String name) {
	    this.name = name;
	 }
	 public  Date getDeploymentTime() {
	    return deploymentTime;
	 }
	 public void setDeploymentTime( Date deploymentTime) {
	    this.deploymentTime = deploymentTime;
	 }
	 public String getCategory() {
	    return category;
	 }
	 public void setCategory(String category) {
	    this.category = category;
	 }
	 public void setTenantId(String tenantId) {
	      this.tenantId = tenantId;
	 }
	 public String getTenantId() {
		  return tenantId;
	 }
}