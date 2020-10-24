package com.bgy.gateway.service;

import com.bgy.gateway.model.message.Message;
import io.netty.channel.ChannelHandlerContext;

public interface MessageService {
    void messageCommonAction(ChannelHandlerContext ctx, Message msg);
    void handleHeartbeat(ChannelHandlerContext ctx, Message msg);
    void handleRequest(ChannelHandlerContext ctx, Message msg);
    void handleResponse(ChannelHandlerContext ctx, Message msg);
    void handleHeartbeatResponse(ChannelHandlerContext ctx, Message msg);
    void handleResultResponse(ChannelHandlerContext ctx, Message msg);
    void handleLogin(ChannelHandlerContext ctx, Message msg);
    void handleLoginResponse(ChannelHandlerContext ctx, Message msg);
    void handleActive(ChannelHandlerContext ctx);
    void handleInactive(ChannelHandlerContext ctx);
    void handleExceptionCaught(ChannelHandlerContext ctx, Throwable cause);

    String getChannelIpPort(ChannelHandlerContext ctx);

    int getLocalPort(ChannelHandlerContext ctx);
}
