package com.bgy.gateway.util;

import com.bgy.gateway.web.InstanceFactory;
import com.bgy.gateway.web.SpringInstanceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ApplicationContext加载类
 */
@Component
@Lazy(false)
public class SpringUtils implements ApplicationContextAware {

    static Logger logger = LoggerFactory.getLogger(SpringUtils.class);

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InstanceFactory.loadFinished(new SpringInstanceProvider(applicationContext));
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        ApplicationContext context = getApplicationContext();
        if (context == null) {
            logger.warn("ApplicationContext is null");
        }
        return context == null ? null : context.getBean(name);
    }

    public static BeanDefinitionRegistry getBeanDefinitionRegistry() {
        ApplicationContext context = getApplicationContext();
        if (context == null) {
            logger.warn("ApplicationContext is null");
            return null;
        }
        BeanDefinitionRegistry factory =
                (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
        return factory;
    }

    public static void destroyBean(Object obj) {
        DefaultListableBeanFactory factory = ((DefaultListableBeanFactory) getBeanDefinitionRegistry());
        if (factory == null) {
            logger.warn("DefaultListableBeanFactory is null");
            return;
        }
        factory.destroyBean(obj);
    }

    public static Boolean containsBean(String name) {
        DefaultListableBeanFactory factory = ((DefaultListableBeanFactory) getBeanDefinitionRegistry());
        if (factory == null) {
            logger.warn("DefaultListableBeanFactory is null");
            return false;
        }
        return factory.containsBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        ApplicationContext context = getApplicationContext();
        if (context == null) {
            logger.warn("ApplicationContext is null");
        }
        return context == null ? null : context.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        ApplicationContext context = getApplicationContext();
        if (context == null) {
            logger.warn("ApplicationContext is null");
        }
        return context == null ? null : context.getBean(name, clazz);
    }

}
