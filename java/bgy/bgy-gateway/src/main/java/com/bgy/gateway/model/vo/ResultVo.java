package com.bgy.gateway.model.vo;

public class ResultVo {

    private String code;
    private String message;
    private Object data;

  

	public static ResultVo success() {
        return success(null);
    }

    public static ResultVo success(Object obj) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMessage(ResultEnum.SUCCESS.getMessage());
        resultVo.setData(obj);
        return resultVo;
    }


    public static ResultVo error(BaseResult baseResult) {
        return error(baseResult.getCode(), baseResult.getMessage());
    }

    public static ResultVo error(String code, String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        return resultVo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
}
