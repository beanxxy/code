package com.bgy.gateway.model.dto;
/**
 * @author caijunwei
 * date 2020/12/3 16:22
 */
public class ExternalHttpResp<T> {
    String code;
    String msg;
    T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return "0000".equals(code);
    }
}
