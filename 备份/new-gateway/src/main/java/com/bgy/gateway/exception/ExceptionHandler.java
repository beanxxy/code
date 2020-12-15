package com.bgy.gateway.exception;
import com.bgy.gateway.enums.ResultEnum;
import com.bgy.gateway.model.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caijunwei
 * date 2020/11/26 9:38
 */

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);


    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResultVO handleException(Exception e) {
        LOGGER.error("API 捕获异常", e);

        if(e instanceof BusinessException) {
            BusinessException businessException = (BusinessException)e;
            return ResultVO.error(businessException.getCode(), businessException.getMessage());
        } else {
            return ResultVO.error(ResultEnum.OTHER_ERROR.getCode(), e.getMessage());
        }
    }
}
