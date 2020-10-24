package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author caijunwei
 * date 2020/1/2 9:42
 *
 * 命令的下发类型
 */
public enum CommandType {


    ZERO(0),

    ONE(1),

    TWO(2),

    THREE(3),

    FOUR(4),

    FIVE(5),

    SIX(6),

    SEVEN(7),

    EIGHT(8),

    NINE(9),

    TEN(10)

    ;
    private final int status;

    private CommandType(int status) {
        this.status = status;
    }

    @JsonValue
    public int getStatus() {
        return status;
    }

    @JsonCreator
    public static CommandType fromStatus(int status) {
        for (CommandType commandType : values()) {
            if(status == commandType.status) {
                return commandType;
            }
        }

        return null;
    }

}
