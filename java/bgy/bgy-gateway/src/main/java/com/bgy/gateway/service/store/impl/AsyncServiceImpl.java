package com.bgy.gateway.service.store.impl;

import com.bgy.gateway.service.store.AsyncService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.util.concurrent.TimeUnit;

/**
 * @author caijunwei
 * date 2020/4/29 17:51
 */

@Service
@Data
@Slf4j
public class AsyncServiceImpl implements AsyncService {
    @Async
    @Override
    public void async() {
        log.info("开始进行业务逻辑执行");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            log.error("线程中断异常:{}", e);
        }
        log.info("业务逻辑执行结束");
    }
}
