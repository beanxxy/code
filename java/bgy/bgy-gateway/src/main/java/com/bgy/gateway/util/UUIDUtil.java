package com.bgy.gateway.util;

import java.util.UUID;

/**
 * @author caijunwei
 * date 2020/7/10 17:53
 */
public class UUIDUtil {
    /**
     *32位默认长度的uuid
     * (获取32位uuid)
     *
     * @return
     */
    public static  String getUUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
