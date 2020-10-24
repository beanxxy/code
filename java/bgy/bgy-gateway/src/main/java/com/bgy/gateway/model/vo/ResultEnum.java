package com.bgy.gateway.model.vo;

public enum ResultEnum implements BaseResult {
    //系统
    SUCCESS("100", "成功!"),
    PARAM_ERROR("1001","参数验证失败!"),
    PARAM_IS_NUNLL("1002", "参数为空"),
    SYSTEM_ERROR("1003","系統错误"),
    DAO_ERROR("1004","数据查询失败"),
    REQCODE_NULL("1005","请求参数reqCode为null"),
    REQCODE_EXIST("1006","reqCode已存在,重复请求"),
    PARAM_IS_FAULT("1007","deviceId的值为null或者等于0"),

    //网关-设备模块
    DEVICE_CREATE_ERROR("2001","设备信息创建失败"),
    DEVICE_UPDATE_ERROR("2002","设备信息创建失败"),
    DEVICE_NOT_EXIST("2003","设备信息查找失败"),
    CALL_NETTY_FAIL("2004","网关调用失败"),


    //发送控制指令失败
    DEVICE_CTRL_ERROR("3001","发送控制指令失败"),
    DEVICE_CTRL_TIMEOUT("3004","发送控制指令超时"),
    DEVICE_CONNECT_FAIL("3002","设备连接失败"),
    DEVICE_HAD_DISCONNECT("3003","设备已掉线"),

    //设备菜品关联
    DEVICE_DISHES_CREATE_FAIL("4001","设备菜品关联信息创建失败"),
    DEVICE_DISHES_UPDATE_FAIL("4002","设备菜品关联信息更新失败"),

    OTHER_ERROR("9999","其他错误"),
    ;


    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public BaseResult setMessage(String message) {
        this.message = message;
        return this;
    }


}
