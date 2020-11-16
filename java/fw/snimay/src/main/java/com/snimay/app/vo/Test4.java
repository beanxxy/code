package com.snimay.app.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 测试43额 
 * @title      : Test4.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:51:54
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_test44")
@App(query = "test44", name = "测试43额",size=10)
public class Test4 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	@field(text = "测试3",index=1)	
	public String test44;
	@field(text = "测试23",index=1)	
	public String test23;
	@field(text = "测试33",index=1)	
	public String test33;
	@field(text = "测试43",index=1)	
	public String test43;
}
