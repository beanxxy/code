package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author caijunwei
 * date 2019/12/31 17:35
 */
public enum RespondStatus {
    // 成功
    SUCCESS(1),
    // 失败
    FAIL(2),
    ;
    private final int status;

    private RespondStatus(int status) {
        this.status = status;
    }

    @JsonValue
    public int getStatus() {
        return status;
    }

    @JsonCreator
    public static RespondStatus fromMode(int status) {
        for (RespondStatus respondStatus : values()) {
            if(status == respondStatus.status) {
                return respondStatus;
            }
        }

        return null;
    }
}
