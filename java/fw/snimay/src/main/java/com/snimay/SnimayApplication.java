package com.snimay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 程序入口  类
 * @title      : SnimayApplication.java
 * @package    : com.snimay
 * @author     : xxy
 * @date       : 2018年8月7日 下午3:15:45
 * @version    : V1.0   
 */
@SpringBootApplication
@ComponentScan({"com.snimay","org.activiti"})
@EnableSwagger2
@Configuration  
@EnableAutoConfiguration
public class SnimayApplication extends SpringBootServletInitializer {

	/**
	 * 猪函数
	 * @author     : xxy
	 * @param args
	 * @throws
	 */
	public static void main(String[] args) {
		SpringApplication.run(SnimayApplication.class, args);
	}
	
	/**
	 * 配置
	 * @author     : xxy
	 * @param application
	 * @return
	 * @throws
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SnimayApplication.class);
    }

}
