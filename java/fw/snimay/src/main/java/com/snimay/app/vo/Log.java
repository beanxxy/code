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
 * : 业务日志 
 * @title      : Log.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:49:39
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_log")
@App(query = "name", name = "业务日志" ,size=10)
public class Log{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
    /**
     * 时间
     * @author     : xxy
     */
    @field(text="时间",index=1)
	public Date time;
    /**
     * URL地址
     * @author     : xxy
     */
    @field(text="url",index=1)
	public String url;
    /**
     * 访问方法
     * @author     : xxy
     */
    @field(text="method",index=1)
	public String method;
    /**
     * 输入数据
     * @author     : xxy
     */
    @field(text="in",index=1)
	public String in_;
    /**
     * 输出数据
     * @author     : xxy
     */
    @field(text="out",index=1)
	public String out_;
    /**
     * 事件
     * @author     : xxy
     */
    @field(text="event",index=1)
	public String event_;
    /**
     * 用户 
     * @author     : xxy
     */
    @field(text="用户",index=1)
	public String user_;
	/**
	 * 用户id
	 * @author     : xxy
	 */
	@field(text="ip",index=1)
	public String ip;
	/**
	 * 用户电脑mac地址
	 * @author     : xxy
	 */
	@field(text="电脑",index=1)
	public String mac;
}
