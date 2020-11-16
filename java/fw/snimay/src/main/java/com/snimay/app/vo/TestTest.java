package com.snimay.app.vo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * : 关系测试 
 * @title      : TestTest.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:52:00
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_testtest")
@App(query = "name", name = "关系测试",size=10)
public class TestTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	@field(text = "名称",index=1)	
	public String name; 
 
	@ManyToOne(cascade=CascadeType.ALL)  
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@field(text = "一对一测试",vfield="name",index=2)
	public TestTest2 data;
	
	

}
