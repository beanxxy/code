package com.snimay.app.vo;

import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.*;

/**   
 * @title      : Entity.java
 * @package    : com.snimay.app.entity.vo
 * : TODO 
 * @author     : xxy
 * @date       : 2018年5月29日 下午12:03:56
 * @version    : V1.0   
 */
@App(query = "${query_}", name = "${name}",size=10)
@javax.persistence.Entity
@Table(name = "SYS_${name?lower_case}")
public class ${name} {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID")
	public Long id;
<#list fields! as field> 
	<#if field.type="string">
	@field(text = "${field.text}",regex="",vfield="",length=100,index=3)
	public String ${field.name?lower_case};
<#elseif field.type="int">
	@field(text = "${field.text}",regex="",vfield="",length=100,index=1)
	public int ${field.name?lower_case};
<#elseif field.type="text">
	@field(text = "${field.text}",regex="",vfield="",length=100,index=4)
	public String ${field.name?lower_case};
<#elseif field.type="float">
	@field(text = "${field.text}",regex="",vfield="",length=100,index=2)
	public float ${field.name?lower_case};
<#elseif field.type="date">
	@field(text = "${field.text}",regex="",vfield="",length=100,index=5)
	public Date ${field.name?lower_case};		
<#elseif field.type="obj">
	@field(text="${field.text}",vfield="${field.clazzquery}",index=6)
	@ManyToOne(cascade = CascadeType.ALL)  
	public ${field.model} ${field.name?lower_case};
<#elseif field.type="list">
	@field(text="${field.text}",index=7)
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
	@JoinColumn(insertable=true,updatable=true)
    public Set<${field.model}> ${field.name?lower_case};
<#else>
	//@field(text="${field.text}",vfield="${field.clazzQuery}",index=1)
	//public ${field.clazz} ${field.name};
</#if>
</#list>
}