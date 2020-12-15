package com.bgy.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author caijunwei
 * date 2020/11/25 10:47
 */

@SpringBootApplication
@EnableScheduling
@MapperScan("com.bgy.gateway.dao")
public class GatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GatewayApplication.class, args);

    }
}
