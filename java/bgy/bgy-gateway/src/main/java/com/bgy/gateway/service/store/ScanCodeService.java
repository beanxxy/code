package com.bgy.gateway.service.store;

import com.bgy.gateway.model.message.Message;
import io.netty.channel.ChannelHandlerContext;

public interface ScanCodeService {

    void handleCodeRequest(ChannelHandlerContext ctx, Message msg);
    void handleActive(ChannelHandlerContext ctx);
    void handleInactive(ChannelHandlerContext ctx);
    void handleExceptionCaught(ChannelHandlerContext ctx, Throwable cause);


}
