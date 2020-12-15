package com.bgy.gateway.service.impl;


import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author caijunwei
 * date 2020/11/26 9:35
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {


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
            log.error("redis设置过期时间失效：{}",e);
        }

    }




}

