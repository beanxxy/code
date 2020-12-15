package com.bgy.gateway.model.vo;
/**
 * @author caijunwei
 * date 2020/11/26 9:38
 */
public interface BaseResult {

    int getCode();

    String getMessage();

    BaseResult setMessage(String message);

}
