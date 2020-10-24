package com.bgy.gateway.service.store;

import com.bgy.gateway.model.message.Message;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author lzx
 * @date 2020/3/19.
 */
public interface FastFoodSelfService {
    /**
     * 处理自助式主控设备上报信息
     *
     * @param ctx
     * @param msg
     */
    void handleBeltSelfStreamRequest(ChannelHandlerContext ctx, Message msg);

    /**
     * 处理自助式水保温柜设备上报信息
     *
     * @param ctx
     * @param msg
     */
    void handleBeltSelfWaterStreamRequest(ChannelHandlerContext ctx, Message msg);
}
