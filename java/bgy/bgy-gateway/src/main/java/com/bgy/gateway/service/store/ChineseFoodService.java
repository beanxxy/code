package com.bgy.gateway.service.store;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.down.DownChineseFoodCheckDto;
import com.bgy.gateway.model.dto.down.DownChineseFoodOutDto;
import com.bgy.gateway.model.dto.steam.SteamChineseFoodOutDto;
import com.bgy.gateway.model.dto.updish.UpdishChineseFoodOutDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.vo.ResultVo;
import io.netty.channel.ChannelHandlerContext;

public interface ChineseFoodService {

    void handleUpdishRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendUpdishCommand(UpdishChineseFoodOutDto updishChineseFoodOutDto) throws BusinessException;

    void handleCookRequest(ChannelHandlerContext ctx, Message msg);

    void handleColdRequest(ChannelHandlerContext ctx, Message msg);

    void handleSteamRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendSteamCommand(SteamChineseFoodOutDto steamChineseFoodOutDto) throws BusinessException;

    void handleDownRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendDownCommand(DownChineseFoodOutDto downChineseFoodOutDto)throws BusinessException;

    void handleClaypotRequest(ChannelHandlerContext ctx, Message msg) throws BusinessException;

	ResultVo sendDownCheckCommand(DownChineseFoodCheckDto downChineseFoodCheckDto) throws BusinessException;
}
