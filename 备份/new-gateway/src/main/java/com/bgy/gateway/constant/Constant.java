package com.bgy.gateway.constant;

/**
 * @author caijunwei
 * date 2020/11/26 9:38
 */
public class Constant {

    /* Redis */
    public static final String REDIS_UNIQUE_KEY_KEY = "new.gateway:unique:key";


    /*字段常量定义*/
    public static final String TASKID = "taskId";
    public static final String CODE = "code";
    public static final String COMPONENTCODE = "componentCode";
    public static final String FUNCTIONCODE = "functionCode";

    /*数控引起调用地址*/
    public static final String KEY_CONFIG_ENGINE_URL = "engine.base.url";

    /**
     * 与数控引擎交互结果
     * 1  数控引擎回应成功
     * 2  数控引擎回应失败
     * 3  调用数控引擎超时
     * 4  调用数控引擎内部报错
     */
    public static final int CODE_ENGINE_SUCCESS = 1;
    public static final int CODE_ENGINE_REPLY_FAIL = 2;
    public static final int CODE_ENGINE_TIMEOUT = 3;
    public static final int CODE_ENGINE_ERROR = 4;


}
