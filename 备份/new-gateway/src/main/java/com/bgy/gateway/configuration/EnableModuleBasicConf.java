package com.bgy.gateway.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
/**
 * @author caijunwei
 * date 2020/11/27 16:53
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ModuleBasicConfConfiguration.class})
public @interface EnableModuleBasicConf {
}
