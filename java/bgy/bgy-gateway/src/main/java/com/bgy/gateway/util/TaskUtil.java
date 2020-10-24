package com.bgy.gateway.util;

/**
 * @author caijunwei
 * date 2020/3/8 20:18
 */
public class TaskUtil {

     private static boolean heartLog =false;

    private static boolean heartCheck =true;

    private static boolean pushDeviceSystem =true;

    public static boolean isHeartLog() {
        return heartLog;
    }

    public static void setHeartLog(boolean heartLog) {
        TaskUtil.heartLog = heartLog;
    }

    public static boolean isHeartCheck() {
        return heartCheck;
    }

    public static void setHeartCheck(boolean heartCheck) {
        TaskUtil.heartCheck = heartCheck;
    }

    public static boolean isPushDeviceSystem() {
        return pushDeviceSystem;
    }

    public static void setPushDeviceSystem(boolean pushDeviceSystem) {
        TaskUtil.pushDeviceSystem = pushDeviceSystem;
    }
}
