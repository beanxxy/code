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
 * : 系统日志 
 * @title      : SysLog.java
 * @package    : com.snimay.app.vo
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:51:14
 * @version    : V1.0   
 */
@Entity
@Table(name = "SYS_syslog")
@App(query = "url", name = "系统日志" ,size=10)
public class SysLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID",ishide=1)
	public Long id;
	/**
	 * 日志时间
	 * @author     : xxy
	 */
	@field(text = "日志时间")
	public Date time;
	/**
	 * "日志路径
	 * @author     : xxy
	 */
	@field(text = "日志路径")
	public String url;
	/**
	 * 日志方法
	 * @author     : xxy
	 */
	@field(text = "日志方法")
	public String method;
	/**
	 * 输入
	 * @author     : xxy
	 */
	@field(text = "输入")
	public String in_;
	/**
	 * 输出
	 * @author     : xxy
	 */
	@field(text = "输出")
	public String out_;
	/**
	 * 事件类型
	 * @author     : xxy
	 */
	@field(text = "事件类型")
	public String event_;
    /**
     * 用户
     * @author     : xxy
     */
    @field(text="用户",index=1)
	public String user_;
	/**
	 * 电脑ip
	 * @author     : xxy
	 */
	@field(text="ip",index=1)
	public String ip;
	/**
	 * 电脑mac地址
	 * @author     : xxy
	 */
	@field(text="电脑",index=1)
	public String mac;
}
