package com.bgy.gateway.exception;

import com.bgy.gateway.model.vo.BaseResult;

/**
 * @author caijunwei
 * date 2020/11/26 9:38
 */
public class BusinessException extends Exception implements BaseResult {

    private BaseResult baseResult;

    public BusinessException(BaseResult baseResult) {
        super();
        this.baseResult = baseResult;
    }

    public BusinessException(BaseResult baseResult, String message) {
        super();
        this.baseResult = baseResult;
        this.setMessage(message);
    }


    @Override
    public int getCode() {
        return this.baseResult.getCode();
    }

    @Override
    public String getMessage() {
        return this.baseResult.getMessage();
    }

    @Override
    public BaseResult setMessage(String message) {
        this.baseResult.setMessage(message);
        return this;
    }
}
