package com.bgy.gateway.configuration.mqtt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */
@Component
@ConditionalOnProperty("spring.mqtt.local.url")
@MessagingGateway(defaultRequestChannel = LocalMqttConfig.CHANNEL_NAME_OUT)
public interface ILocalMqttSender extends IMqttSender {
}
