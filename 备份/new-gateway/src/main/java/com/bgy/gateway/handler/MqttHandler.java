package com.bgy.gateway.handler;

import com.bgy.gateway.configuration.mqtt.LocalMqttConfig;
import com.bgy.gateway.enums.ResultEnum;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.vo.ResultVO;
import com.bgy.gateway.service.SyncDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

/**
 * @author caijunwei
 * date 2020/12/8 16:20
 */
@Slf4j
@Component
public class MqttHandler  {

    @Value("${spring.mqtt.local.consumerDefaultTopic}")
    private String syncDataTopic;

    @Autowired
    SyncDataService syncDataService;


    /**
     * 同步表数据
     */
    @Bean
    @ServiceActivator(inputChannel = LocalMqttConfig.CHANNEL_NAME_IN)
    public MessageHandler cloudAccept() {
        return message -> {
            String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
            String data = message.getPayload().toString();
            try {
                log.info("mqtt receive-->:[{}],{}", topic, data);
                if (StringUtils.isBlank(data)) {
                    log.warn("mqtt receive-->topic[{}]:{} error", topic, data);
                }
                ResultVO result = handle(topic, data);
                if (!result.isSuccess()) {
                    throw new BusinessException(ResultEnum.MQTT_EXCEPTION,result.getMessage());
                }
            } catch (Exception e) {
                log.error("MQTT ERROR:{}", e);
            }
        };
    }

    private ResultVO handle(String topic, String data) throws BusinessException {
        if (syncDataTopic.equals(topic)) {
            return syncDataService.syncData(data);
        }
        return ResultVO.success("不支持此topic");
    }
}
