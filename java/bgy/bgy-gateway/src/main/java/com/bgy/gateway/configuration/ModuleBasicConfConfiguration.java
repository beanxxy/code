package com.bgy.gateway.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration

@ComponentScan(value = {
        "com.bgy.gateway",
        "com.bgy.gateway.configuration.mqtt",
})
@IntegrationComponentScan("com.bgy.gateway.configuration.mqtt")
@EnableWebMvc
@EnableKafka
public class ModuleBasicConfConfiguration {
}
