package com.snimay.app.dto;

import com.snimay.hibernate.Annotation.App;
import com.snimay.hibernate.Annotation.field;

/**   
 * 查看输入路径 
 * @title      : AppPath.java
 * @package    : com.snimay.app.dto
 * @author     : xxy
 * @date       : 2018年8月7日 上午9:41:17
 * @version    : V1.0   
 */
@App(name="查看输入")
public class AppPath {
	/**
	 * 路径
	 * @author     : xxy
	 */
	@field(text = "路径")
	public String path;
}
