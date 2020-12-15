package com.bgy.gateway.service;

import com.alibaba.fastjson.TypeReference;
import com.bgy.gateway.model.dto.ExternalBaseReq;

/**
 * @author caijunwei
 * date 2020/12/3 15:39
 */
public interface HttpService {

    /**
     * 执行
     * @param req
     * @param typeReference
     * @param url
     * @param <T>
     * @return
     */
    <T> T execute(ExternalBaseReq req, TypeReference<T> typeReference, String url);


}
