package com.bgy.gateway.util;


import com.bgy.gateway.configuration.mqtt.IDmsMqttSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author caijunwei
 * date 2020/6/19 9:43
 */
@Component
public class DeviceOnlineUtil implements ApplicationListener<ContextRefreshedEvent> {

    public static final Logger LOGGER = LoggerFactory.getLogger(DeviceOnlineUtil.class);


    @Value("${spring.mqtt.dms.wilData}")
    private String wilData;

    @Value("${spring.mqtt.dms.onlineTopic}")
    private String onlineTopic;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        IDmsMqttSender sender = SpringUtils.getBean(IDmsMqttSender.class);
        if (sender == null) {
            LOGGER.warn("未配置设备管理系统mqtt");
            return;
        }
        try {
            sender.sendToMqtt(onlineTopic, wilData);
            LOGGER.info("同步设备状态消息到设备管理系统：{} =》 {}", onlineTopic, wilData);
        } catch (Exception e) {
            LOGGER.info("发送MQTT失败{}", e);
        }

    }

}
