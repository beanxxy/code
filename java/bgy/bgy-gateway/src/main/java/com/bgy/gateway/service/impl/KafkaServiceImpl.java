package com.bgy.gateway.service.impl;


import com.bgy.gateway.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaServiceImpl.class);

    @Value("${gateway.store-id}")
    private String storeId;

    @Autowired
    private KafkaTemplate kafkaInsideTemplate;
   /* @Autowired
    private KafkaTemplate kafkaOutsideTemplate;*/


   // private static ConcurrentMap<Integer, List> errorMap = new ConcurrentHashMap();

/*    @Override
    public void pushToDeviceSystem(Message<RequestMessageIn> msg) {
        pushToDeviceSystem(msg, null);
    }

    @Override
    public void pushToDeviceSystem(Message<RequestMessageIn> msg, List<Integer> errorList) {

        if (TaskUtil.isPushDeviceSystem()) {
            try {
                  boolean flag[] = {true};
                  if(errorMap.containsKey(msg.getDeviceId())){
                      List oldList = errorMap.get(msg.getDeviceId());
                      if(errorList.equals(oldList)){
                          flag[0] = false;
                      }
                  }
                  if(flag[0]){
                      Channel channel = ChannelSupervise.getChannel(msg.getDeviceId());
                      if (channel == null) {
                          LOGGER.warn("设备[{}]未登录，停止向设备管理系统推送状态", msg.getDeviceId());
                          return;
                      }
                      String[] ipPort = NettyUtil.getChannelIpPortArray(channel);
                      MqttDevice kafkaDevice = new MqttDevice();
                      kafkaDevice.setStoreId(storeId);
                      kafkaDevice.setId(msg.getDeviceId());
                      kafkaDevice.setType(msg.getDeviceType().getType());
                      kafkaDevice.setCtrlMode(msg.getExtraData().getControlMode().getMode());
                      kafkaDevice.setState(msg.getExtraData().getDeviceStatus().getStatus());
                      kafkaDevice.setError(msg.getExtraData().getExceptionStatus().getStatus());
                      kafkaDevice.setIp(ipPort[0]);
                      kafkaDevice.setPort(Integer.valueOf(ipPort[1]));
                      kafkaDevice.setCt(System.currentTimeMillis());
                      if (errorList != null) {
                          kafkaDevice.setErrorList(errorList);
                      } else {
                          if (msg.getExtraData() instanceof RequestWarningMessageIn) {
                              kafkaDevice.setErrorList(((RequestWarningMessageIn) (msg.getExtraData())).getErrorList());
                          }
                      }
                     // kafkaOutsideTemplate.send(Constant.KAFKA_DEVICE_SYSTEM_TOPIC, kafkaDevice.toString());
                  }
                errorMap.put(msg.getDeviceId(),errorList);
            } catch (Exception e) {
                LOGGER.error("推送设备管理系统发生异常 {}", e);
            }
        }

    }*/

    @Override
    public void pushToInside(String topic, Object obj) {
        kafkaInsideTemplate.send(topic, obj.toString());
    }
}
