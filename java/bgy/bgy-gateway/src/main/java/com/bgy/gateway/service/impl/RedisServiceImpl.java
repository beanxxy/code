package com.bgy.gateway.service.impl;

import com.bgy.gateway.enums.DeviceStatus;
import com.bgy.gateway.enums.DeviceType;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.constant.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void pushHash(String key, String hashKey, Object value) {

        if(value instanceof String) {
            redisTemplate.opsForHash().put(key, hashKey, value);
        } else {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String valueStr = mapper.writeValueAsString(value);
                redisTemplate.opsForHash().put(key, hashKey, valueStr);
            } catch (JsonProcessingException e) {

            }
        }
    }

    @Override
    public void removeHash(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    @Override
    public boolean hasHashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    @Override
    public <T> T getHash(String key, String hashKey, Class<T> valueType) {

        String valueStr = (String)redisTemplate.opsForHash().get(key, hashKey);
        if(valueStr == null) {
            return null;
        }
        if(String.class == valueType) {
            return (T)valueStr;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(valueStr, valueType);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }

    @Override
    public <T> Map<String, T> getHashAll(String key, Class<T> valueType) {
        if(String.class == valueType) {
            Map<String, T> map = redisTemplate.opsForHash().entries(key);
            return map;
        } else {
            Map<String, T> resultMap = new HashMap<>();

            Map<String, String> map = redisTemplate.opsForHash().entries(key);

            if(map != null) {
                ObjectMapper mapper = new ObjectMapper();
                map.forEach((hasKey, valueStr) -> {
                    try {
                        T value = mapper.readValue(valueStr, valueType);
                        resultMap.put(hasKey, value);
                    } catch (JsonProcessingException e) {

                    }
                });
            }

            return resultMap;
        }
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public int nextUniqueKey() {
        Long increment = new RedisAtomicLong(Constant.REDIS_UNIQUE_KEY_KEY,
                redisTemplate.getConnectionFactory()).getAndIncrement();
        if(increment == null) {
            increment = new Random().nextLong();
        }

        return Integer.valueOf(String.valueOf((increment % Short.MAX_VALUE)));
    }



    @Override
    public Message getDeviceType(Integer deviceId) {
        Message msg = new Message();
        String type = this.getHash(Constant.REDIS_HEARTBEAT_KEY, deviceId.toString(),String.class);
        if(StringUtils.isEmpty(type)){
            LOGGER.info("已掉线 在心跳数据获取不到该设备类型 传入设备ID {},返回对象值{}",deviceId,type);
            return  null;
        }
        JSONObject object = JSONObject.fromObject(type);
        msg.setHeader(object.getInt("deviceType"));
        msg.setDeviceType(DeviceType.fromType(object.getInt("deviceType")));
        return msg;
    }

    @Override
    public Set<String> getKeys(String key) {
        Set<String> keys = redisTemplate.keys(key);
        if(keys.isEmpty()){
            return null;
        }
        return keys;
    }

    @Override
    public void expire(String key, long timeout, TimeUnit unit) {
        try {
            redisTemplate.expire(key,timeout,unit);
        }catch (Exception e){
            LOGGER.error("redis设置过期时间失效：{}",e);
        }

    }



    /**
     * 处理设备状态掉线数据
     * @param key
     * @param hashKey
     * @return
     */
    @Override
    public String getStringHash(String key, String hashKey) {
        String valueStr = (String)redisTemplate.opsForHash().get(key, hashKey);
        if(!StringUtils.isEmpty(valueStr)){
            JSONObject jsonObject = JSONObject.fromObject(valueStr);
            jsonObject.put(Constant.REDIS_STATE_KEY, DeviceStatus.OFFLINE.getStatus());
            return jsonObject.toString();
        }
        LOGGER.warn("没有找到对应的设备：{}", hashKey);
        return null;
    }
}
