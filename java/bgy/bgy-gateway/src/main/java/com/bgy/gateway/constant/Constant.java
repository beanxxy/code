package com.bgy.gateway.constant;

public class Constant {

    public static final int DEVICE_OFFLINE_MILLISECOND = 45 * 1000;

    public static final int WAIT_RESPONSE_POLL_MILLISECOND = 10;
    public static final int WAIT_RESPONSE_RESULT_TIMEOUT_MILLISECOND = 3000;
    public static final int WAIT_RESPONSE_REPLY_RETRY_MILLISECOND = 1000;
    public static final int REQUEST_MAX_RETRY_TIME = 3;
    public static final String REQUEST_REQUEST_FLAG = "0";
    public static final String REQUEST_RESPONSE_FLAG = "1";
    public static final String REQUEST_RESPONSE_RESULT = "result";
    public static final String REQUEST_RESPONSE_KEY = "uniqueKey";
    public static final String REQUEST_RESPONSE_STATE = "state";
    public static final String REQUEST_RESPONSE_RESULT_VALUE = "SUCCESS";


    /* Redis */
    public static final String REDIS_UNIQUE_KEY_KEY = "gateway:unique:key";
    public static final String REDIS_HEARTBEAT_KEY = "gateway:heartbeat";
    public static final String REDIS_DEVICE_STATE_KEY = "gateway:device:state:";
    public static final String REDIS_RESPONSE_KEY = "gateway:response";
    public static final String REDIS_RESPONSE_RESULT_KEY = "gateway:response:result";
    public static final String REDIS_DEVICE_TAKER_KEY = "gateway:taker:";
    public static final String REDIS_DEVICE_ROBOT_KEY = "gateway:robot:";
    public static final String REDIS_STATE_KEY = "state";
    public static final String REDIS_ERRORlIST_KEY = "errorList";
    public static final String REDIS_PUSH_DEVICE_STATE_KEY = "gateway:device:state:*";

    /*Kafka*/
    public static final String KAFKA_DEVICE_SYSTEM_TOPIC = "device_state";

    public static final String KAFKA_DISCHARGE_TOPIC = "discharge";

    public static final String KAFKA_MISSION_TOPIC = "mission";

    public static final String KAFKA_STEAM_WATER_DEVICE_STOCK = "fastfood_steam_water_stock_change";


//    public static final String KAFKA_DISCHARGE_FAIL_TOPIC = "discharge_fail";

   //火锅冷库机械臂出菜
    public static final String KAFKA_HOTPOT_COLD_OUT_DISH_TOPIC = "hotpot_cold_out_dish";
    public static final String KAFKA_HOTPOT_COLD_PUT_GIRDLE_TOPIC = "hotpot_cold_put_girdle";
    public static final String KAFKA_HOTPOT_COLD_STATE_TOPIC = "hotpot_cold_state";
    public static final String KAFKA_HOTPOT_COLD_READ_DISH_TOPIC = "hotpot_cold_read_dish";


    //火锅餐桌设备
    public static final String KAFKA_HOTPOT_TABLE_PICK_DISH = "hotpot_table_pick_dish";
    public static final String KAFKA_HOTPOT_TABLE_ALLOCATED_DISH = "hotpot_table_allocated_dish";
    public static final String KAFKA_HOTPOT_TABLE_RESTART_STATE = "hotpot_table_restart_state";
    public static final String KAFKA_HOTPOT_TABLE_CALL_OUT = "hotpot_table_call_out";

    //火锅物流线设备
    public static final String KAFKA_HOTPOT_BELT_PICK_DISH = "hotpot_belt_pick_dish";
    public static final String KAFKA_HOTPOT_BELT_ALLOCATED_DISH = "hotpot_belt_allocated_rfid";
    public static final String KAFKA_HOTPOT_BELT_RESTART_STATE = "hotpot_belt_restart_state";
    public static final String KAFKA_HOTPOT_BELT_CALL_OUT = "hotpot_belt_call_out";

    //火锅上菜口设备
    public static final String KAFKA_HOTPOT_UPDISH_WRITE_DISH = "hotpot_updish_write_dish";
    public static final String KAFKA_HOTPOT_UPDISH_CONFIRM_DISH = "hotpot_belt_confirm_dish";

    //火锅切菜口设备
    public static final String KAFKA_HOTPOT_CUT_CONFIRM_DISH = "hotpot_cut_confirm_dish";
    public static final String KAFKA_HOTPOT_CUT_WRITE_DISH = "hotpot_cut_write_dish";

    //火锅饮料机设备
    public static final String KAFKA_HOTPOT_DRINK_TASK_FINISH = "hotpot_drink_task_finish";

    //一体化蒸箱设备
    public static final String KAFKA_FAST_FOOD_STREAM_OUT_DISH = "fastfood_stream_out_dish";
    public static final String KAFKA_FAST_FOOD_STREAM_REPLENISH_DISH = "fastfood_stream_replenish_dish";
    public static final String KAFKA_FAST_FOOD_STREAM_UPDOWN_DISH = "fastfood_stream_up_down";

    /**
     * 蒸箱盘子规格
     */
    public static final int STREAM_PLANT_SPECIFICATION=4;

    //扫码设备
    public static final String KAFKA_SCAN_CODE = "scan_code";

    //中餐发送主题
    public static final String KAFKA_CHINESE_FOOD_COLD_TOPIC = "chinesefood_cold_topic";
    public static final String KAFKA_CHINESE_FOOD_UP_TOPIC = "chinesefood_up_topic";
    public static final String KAFKA_CHINESE_FOOD_STEAM_TOPIC = "chinesefood_steam_topic";
    public static final String KAFKA_CHINESE_FOOD_DOWN_TOPIC = "chinesefood_down_topic";


    //火锅冷库机械臂固定端口
    public static final int ARM_PORT = 9004;
    public static final int ARM_HEARDER = 24159;
    public static final int ARM_DEVICEID = 512;
    public static final int ARM_CODE_ONE= 3073;
    public static final int ARM_CODE_TWO= 3074;
    public static final int ARM_CODE_THREE= 3075;
    public static final int ARM_CODE_FOUR= 3076;
    public static final int ARM_CODE_FIVE= 3077;
    public static final int ARM_CODE_SIX= 3078;

    //遗嘱变量
    public static final String MQTT_WILL_STORE= "restaurantId";
    public static final String MQTT_WILL_CODE= "code";
    public static final String MQTT_WILL_TIME= "time";
    public static final String MQTT_WILL_STORE_VALUE= "1139155282909802497";
    public static final String MQTT_WILL_CODE_VALUE= "1255803217013542913";


}
