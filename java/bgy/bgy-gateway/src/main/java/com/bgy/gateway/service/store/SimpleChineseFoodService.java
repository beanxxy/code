package com.bgy.gateway.service.store;

import com.bgy.gateway.model.dto.cold.ColdSimpleChineseFoodOutDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.exception.BusinessException;
import io.netty.channel.ChannelHandlerContext;

public interface SimpleChineseFoodService {
    void handleCookRequest(ChannelHandlerContext ctx, Message msg);
    void handleColdRequest(ChannelHandlerContext ctx, Message msg);
    ResultVo sendColdCommand(ColdSimpleChineseFoodOutDto coldSimpleChineseFoodOutDto) throws BusinessException;
}
