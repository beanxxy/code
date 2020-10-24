package com.bgy.gateway.service.store.impl;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.service.store.ScanCodeService;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Service;

/**
 * @author caijunwei
 * date 2020/1/19 21:43
 */
@Service
public class ScanCodeServiceImpl implements ScanCodeService {
    @Override
    public void handleCodeRequest(ChannelHandlerContext ctx, Message msg) {

    }

    @Override
    public void handleActive(ChannelHandlerContext ctx) {

    }

    @Override
    public void handleInactive(ChannelHandlerContext ctx) {

    }

    @Override
    public void handleExceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

    }

}
