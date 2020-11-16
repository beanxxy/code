package com.snimay.app.vo;

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

@Entity
@Table(name = "SYS_ttest")
@App(query = "name", name = "测试是事实",size=10)
public class TTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	
	/**
	 * : 类的名称 
	 * @author     : xxy
	 */
	@field(text = "名称",anchor=1)
	public String name; 
	
	/**
	 * : 类的名称 
	 * @author     : xxy
	 */
	@field(text = "备注",length=500,anchor=1)
	public String remark;
	
	
	@ManyToOne(cascade=CascadeType.ALL)  
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@field(text = "一对一测试",vfield="name2",index=2)
	public TTest2 data;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
    @JoinColumn(insertable=true,updatable=true)
	@field(text = "测试3")
    public Set<TTest4> tests4;
	
	
	
}
