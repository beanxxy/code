package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExceptionStatus {
    // 正常
    OK(1),
    // 异常
    EXCEPTION(2),
    // 故障
    BREAKDOWN(3),
    // 急停
    EMERGENCY_STOP(4),
    // 缺盘
    NO_DISH(5),
    //获取菜肴失败
    GET_DISH_FAIL(6),
    //锁定
    lock(7),
    //菜品不合格
    UNQUALIFIED(8),
    //缺料
    LACK_MATERIALS(9),
    ;
    private final int status;

    private ExceptionStatus(int status) {
        this.status = status;
    }

    @JsonValue
    public int getStatus() {
        return status;
    }

    @JsonCreator
    public static ExceptionStatus fromStatus(int status) {
        for (ExceptionStatus exceptionStatus : values()) {
            if(status == exceptionStatus.status) {
                return exceptionStatus;
            }
        }

        return null;
    }
}
