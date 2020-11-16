package com.snimay.activity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**   
 * 一些工具bean 
 * @title      : Cfg_Util.java
 * @package    : com.snimay.activiti.config
 * @author     : xxy
 * @date       : 2018年4月27日 上午11:56:52
 * @version    : V1.0   
 */
@Configuration
public class Cfg_Util {


    //jackson xml util
    /**
     * 映射管理
     * @author     : xxy
     * @return
     * @throws
     */
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
