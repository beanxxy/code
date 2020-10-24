package com.bgy.gateway.configuration;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class ApplicationStarter {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationStarter.class).web(WebApplicationType.SERVLET).run(args);
    }
}
