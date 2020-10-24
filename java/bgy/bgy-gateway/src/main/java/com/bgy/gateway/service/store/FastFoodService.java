package com.bgy.gateway.service.store;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.belt.BeltStreamFastFoodOutDto;
import com.bgy.gateway.model.dto.steam.SteamCageAssemblyDto;
import com.bgy.gateway.model.dto.steam.SteamDoorUpDownDto;
import com.bgy.gateway.model.dto.steam.SteamFastFoodOutDto;
import com.bgy.gateway.model.dto.taker.TakerOutDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.vo.ResultVo;
import io.netty.channel.ChannelHandlerContext;

public interface FastFoodService {

    void handleStreamRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendStreamCommand(SteamFastFoodOutDto streamFastFoodOutDto) throws BusinessException;

    void handleClodStreamRequest(ChannelHandlerContext ctx, Message msg);

    void handleBeltStreamRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendStreamCommand(TakerOutDto takerOutDto) throws BusinessException;

    ResultVo sendStreamCommand(BeltStreamFastFoodOutDto beltStreamFastFoodOutDto) throws BusinessException;

    /**
     * 发送蒸箱升降指令
     *
     * @param steamCageAssemblyDto
     * @return
     */
    ResultVo sendStreamCommand(SteamCageAssemblyDto steamCageAssemblyDto) throws BusinessException;

    /**
     * 发送开关门指令
     * @param steamDoorUpDownDto
     * @return
     */
    ResultVo sendStreamCommand(SteamDoorUpDownDto steamDoorUpDownDto) throws BusinessException;
}
