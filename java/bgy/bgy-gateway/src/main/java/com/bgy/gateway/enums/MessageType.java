package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageType {
    // 心跳
    HEARTBEAT(0),
    // 主动通信
    REQUEST(1),
    // 业务回复
    RESPONSE(2),
    // 心跳回复
    HEARTBEAT_RESPONSE(3),
    // 结果回复
    RESULT_RESPONSE(4),
    // 登录
    LOGIN(5),
    // 登录回复
    LOGIN_RESPONSE(6),
    ;
    private final int type;

    private MessageType(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static MessageType fromType(int type) {
        for (MessageType messageType : values()) {
            if(type == messageType.type) {
                return messageType;
            }
        }

        return null;
    }



}
