package com.bgy.gateway.model.redis.belt;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author lzx
 * @date 2020/3/19.
 */
public class BeltStreamSelfFastFoodDeviceStatus extends RedisDeviceStatus {
    private List<Integer> errorList;

    public BeltStreamSelfFastFoodDeviceStatus() {
    }

    public BeltStreamSelfFastFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
        super(ctx, msg);
    }

    public List<Integer> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Integer> errorList) {
        this.errorList = errorList;
    }
}
