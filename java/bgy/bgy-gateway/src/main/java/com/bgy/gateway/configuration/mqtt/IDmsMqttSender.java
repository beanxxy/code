package com.bgy.gateway.configuration.mqtt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

/**
 * 设备管理系统
 */
@Component
@ConditionalOnProperty("spring.mqtt.dms.url")
@MessagingGateway(defaultRequestChannel = DmsMqttConfig.CHANNEL_NAME_OUT)
public interface IDmsMqttSender extends IMqttSender {
}