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
 * : 用户权限 
 * @title      : RoleField.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:50:41
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_rolefield")
@App(query = "data", name = "用户权限",size=10)
public class RoleField {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 开始时间
	 * @author     : xxy
	 */
	@field(text = "开始时间")
	public Date starttime;
	/**
	 * 结束时间
	 * @author     : xxy
	 */
	@field(text = "结束时间")
	public Date	overtime;
	/**
	 * 是否只看
	 * @author     : xxy
	 */
	@field(text = "是否只看")
	public String issee;
	/**
	 * 字段
	 * @author     : xxy
	 */
	@ManyToOne(cascade = CascadeType.ALL)  
	@field(text = "字段")
	public Field data;
}
