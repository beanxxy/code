package com.bgy.gateway.enums;

import com.bgy.gateway.model.vo.BaseResult;

/**
 * @author caijunwei
 * date 2020/11/26 9:38
 */
public enum ResultEnum implements BaseResult {
    //系统
    SUCCESS(200, "成功!"),
    PARAM_ERROR(1001,"参数验证失败!"),
    PARAM_IS_NUNLL(1002, "参数为空"),
    SYSTEM_ERROR(1003,"系統错误"),
    DAO_ERROR(1004,"数据查询失败"),

    //数据库交互
    COMPONENT_QUERY_EMPTY_ERROR(2001,"组件表查找失败"),
    PLC_QUERY_EMPTY_ERROR(2002,"组件表查找失败"),
    FUNCTION_QUERY_EMPTY_ERROR(2003,"方法表查找失败"),
    MODEL_QUERY_EMPTY_ERROR(2004,"模型表查找失败"),
    PLC_INSERT_ERROR(2005,"PLC表插入失败"),
    COMPONENT_INSERT_ERROR(2006,"component组件表插入失败"),
    DATA_MODEL_INSERT_ERROR(2007,"datamodel组件表插入失败"),
    FUNCTION_INSERT_ERROR(2008,"function组件表插入失败"),
    MONITOR_INSERT_ERROR(2009,"monitor组件表插入失败"),
    ALARM_INSERT_ERROR(2010,"alarm组件表插入失败"),
    CONFIG_INSERT_ERROR(2011,"config组件表插入失败"),


    //业务处理
    ORDER_DEAIL_ERROR(3000,"封装调用设备处理异常"),
    HTTP_URL_EMPTY_ERROR(3001,"没有配置点餐系统访问地址"),
    SYNC_DATA_EMPTY_ERROR(3002,"同步配置表基本数据为空"),
    SYNC_DATA_EXCUTE_ERROR(3003,"同步表数据发生异常"),

    //调用外部接口
    CODE_ERROR_EXTERNAL_API(4000, "请求第三方放接口异常"),
    MQTT_EXCEPTION(40001, "操作失败，抛出异常记录日志"),
    OTHER_ERROR(9999,"其他错误"),
    ;

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
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
