package com.bgy.gateway.service.store.impl;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.steam.SteamSelfFastFoodOutDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.belt.BeltStreamFastFoodSelfOut;
import com.bgy.gateway.model.vo.ResultEnum;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.service.store.FastFoodSteamSlefService;
import com.bgy.gateway.util.CopyObjectUtil;
import com.bgy.gateway.util.SendMsgUtil;
import com.bgy.gateway.util.ServiceUtil;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzx
 * @date 2020/3/19.
 */
@Service
@Slf4j
@SuppressWarnings("all")
public class FastFoodSteamSlefServiceImpl implements FastFoodSteamSlefService {
    @Autowired
    RedisService redisService;

    @Override
    public ResultVo sendSteamSelfFastFoodOut(SteamSelfFastFoodOutDto steamSelfFastFoodOutDto) {
        Channel channel = ChannelSupervise.getChannel(steamSelfFastFoodOutDto.getDeviceId());
        Message loginMessage = null;
        try {
            loginMessage = SendMsgUtil.judgeOnline(steamSelfFastFoodOutDto.getDeviceId(), channel, redisService);
        } catch (BusinessException e) {
            log.error("快餐自助式蒸箱下发出料命令异常,设备掉线或未登录：{}", e);
            return ResultVo.error(ResultEnum.DEVICE_NOT_EXIST);
        }
        BeltStreamFastFoodSelfOut beltStreamFastFoodSelfOut = new BeltStreamFastFoodSelfOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(steamSelfFastFoodOutDto, beltStreamFastFoodSelfOut);
        Message<BeltStreamFastFoodSelfOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(steamSelfFastFoodOutDto.getDeviceId(), loginMessage, message, redisService);
        message.setExtraData(beltStreamFastFoodSelfOut);
        if (steamSelfFastFoodOutDto.getCommand() == CommandType.TWO.getStatus()) {
            return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
        }
        try {
            return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
        } catch (BusinessException e) {
            log.error("快餐自助式蒸箱下发出料命令异常：{}", e);
            return ResultVo.error(ResultEnum.OTHER_ERROR);
        }
    }
}
