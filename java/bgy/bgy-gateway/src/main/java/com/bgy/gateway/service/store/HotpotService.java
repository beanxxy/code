package com.bgy.gateway.service.store;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.belt.BeltHotpotOutDto;
import com.bgy.gateway.model.dto.cold.ColdHotpotOutDto;
import com.bgy.gateway.model.dto.cut.CutHotpotOutDto;
import com.bgy.gateway.model.dto.drink.DrinkHotpotOutDto;
import com.bgy.gateway.model.dto.table.TableHotpotOutDto;
import com.bgy.gateway.model.dto.updish.UpdishHotpotOutDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.vo.ResultVo;
import io.netty.channel.ChannelHandlerContext;

public interface HotpotService {
    void handleColdRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendColdCommand(ColdHotpotOutDto coldHotpotOutDto)  throws BusinessException;

    void handleTableRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendTableCommand(TableHotpotOutDto tableHotpotOutDto) throws BusinessException;

    void handleBeltRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendBeltCommand(BeltHotpotOutDto beltHotpotOutDto) throws BusinessException;

    void handleUpdishRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendUpdishCommand(UpdishHotpotOutDto updishHotpotOutDto)throws BusinessException;

    void handleCutRequest(ChannelHandlerContext ctx, Message msg);

    void handleDrinkRequest(ChannelHandlerContext ctx, Message msg);

    ResultVo sendDrinkCommand(DrinkHotpotOutDto drinkHotpotOutDto) throws BusinessException;

    ResultVo sendCutCommand(CutHotpotOutDto cutHotpotOutDto) throws BusinessException;
}
