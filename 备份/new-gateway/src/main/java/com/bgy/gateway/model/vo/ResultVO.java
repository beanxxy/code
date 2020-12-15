package com.bgy.gateway.model.vo;


import com.bgy.gateway.enums.ResultEnum;

/**
 * @author caijunwei
 * date 2020/11/26 9:38
 */
public class ResultVO {

    private int code;
    private String message;
    private Object data;


    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO success(Object obj) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMessage(ResultEnum.SUCCESS.getMessage());
        resultVo.setData(obj);
        return resultVo;
    }

    public static ResultVO error(BaseResult baseResult) {
        return error(baseResult.getCode(), baseResult.getMessage());
    }

    public static ResultVO error(int code, String message) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        return resultVo;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.getCode() == 200;
    }
}
