package com.snimay.app.vo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;
/**   
 * : 数据权限 
 * @title      : UserField.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:52:38
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_userfield")
@App(query = "data", name = "数据权限",size=10)
public class UserField {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 开始时间
	 * @author     : xxy
	 */
	@field(text = "开始时间",index=2)
	public Date starttime;
	/**
	 * 结束时间
	 * @author     : xxy
	 */
	@field(text = "结束时间",index=3)
	public Date	overtime;
	/*@field(text = "是否只看")
	public String issee;*/
	/**
	 * 字段
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "字段",vfield="text",index=-1)
	public Field data;
	
	/**
	 * 数据
	 * @author     : xxy
	 */
	public String db;
}
