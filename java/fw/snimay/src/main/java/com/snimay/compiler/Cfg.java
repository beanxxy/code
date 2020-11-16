package com.snimay.compiler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.snimay.compiler.compiler.JavaFile;

/**   
 * : 编码类 
 * @title      : Cfg.java
 * @package    : com.snimay.javacompiler.config
 * @author     : xxy
 * @date       : 2018年5月26日 下午5:47:41
 * @version    : V1.0   
 */
@Configuration
public class Cfg {
	/**
	 * 配置
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@Bean
	public JavaFile compilers() {
		return new JavaFile();
	}
}
