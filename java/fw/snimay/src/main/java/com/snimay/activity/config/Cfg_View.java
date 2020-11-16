package com.snimay.activity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**   
 * 关闭后跳转
 * @title      : Cfg_View.java
 * @package    : com.snimay.activiti.config
 * @author     : xxy
 * @date       : 2018年4月27日 上午11:57:09
 * @version    : V1.0   
 */
@Configuration
public class Cfg_View extends WebMvcConfigurerAdapter {

    /**
     * 添加界面控制
     * @author     : xxy
     * @param registry
     * @throws
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index.html");
    }
}
