package com.bgy.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.bgy.gateway.mapper")
public class BgyGatewayApplication {



    public static void main(String[] args) {
        SpringApplication.run(BgyGatewayApplication.class, args);
    }

}
