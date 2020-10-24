package com.bgy.gateway.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ModuleBasicConfConfiguration.class})
public @interface EnableModuleBasicConf {
}
