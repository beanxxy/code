package com.bgy.gateway.configuration.mqtt;

import com.bgy.gateway.util.UUIDUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;


/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */
@Component
@ConfigurationProperties(prefix = "spring.mqtt.local")
@ConditionalOnProperty("spring.mqtt.local.url")
@EnableIntegration
public class LocalMqttConfig extends MqttConfig {


    /**
     * 订阅的bean名称
     */
    public static final String CHANNEL_NAME_IN = "localMqttInboundChannel";
    /**
     * 发布的bean名称
     */
    public static final String CHANNEL_NAME_OUT = "localMqttOutboundChannel";

    /**
     * MQTT客户端
     *
     * @return {@link org.springframework.integration.mqtt.core.MqttPahoClientFactory}
     */
    @Bean
    public MqttPahoClientFactory localMqttClientFactory() {
        return super.mqttClientFactory();
    }

    /**
     * MQTT信息通道（生产者）
     *
     * @return {@link org.springframework.messaging.MessageChannel}
     */
    @Bean(name = CHANNEL_NAME_OUT)
    public MessageChannel localMqttOutboundChannel() {
        return super.mqttOutboundChannel();
    }

    /**
     * MQTT消息处理器（生产者）
     *
     * @return {@link org.springframework.messaging.MessageHandler}
     */
    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_OUT)
    public MessageHandler localMqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(
                getProducerClientId()+ UUIDUtil.getUUID(),
                localMqttClientFactory());
        messageHandler.setAsync(false);
        messageHandler.setDefaultTopic(getProducerDefaultTopic());
        return messageHandler;
    }

    /**
     * MQTT消息订阅绑定（消费者）
     *
     * @return {@link org.springframework.integration.core.MessageProducer}
     */
    @Bean
    public MessageProducer appInbound() {
        // 可以同时消费（订阅）多个Topic
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
                        getConsumerClientId()+ UUIDUtil.getUUID(), localMqttClientFactory(),
                        getConsumerDefaultTopic().split(","));
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        // 设置订阅通道，多个mqtt srverss时，setOutputChannelName可以订阅，而setOutputChannel不可以?
        //adapter.setOutputChannel(mqttInboundChannel());
        adapter.setOutputChannelName(CHANNEL_NAME_IN);
        return adapter;
    }

    /**
     * MQTT信息通道（消费者）
     *
     * @return {@link org.springframework.messaging.MessageChannel}
     */
    @Bean(name = CHANNEL_NAME_IN)
    public MessageChannel localMqttInboundChannel() {
        return super.mqttInboundChannel();
    }
}
