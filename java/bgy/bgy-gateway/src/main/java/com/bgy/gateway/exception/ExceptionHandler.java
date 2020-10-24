package com.bgy.gateway.exception;

import com.bgy.gateway.model.vo.ResultEnum;
import com.bgy.gateway.model.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResultVo handleException(Exception e) {
        LOGGER.error("API 捕获异常", e);

        if(e instanceof BusinessException) {
            BusinessException businessException = (BusinessException)e;
            return ResultVo.error(businessException.getCode(), businessException.getMessage());
        } else {
            return ResultVo.error(ResultEnum.OTHER_ERROR.getCode(), e.getMessage());
        }
    }
}
