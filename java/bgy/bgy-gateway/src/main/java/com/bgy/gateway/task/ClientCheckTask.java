package com.bgy.gateway.task;

import com.bgy.gateway.enums.DeviceStatus;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.bgy.gateway.model.redis.RedisHeartbeat;
import com.bgy.gateway.model.redis.cold.ColdSimpleChineseFoodDeviceStatus;
import com.bgy.gateway.model.redis.cook.CookSimpleChineseFoodDeviceStatus;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.TaskUtil;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

@Component
public class ClientCheckTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCheckTask.class);

    @Autowired
    private RedisService redisService;

  @Scheduled(cron = "${gateway.heart-beat.cron}")
  public void openCheckHeartBeat() {
      if(TaskUtil.isHeartCheck()){
          onlineCheck();
      }
  }

    public void onlineCheck() {

       try {
           long currentTimeMillisecond = System.currentTimeMillis();

           Map<String, RedisHeartbeat> map = redisService.getHashAll(Constant.REDIS_HEARTBEAT_KEY, RedisHeartbeat.class);
           if(map == null || map.isEmpty()) {
               return;
           }
           map.forEach((deviceId, redisHeartbeat) -> {

               if(currentTimeMillisecond - redisHeartbeat.getLastRequestTime() > Constant.DEVICE_OFFLINE_MILLISECOND) {

                   // 二次校验，处理操作中设备又发送消息的情况
                   redisHeartbeat = redisService.getHash(Constant.REDIS_HEARTBEAT_KEY, deviceId, RedisHeartbeat.class);
                   if(currentTimeMillisecond - redisHeartbeat.getLastRequestTime() > Constant.DEVICE_OFFLINE_MILLISECOND) {
                       LOGGER.info("设备掉线ID" +
                               "" +
                               "[{}]", deviceId);


                       Channel channel = ChannelSupervise.getChannel(Integer.valueOf(deviceId));
                       if(channel != null) {
                           channel.close();
                       }

                       // 设备下线
                       try {
                           this.deviceOffline(redisHeartbeat);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }

                       redisService.removeHash(Constant.REDIS_HEARTBEAT_KEY, deviceId);

                   }
               }
           });
       }catch (Exception e){
           LOGGER.error("处理心跳数据异常 {}",e.getCause());
       }


    }

    private void deviceOffline(RedisHeartbeat redisHeartbeat){

        if(redisHeartbeat.getDeviceType() == null) {
            LOGGER.warn("没有找到对应的设备类型：{}", redisHeartbeat);
            return;
        }

        RedisDeviceStatus  deviceStatus =new RedisDeviceStatus();
        String  deviceValue="";
        boolean tag =false;
        switch (redisHeartbeat.getDeviceType()) {
            case COOK_SIMPLE_CHINESE_FOOD:
                deviceStatus = redisService.getHash(Constant.REDIS_DEVICE_STATE_KEY,
                        Integer.toString(redisHeartbeat.getDeviceId()), CookSimpleChineseFoodDeviceStatus.class);
                break;
            case COLD_SIMPLE_CHINESE_FOOD:
                deviceStatus = redisService.getHash(Constant.REDIS_DEVICE_STATE_KEY,
                        Integer.toString(redisHeartbeat.getDeviceId()), ColdSimpleChineseFoodDeviceStatus.class);
                break;
            default:
                deviceValue =redisService.getStringHash(Constant.REDIS_DEVICE_STATE_KEY+redisHeartbeat.getDeviceType().getType(), Integer.toString(redisHeartbeat.getDeviceId()));
                tag=true;
                break;
        }

        if(deviceStatus == null || StringUtils.isEmpty(deviceValue)) {
            return;
        }

        deviceStatus.setState(DeviceStatus.OFFLINE.getStatus());
        redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+redisHeartbeat.getDeviceType().getType(), Integer.toString(redisHeartbeat.getDeviceId()), tag==true?deviceValue:deviceStatus);
        LOGGER.info("更新设备状态信息 设备ID：{}, 数据 {}", redisHeartbeat.getDeviceId(), tag==true?deviceValue:deviceStatus);

    }
}
