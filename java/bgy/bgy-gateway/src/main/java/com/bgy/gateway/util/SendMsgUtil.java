package com.bgy.gateway.util;

import com.bgy.gateway.enums.MessageType;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.vo.ResultEnum;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.service.store.impl.ChineseFoodServiceImpl;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author caijunwei
 * date 2020/3/18 16:09
 */

public class SendMsgUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMsgUtil.class);

    public static Message judgeOnline(Integer deviceId, Channel channel,RedisService redisService) throws BusinessException {
        if (channel == null) {
            LOGGER.info("设备掉线数据 设备ID {}", deviceId);
            throw new BusinessException(ResultEnum.DEVICE_HAD_DISCONNECT);
        }

        Message loginMessage = redisService.getDeviceType(deviceId);
        if (loginMessage == null) {
            throw new BusinessException(ResultEnum.DEVICE_NOT_EXIST);
        }
        return loginMessage;
    }

    public static void sendMessageBody(Integer deviceId, Message loginMessage, Message message,RedisService redisService) {
        message.setHeader(loginMessage.getHeader());
        message.setMessageType(MessageType.REQUEST);
        message.setUniqueKey(redisService.nextUniqueKey());
        message.setDeviceType(loginMessage.getDeviceType());
        message.setDeviceId(deviceId);
    }
}
