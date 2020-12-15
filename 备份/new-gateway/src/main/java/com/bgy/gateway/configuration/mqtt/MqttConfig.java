package com.bgy.gateway.configuration.mqtt;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.messaging.MessageChannel;
/**
 * @author caijunwei
 * date 2020/11/27 16:53
 */
@Setter
@Getter
public class MqttConfig {
    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 地址 */
    private String url;

    private String producerDefaultTopic;

    private String consumerDefaultTopic;

    private String producerClientId;

    private String consumerClientId;

    private String willTopic;
    private String wilData;


    /**
     * MQTT客户端
     *
     * @return {@link org.springframework.integration.mqtt.core.MqttPahoClientFactory}
     */
    public MqttPahoClientFactory mqttClientFactory() {
        // 连接属性配置信息
        MqttConnectOptions options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(true);
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            // 设置连接的用户名
            options.setUserName(username);
            // 设置连接的密码
            options.setPassword(password.toCharArray());
        }
        // 设置超时时间 单位为秒
        options.setConnectionTimeout(10);
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
        options.setKeepAliveInterval(30);
        options.setServerURIs(url.split(","));
        //options.setWill(willTopic, wilData, 1, false);
        options.setWill(willTopic, wilData.getBytes(), 1, false);

        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(options);
        return factory;
    }

    /**
     * MQTT信息通道（生产者）
     *
     * @return {@link org.springframework.messaging.MessageChannel}
     */
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    /**
     * MQTT信息通道（消费者）
     *
     * @return {@link org.springframework.messaging.MessageChannel}
     */
    public MessageChannel mqttInboundChannel() {
        return new DirectChannel();
    }


}
