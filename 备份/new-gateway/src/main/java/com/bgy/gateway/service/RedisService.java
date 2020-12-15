package com.bgy.gateway.service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface RedisService {

    void pushHash(String key, String hashKey, Object value);

    void removeHash(String key, String hashKey);

    boolean hasHashKey(String key, String hashKey);

    <T> T getHash(String key, String hashKey, Class<T> valueType);

    <T> Map<String, T> getHashAll(String key, Class<T> valueType);

    void delete(String key);

    int nextUniqueKey();

    Set<String> getKeys(String key);

    void  expire(String key, long timeout, TimeUnit unit);

}
