package com.bgy.gateway.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * @author caijunwei
 * date 2020/11/27 16:53
 */
@Configuration

@ComponentScan(value = {
        "com.bgy.gateway",
        "com.bgy.gateway.configuration.mqtt",
})
@IntegrationComponentScan("com.bgy.gateway.configuration.mqtt")
@EnableWebMvc
public class ModuleBasicConfConfiguration {
}
