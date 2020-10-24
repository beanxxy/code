package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DeviceStatus {
    // 掉线
    OFFLINE(0),
    // 空闲
    IDLE(1),
    // 运行中
    WORKING(2),
    ;
    private final int status;

    private DeviceStatus(int status) {
        this.status = status;
    }

    @JsonValue
    public int getStatus() {
        return status;
    }

    @JsonCreator
    public static DeviceStatus fromStatus(int status) {
        for (DeviceStatus deviceStatus : values()) {
            if(status == deviceStatus.status) {
                return deviceStatus;
            }
        }

        return null;
    }
}
