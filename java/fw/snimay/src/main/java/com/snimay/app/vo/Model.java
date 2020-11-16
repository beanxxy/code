package com.snimay.app.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 流程模型 
 * @title      : Model.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:50:16
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_model")
@App(query = "name", name = "流程模型",size=10)
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 模板名称 
	 * @author     : xxy
	 */
	@field(text = "模板名称",index=1)
	public String name;
	/**
	 * 创建时间
	 * @author     : xxy
	 */
	@field(text = "创建时间",index=2)
	public Date createTime;
	/**
	 * 最后修改 
	 * @author     : xxy
	 */
	@field(text = "最后修改",index=2)
	public Date lastUpdateTime;
	/*@field(text = "键",index=2)
	public String keys;*/
	/**
	 * 资源id 
	 * @author     : xxy
	 */
	@field(text = "资源id",index=2)
	public int editorSourceValueId;
	/**
	 * 字段值 
	 * @author     : xxy
	 */
	@field(text = "字段值",index=2)
	public String metaInfo;
	/**
	 * 修订版 
	 * @author     : xxy
	 */
	@field(text = "修订版",index=2)
	public int revision;
	/**
	 * 模板版本 
	 * @author     : xxy
	 */
	@field(text = "模板版本",index=2)
	public int version;
	/**
	 * 发布版本
	 * @author     : xxy
	 */
	@field(text = "发布版本",index=2)
	public int deploymentId;
}
