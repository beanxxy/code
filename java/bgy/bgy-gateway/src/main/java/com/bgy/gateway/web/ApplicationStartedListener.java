package com.bgy.gateway.web;

import org.springframework.context.ApplicationContext;

/**
 * 应用启动完成监听器接口*/


public interface ApplicationStartedListener {

    void onApplicationStarted(ApplicationContext applicationContext);
}
