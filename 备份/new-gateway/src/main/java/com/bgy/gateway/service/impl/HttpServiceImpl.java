package com.bgy.gateway.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.enums.ResultEnum;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.http.HttpRequestEntity;
import com.bgy.gateway.http.HttpResponseEntity;
import com.bgy.gateway.http.HttpUtils;
import com.bgy.gateway.model.dto.ExternalBaseReq;
import com.bgy.gateway.model.entity.CommandLogEntity;
import com.bgy.gateway.repository.SysConfigRepository;
import com.bgy.gateway.service.CommandLogService;
import com.bgy.gateway.service.HttpService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;


/**
 * @author caijunwei
 * date 2020/12/3 15:43
 */
@Slf4j
@Service
public class HttpServiceImpl implements HttpService {

    @Autowired
    CommandLogService commandLogService;

    @Autowired
    SysConfigRepository sysConfigRepository;


    @SneakyThrows
    @Override
    public <T> T execute(ExternalBaseReq req, TypeReference<T> typeReference,String url) {
        CommandLogEntity record = new CommandLogEntity();
        record.setReqCode("");
        record.setReqTime(System.currentTimeMillis());
        record.setResult(Constant.CODE_ENGINE_REPLY_FAIL);

        record.setCreateAt(LocalDateTime.now());
        try {
            Optional<String> baseUrl = sysConfigRepository.getConfig(Constant.KEY_CONFIG_ENGINE_URL);
            if (!baseUrl.isPresent()) {
                throw new BusinessException(ResultEnum.HTTP_URL_EMPTY_ERROR);
            }

            String urlCommon = baseUrl.get() + url;

            HttpRequestEntity request = HttpRequestEntity.create()
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .textParams(req.toParams());

            String reqStr = JSONObject.toJSONString(request);
            record.setReq(reqStr);
            record.setPath(urlCommon);

            HttpResponseEntity response = HttpUtils.post(urlCommon, request);

            String respStr = JSONObject.toJSONString(response);

            record.setResult(Constant.CODE_ENGINE_SUCCESS);
            record.setResp(respStr);

            log.info("url:{}, request:{},\n response:{}", urlCommon, reqStr, respStr);
            if (response.isSuccessed()) {
                String data = response.getBody();
                T resp = JSONObject.parseObject(data, typeReference);
                return resp;
            } else {
                throw new BusinessException(ResultEnum.CODE_ERROR_EXTERNAL_API);
            }
        } catch (Exception e) {
            record.setResult(Constant.CODE_ENGINE_TIMEOUT);
            record.setResp(e.getMessage());
            throw new BusinessException(ResultEnum.CODE_ERROR_EXTERNAL_API);
        } finally {
            record.setRespTime(System.currentTimeMillis());
            commandLogService.saveCommandLogEntity(record);
        }
    }


}
