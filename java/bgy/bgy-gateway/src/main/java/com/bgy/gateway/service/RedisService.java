package com.bgy.gateway.service;

import com.bgy.gateway.model.message.Message;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisService {
    void pushHash(String key, String hashKey, Object value);
    void removeHash(String key, String hashKey);
    boolean hasHashKey(String key, String hashKey);
    <T> T getHash(String key, String hashKey, Class<T> valueType);
    <T> Map<String, T> getHashAll(String key, Class<T> valueType);

    void delete(String key);

    int nextUniqueKey();

    String getStringHash(String key, String hashKey);

    Message getDeviceType(Integer deviceId);

    Set<String> getKeys(String key);

    void  expire(String key, long timeout, TimeUnit unit);

}
