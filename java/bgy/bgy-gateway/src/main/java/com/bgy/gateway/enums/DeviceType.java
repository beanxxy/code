package com.bgy.gateway.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 四位十六进制标识：前两位标识类别，后两位标识子类别
 * */
public enum DeviceType {
    // 烹饪设备(简易中餐)
    COOK_SIMPLE_CHINESE_FOOD(0x1001),
    //烹饪设备(中餐厅)
    COOK_CHINESE_FOOD(0x1002),

    // 冷库设备(简易中餐)
    COLD_SIMPLE_CHINESE_FOOD(0x1101),
    // 冷库机械臂设备(火锅店)
    COLD_HOTPOT(0x1102),
    //冷库设备(中餐厅)
    COLD_CHINESE_FOOD(0x1103),
    //一体化蒸箱冷库设备（快餐厅）
    COLD_STEAMER_FAST_FOOD(0x1104),

    //餐桌设备(火锅店)
    TABLE_HOTPOT(0x1201),

    //物流线设备(火锅店)
    BELT_HOTPOT(0x1301),
    //自动物流线设备(快餐厅)
    BELT_AUTO_FAST_FOOD(0x1302),
    //人工物流线设备(快餐厅)
    BELT_ARTIFICIAL_FAST_FOOD(0x1303),
    //一体化蒸箱主控设备(快餐厅)
    BELT_STEAMER_FAST_FOOD(0x1304),
    //自助式蒸箱主控设备(快餐厅)
    BELT_STEAMER_SELF_FAST_FOOD(0x1305),

    //人工上菜口设备(火锅店)
    UPDISH_HOTPOT(0x1401),
    //上菜口(中餐厅) 5122
    UPDISH_CHINESE_FOOD(0x1402),

    //人工切菜口设备(火锅店)
    CUT_HOTPOT(0x1501),
    //饮料机(火锅店)
    DRINK_HOTPOT(0x1601),

    //下菜口设备(中餐厅)
    DOWN_CHINESE_FOOD(0x1701),

    //煲仔饭设备(中餐厅)
    CLAYPOT_CHINESE_FOOD(0x1801),

    //一体化蒸箱设备(快餐厅)
    STEAMER_FAST_FOOD(0x1901),
    //蒸箱设备(中餐餐厅)
    STEAMER_CHINESE_FOOD(0x1902),


    //保温设备(快餐厅)
    WARM_FAST_FOOD(0x1A01),
    //水保温柜(快餐厅)
    WARM_WATER_FAST_FOOD(0x1A02),

    //取餐柜设备类型
    TAKER_FAST_FOOD(0x1B01),

    //扫码设备类型
     SCAN_FAST_FOOD(0x1C01),

    //调酒机设备类型
    WINE_CHINESE_FOOD(0x1D01),


    //机械臂表情专用
    FACE_ARM_CODE_ONE(0x2001),


    //
    ;
    private final int type;

    private DeviceType(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static DeviceType fromType(int type) {
        for (DeviceType deviceType : values()) {
            if(type == deviceType.type) {
                return deviceType;
            }
        }

        return null;
    }
}
