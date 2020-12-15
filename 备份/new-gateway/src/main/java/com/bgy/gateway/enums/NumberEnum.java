package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author caijunwei
 * date 2020/11/30 17:02
 *
 * 常量定义
 */
public enum NumberEnum {


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

    TEN(10),

    SIXTY_NINE(69),

    NINETY(90),

    NINETY_NINE(99),

    HUNDRED(100),

    TWOHUNDRED(200)
    ;
    private final int value;

    private NumberEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValues() {
        return value;
    }

    @JsonCreator
    public static NumberEnum fromValues(int values) {
        for (NumberEnum numberEnum : values()) {
            if(values == numberEnum.value) {
                return numberEnum;
            }
        }

        return null;
    }

}
