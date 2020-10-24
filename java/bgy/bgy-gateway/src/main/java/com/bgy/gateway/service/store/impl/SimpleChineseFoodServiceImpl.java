package com.bgy.gateway.service.store.impl;

import com.bgy.gateway.enums.MessageType;
import com.bgy.gateway.model.dto.cold.ColdSimpleChineseFoodOutDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.cold.ColdSimpleChineseFoodIn;
import com.bgy.gateway.model.message.cold.ColdSimpleChineseFoodOut;
import com.bgy.gateway.model.message.cook.CookSimpleChineseFoodIn;
import com.bgy.gateway.model.message.cook.CookSimpleChineseFoodOut;
import com.bgy.gateway.model.redis.cold.ColdSimpleChineseFoodDeviceStatus;
import com.bgy.gateway.model.kafka.ColdSimpleChineseFoodDischarge;
import com.bgy.gateway.model.redis.cook.CookSimpleChineseFoodDeviceStatus;
import com.bgy.gateway.model.vo.ResultEnum;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.KafkaService;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.service.store.SimpleChineseFoodService;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.ServiceUtil;
import com.bgy.gateway.exception.BusinessException;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleChineseFoodServiceImpl implements SimpleChineseFoodService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleChineseFoodServiceImpl.class);

    @Value("${gateway.file-full-name}")
    private String fileFullName;

    @Autowired
    private RedisService redisService;
    @Autowired
    private KafkaService kafkaService;

    @Override
    public void handleCookRequest(ChannelHandlerContext ctx, Message msg) {
        LOGGER.info("炒锅业务上报：{}", msg);
        Message<CookSimpleChineseFoodIn> message = msg;

        switch (message.getExtraData().getRequest()) {
            // 信息上报
            case 1:
                // 上报设备状态到设备管理系统
                //kafkaService.pushToDeviceSystem(msg);
                break;
            // 制作完成信息标志（统计）
            case 2:
                break;
            // 获取烹饪参数
            case 3:
                String cookFileFullName = String.format(fileFullName, message.getExtraData().getProductId());
                byte[] cookParam = ServiceUtil.getFileBytes(cookFileFullName);

                CookSimpleChineseFoodOut cookSimpleChineseFoodOut = new CookSimpleChineseFoodOut();
                cookSimpleChineseFoodOut.setCookParam(cookParam);

                Message<CookSimpleChineseFoodOut> responseMessage = new Message<>();
                responseMessage.setHeader(msg.getHeader());
                responseMessage.setMessageType(MessageType.RESPONSE);
                responseMessage.setUniqueKey(msg.getUniqueKey());
                responseMessage.setDeviceType(msg.getDeviceType());
                responseMessage.setDeviceId(msg.getDeviceId());
                responseMessage.setExtraData(cookSimpleChineseFoodOut);
                ctx.writeAndFlush(responseMessage);
                break;
            // 获取菜品图片（预留）
            case 4:
                break;
            // 获取菜品名称（预留）
            case 5:
                break;
            // 获取服务器时间
            case 6:
                break;
            default:
                break;
        }


        switch (message.getExtraData().getRequest()) {
            // 获取烹饪参数
            case 3:
                // 已经在上面代码回复请求
                break;
            default:
                ServiceUtil.sendRequestCommonReply(ctx, msg);
                break;
        }

        // 更新设备状态
        CookSimpleChineseFoodDeviceStatus deviceStatus = new CookSimpleChineseFoodDeviceStatus(ctx, message);
        deviceStatus.setProductId(message.getExtraData().getProductId());
        redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY, Integer.toString(msg.getDeviceId()), deviceStatus);
    }

    @Override
    public void handleColdRequest(ChannelHandlerContext ctx, Message msg) {
        LOGGER.info("冷库业务上报：{}", msg);
        Message<ColdSimpleChineseFoodIn> message = msg;
        ColdSimpleChineseFoodDischarge cold = new ColdSimpleChineseFoodDischarge(message);

        switch (message.getExtraData().getDischargeStatus()) {
            // 无出料
            case 0:
                break;
            // 出料成功
            case 1:
            // 出料失败
            case 2:
                // 出料成功与出料失败放在同一个 topic
                kafkaService.pushToInside(Constant.KAFKA_DISCHARGE_TOPIC, cold);
                LOGGER.info("出料状态上报：{}", msg);
                break;
            default:
                break;
        }

        switch (message.getExtraData().getMissionStatus()) {
            // 任务完成
            case 3:
            // 取餐成功
            case 4:
            // 烹饪失败
            case 5:
                // 任务完成、取餐成功、烹饪失败放在同一个 topic
                kafkaService.pushToInside(Constant.KAFKA_MISSION_TOPIC, cold);
                break;
            default:
                break;
        }

        switch (message.getExtraData().getRequest()) {
            // 信息上报
            case 1:
                // 上报设备状态到设备管理系统
               // kafkaService.pushToDeviceSystem(msg);
                break;
            default:
                break;
        }

        ServiceUtil.sendRequestCommonReply(ctx, msg);

        // 更新设备状态
        ColdSimpleChineseFoodDeviceStatus deviceStatus = new ColdSimpleChineseFoodDeviceStatus(ctx, message);
        deviceStatus.setMissionStatus(message.getExtraData().getMissionStatus());
        deviceStatus.setMissionId(message.getExtraData().getMissionId());
        deviceStatus.setProductId(message.getExtraData().getProductId());
        deviceStatus.setRow(message.getExtraData().getRow());
        deviceStatus.setColumn(message.getExtraData().getColumn());
        deviceStatus.setDischargeStatus(message.getExtraData().getDischargeStatus());
        redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY, Integer.toString(msg.getDeviceId()), deviceStatus);
    }

    @Override
    public ResultVo sendColdCommand(ColdSimpleChineseFoodOutDto coldSimpleChineseFoodOutDto) throws BusinessException {

        Channel channel = ChannelSupervise.getChannel(coldSimpleChineseFoodOutDto.getDeviceId());
        if(channel == null) {
            throw new BusinessException(ResultEnum.DEVICE_HAD_DISCONNECT);
        }
        Message loginMessage = ChannelSupervise.getLoginMessage(channel);
        if(loginMessage == null) {
            throw new BusinessException(ResultEnum.DEVICE_NOT_EXIST);
        }

        ColdSimpleChineseFoodOut coldSimpleChineseFoodOut = new ColdSimpleChineseFoodOut();
        BeanUtils.copyProperties(coldSimpleChineseFoodOutDto, coldSimpleChineseFoodOut);
        coldSimpleChineseFoodOut.setBoxNum(coldSimpleChineseFoodOutDto.getBoxList().size());
        Message<ColdSimpleChineseFoodOut> message = new Message<>();
        message.setHeader(loginMessage.getHeader());
        message.setMessageType(MessageType.REQUEST);
        message.setUniqueKey(redisService.nextUniqueKey());
        message.setDeviceType(loginMessage.getDeviceType());
        message.setDeviceId(coldSimpleChineseFoodOutDto.getDeviceId());
        message.setExtraData(coldSimpleChineseFoodOut);

        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }

}