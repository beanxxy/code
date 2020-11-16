package com.snimay.app.vo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;


/**   
 * 类型管理 
 * @title      : Clazz.java
 * @package    : com.snimay.app.clazz.vo
 * @author     : xxy
 * @date       : 2018年5月2日 下午2:31:25
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_clazz")
@App(query = "name", name = "类型管理",size=10)
public class Clazz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * : 类的名称 
	 * @author     : xxy
	 */
	@field(text = "类名")
	public String name; 
	
	/**
	 * : 类的名称 
	 * @author     : xxy
	 */
	@field(text = "别名")
	public String text; 
	
	
	//public String tablename;
	/**
	 * : 默认查询字段 
	 * @author     : xxy
	 */
	@field(text = "查询")
	public String query_;
	/**
	 * : 备注 
	 * @author     : xxy
	 */
	@field(text = "备注",anchor=1,index=3,length=255)
	public String remarks; 
	
	/**
	 * : 服务 
	 * @author     : xxy
	 */
	//@field(text = "服务")
	public String sever_;
    /**
     * : 类的字段 
     * @author     : xxy
     */
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
	@JoinColumn(insertable=true,updatable=true)
    @field(text="字段",index=1)
    public Set<Field>	fields;
}
