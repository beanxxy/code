package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ControlMode {
    // 自动模式
    AUTO(1),
    // 手动模式
    MANUAL(2),
    ;
    private final int mode;

    private ControlMode(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getMode() {
        return mode;
    }

    @JsonCreator
    public static ControlMode fromMode(int mode) {
        for (ControlMode controlMode : values()) {
            if(mode == controlMode.mode) {
                return controlMode;
            }
        }

        return null;
    }
}
