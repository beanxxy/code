package com.bgy.gateway.model.kafka;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzx
 * date 2020/03/20
 */
@Data
@NoArgsConstructor
public class SteamFastFoodSelfStockCharge {
    private int deviceId;
    private int type;
    private int row;
    private int num;
    private long time;
    private int messageId;
}
