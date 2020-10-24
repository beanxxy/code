package com.bgy.gateway.util;
import com.alibaba.fastjson.JSONObject;
import com.bgy.gateway.configuration.mqtt.IDmsMqttSender;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.model.kafka.MqttDevice;
import com.bgy.gateway.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author caijunwei
 * date 2020/5/5 21:10*/


@Component
public class PushDeviceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PushDeviceUtil.class);

    @Autowired
    private RedisService redisService;

    //@Autowired
    //private KafkaTemplate kafkaOutsideTemplate;

    @Value("${gateway.store-id}")
    private String storeId;

    @Value("${spring.mqtt.dms.producerDefaultTopic}")
    private  String deviceSystemTopic;

    @Scheduled(cron = "${gateway.device.cron}")
    public void openPushDeviceSystem() {
        if(TaskUtil.isPushDeviceSystem()){
            pushDeviceSystem();
        }
    }

    public void pushDeviceSystem() {

        try {
            Set<String> keys = redisService.getKeys(Constant.REDIS_PUSH_DEVICE_STATE_KEY);
            List<String> keyList = new ArrayList<>();
            keys.forEach(item -> {
                keyList.add(item);
            });
            keyList.forEach(item -> {
                Map<String, String> map = redisService.getHashAll(item,String.class);
                if(map != null && !map.isEmpty()) {
                   sendDeviceMsg(map);
                }
            });

        }catch (Exception e){
            LOGGER.error("状态上报据异常 {}",e.getStackTrace());
        }
    }

    private void sendDeviceMsg(Map<String, String> map) {
        for (String key : map.keySet()) {
            String valueObj = map.get(key);
            if(!StringUtils.isEmpty(valueObj)) {
                JSONObject json =JSONObject.parseObject(valueObj);
                MqttDevice mqttDevice = new MqttDevice();
                mqttDevice.setStoreId(storeId);
                mqttDevice.setId(Integer.valueOf(json.getString("id")));
                mqttDevice.setType(Integer.valueOf(json.getString("type")));
                mqttDevice.setCtrlMode(Integer.valueOf(json.getString("ctrlMode")));
                mqttDevice.setState(Integer.valueOf(json.getString("state")));
                mqttDevice.setError(Integer.valueOf(json.getString("error")));
                mqttDevice.setIp(json.getString("ip"));
                mqttDevice.setPort(Integer.valueOf(json.getString("port")));
                mqttDevice.setCt(System.currentTimeMillis());
                List<Integer> errorList = (List<Integer>) json.get("errorList");
                mqttDevice.setErrorList(errorList);
                /*try {
                    kafkaOutsideTemplate.send(Constant.KAFKA_DEVICE_SYSTEM_TOPIC, kafkaDevice.toString());
                    LOGGER.info("定时上报设备管理系统 {}",kafkaDevice);
                }catch (Exception e){
                    LOGGER.error("定时上报KAFKA异常 {} ",e);
                }*/
                IDmsMqttSender sender = SpringUtils.getBean(IDmsMqttSender.class);
                if (sender == null) {
                    LOGGER.warn("未配置设备管理系统mqtt");
                    return;
                }
                try {
                    sender.sendToMqtt(deviceSystemTopic, mqttDevice.toString());
                    //LOGGER.info("定时上报设备管理系统 {}",mqttDevice);
                }catch (Exception e){
                    LOGGER.error("定时上报MQTT异常 {} ",e);
                }

            }

        }
    }


}
