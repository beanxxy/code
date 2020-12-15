package com.bgy.gateway.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author caijunwei
 * date 2020/11/27 16:53
 */
@Slf4j
@Component
public class StartCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        log.info("===加载数据库表配置操作");

    }
}
