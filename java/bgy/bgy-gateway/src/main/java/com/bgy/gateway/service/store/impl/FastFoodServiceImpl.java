package com.bgy.gateway.service.store.impl;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.belt.BeltStreamFastFoodOutDto;
import com.bgy.gateway.model.dto.steam.SteamCageAssemblyDto;
import com.bgy.gateway.model.dto.steam.SteamDoorUpDownDto;
import com.bgy.gateway.model.dto.steam.SteamFastFoodOutDto;
import com.bgy.gateway.model.dto.taker.TakerOutDto;
import com.bgy.gateway.model.kafka.SteamFastFoodDischarge;
import com.bgy.gateway.model.kafka.SteamOutDishFastFoodDischarge;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.belt.BeltStreamFastFoodIn;
import com.bgy.gateway.model.message.belt.BeltStreamFastFoodOut;
import com.bgy.gateway.model.message.cold.ColdStreamFastFoodIn;
import com.bgy.gateway.model.message.steam.SteamCageAssemblyOut;
import com.bgy.gateway.model.message.steam.SteamDoorUpDownOut;
import com.bgy.gateway.model.message.steam.SteamFastFoodIn;
import com.bgy.gateway.model.message.steam.SteamFastFoodOut;
import com.bgy.gateway.model.message.taker.TakerOut;
import com.bgy.gateway.model.redis.belt.BeltRobotFastFoodDeviceStatus;
import com.bgy.gateway.model.redis.belt.BeltStreamFastFoodDeviceStatus;
import com.bgy.gateway.model.redis.cold.ColdStreamFastFoodDeviceStatus;
import com.bgy.gateway.model.redis.stream.SteamFastFoodDeviceStatus;
import com.bgy.gateway.model.redis.taker.TakerDeviceStatus;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.KafkaService;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.service.store.FastFoodService;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.CopyObjectUtil;
import com.bgy.gateway.util.SendMsgUtil;
import com.bgy.gateway.util.ServiceUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FastFoodServiceImpl implements FastFoodService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastFoodServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Autowired
    private KafkaService kafkaService;

    /**
     * 蒸箱设备上报处理
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void handleStreamRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<SteamFastFoodIn> message = msg;
            SteamFastFoodDischarge streamFastFoddDischarge;
            SteamOutDishFastFoodDischarge streamOutDishFastFoodDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    SteamFastFoodDeviceStatus deviceStatus = new SteamFastFoodDeviceStatus(ctx, message);
                    deviceStatus.setWarningInfo(message.getExtraData().getWarningInfo());
                    deviceStatus.setTotalLayer(message.getExtraData().getTotalLayer());
                    // 设备总状态
                    deviceStatus.setCookState(message.getExtraData().getCookState());
                    deviceStatus.setLayerDetails(message.getExtraData().getLayerDetails());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY + message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("蒸箱设备上报状态数据{}", msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg, message.getExtraData().getWarningInfo());
                    //LOGGER.info("蒸箱设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //蒸箱上报备料
                    streamFastFoddDischarge = new SteamFastFoodDischarge(message);
                    streamFastFoddDischarge.setDeviceId(message.getDeviceId());
                    streamFastFoddDischarge.setDishId(message.getExtraData().getDishId());
                    streamFastFoddDischarge.setMissionId(message.getExtraData().getMissionId());
                    streamFastFoddDischarge.setDoNum(message.getExtraData().getDoNum());
                    streamFastFoddDischarge.setMode(message.getExtraData().getMode());
                    // streamFastFoddDischarge.setOutNum(message.getExtraData().getOutNum());
                    streamFastFoddDischarge.setResult(message.getExtraData().getResult());
                    kafkaService.pushToInside(Constant.KAFKA_FAST_FOOD_STREAM_REPLENISH_DISH, streamFastFoddDischarge);
                    LOGGER.info("蒸箱设备上报备料 {}", streamFastFoddDischarge);
                    break;
                case 3:
                    //蒸箱上报出料
                    streamOutDishFastFoodDischarge = new SteamOutDishFastFoodDischarge(message);
                    streamOutDishFastFoodDischarge.setDeviceId(message.getDeviceId());
                    streamOutDishFastFoodDischarge.setDishId(message.getExtraData().getDishId());
                    streamOutDishFastFoodDischarge.setMissionId(message.getExtraData().getMissionId());
                    streamOutDishFastFoodDischarge.setLayer(message.getExtraData().getLayer());
                    streamOutDishFastFoodDischarge.setResult(message.getExtraData().getResult());
                    kafkaService.pushToInside(Constant.KAFKA_FAST_FOOD_STREAM_OUT_DISH, streamOutDishFastFoodDischarge);
                    LOGGER.info("蒸箱设备上报出料 {}", streamOutDishFastFoodDischarge);
                    break;
                case 4:
                    //蒸箱上报升降结果
                    streamOutDishFastFoodDischarge = new SteamOutDishFastFoodDischarge(message);
                    streamOutDishFastFoodDischarge.setDeviceId(message.getDeviceId());
                    streamOutDishFastFoodDischarge.setResult(message.getExtraData().getResult());
                    streamOutDishFastFoodDischarge.setMissionId(message.getExtraData().getMissionId());
                    kafkaService.pushToInside(Constant.KAFKA_FAST_FOOD_STREAM_UPDOWN_DISH, streamOutDishFastFoodDischarge);
                    LOGGER.info("一体化蒸箱设备升降结果 {}", streamOutDishFastFoodDischarge);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);

        } catch (Exception e) {
            LOGGER.error("快餐厅一体化蒸箱上报异常 {}",e);
        }


    }


    @Override
    public void handleClodStreamRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<ColdStreamFastFoodIn> message = msg;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    ColdStreamFastFoodDeviceStatus deviceStatus = new ColdStreamFastFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY + message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("蒸箱冷库设备上报状态数据 {}", msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg, message.getExtraData().getErrorList());
                    //LOGGER.info("蒸箱冷库设备上报到设备管理系统：[{}]", message);
                    break;
                default:
                    break;
            }
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        } catch (Exception e) {
            LOGGER.info("快餐厅一体化蒸箱上报异常 {}", e);
        }

    }

    @Override
    public void handleBeltStreamRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<BeltStreamFastFoodIn> message = msg;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    BeltStreamFastFoodDeviceStatus deviceStatus = new BeltStreamFastFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setOrderType(message.getExtraData().getOrderType());
                    deviceStatus.setPlateId(message.getExtraData().getPlateId());
                    deviceStatus.setTakerId(message.getExtraData().getTakerId());
                    deviceStatus.setTakerState(message.getExtraData().getTakerState());
                    TakerDeviceStatus takerDeviceStatus = new TakerDeviceStatus();
                    takerDeviceStatus.setDeviceId(msg.getDeviceId());
                    takerDeviceStatus.setOrderType(message.getExtraData().getOrderType());
                    takerDeviceStatus.setPlateId(message.getExtraData().getPlateId());
                    takerDeviceStatus.setTakerState(message.getExtraData().getTakerState());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY + message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    redisService.pushHash(Constant.REDIS_DEVICE_TAKER_KEY + msg.getDeviceId(), Integer.toString(message.getExtraData().getTakerId()), takerDeviceStatus);
                    LOGGER.info("蒸箱物流线上报设备状态 {}", msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("蒸箱物流线设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:

                    break;
                case 3:
                    //上报机器手的状态
                    BeltRobotFastFoodDeviceStatus beltRobotFastFoodDeviceStatus = new BeltRobotFastFoodDeviceStatus(ctx, message);
                    beltRobotFastFoodDeviceStatus.setDeviceId(msg.getDeviceId());
                    beltRobotFastFoodDeviceStatus.setTakerId(message.getExtraData().getTakerId());
                    beltRobotFastFoodDeviceStatus.setRobotId(message.getExtraData().getRobotId());
                    beltRobotFastFoodDeviceStatus.setActionType(message.getExtraData().getActionType());
                    beltRobotFastFoodDeviceStatus.setPlatePosition(message.getExtraData().getPlatePosition());
                    beltRobotFastFoodDeviceStatus.setTakePosition(message.getExtraData().getTakePosition());
                    redisService.pushHash(Constant.REDIS_DEVICE_ROBOT_KEY + msg.getDeviceId(), Integer.toString(message.getExtraData().getRobotId()), beltRobotFastFoodDeviceStatus);
                    LOGGER.info("蒸箱物流线机械手设备上报状态 {}", beltRobotFastFoodDeviceStatus);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);

        } catch (Exception e) {
            LOGGER.info("快餐厅蒸箱上报异常 {}", e);
        }
    }


    @Override
    public ResultVo sendStreamCommand(SteamFastFoodOutDto streamFastFoodOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(streamFastFoodOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(streamFastFoodOutDto.getDeviceId(), channel, redisService);
        SteamFastFoodOut streamFastFoodOut = new SteamFastFoodOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(streamFastFoodOutDto, streamFastFoodOut);
        Message<SteamFastFoodOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(streamFastFoodOutDto.getDeviceId(), loginMessage, message, redisService);
        message.setExtraData(streamFastFoodOut);
        if (streamFastFoodOutDto.getCommand() == CommandType.TWO.getStatus() || streamFastFoodOutDto.getCommand() == CommandType.SIX.getStatus()) {
            return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
        }
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);

    }


    @Override
    public ResultVo sendStreamCommand(SteamCageAssemblyDto steamCageAssemblyDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(steamCageAssemblyDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(steamCageAssemblyDto.getDeviceId(), channel, redisService);
        SteamCageAssemblyOut steamCageAssemblyOut = new SteamCageAssemblyOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(steamCageAssemblyDto, steamCageAssemblyOut);
        Message<SteamCageAssemblyOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(steamCageAssemblyDto.getDeviceId(), loginMessage, message, redisService);
        message.setExtraData(steamCageAssemblyOut);
        if (steamCageAssemblyDto.getCommand() == CommandType.FOUR.getStatus()) {
            return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
        }
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }

    @Override
    public ResultVo sendStreamCommand(SteamDoorUpDownDto steamDoorUpDownDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(steamDoorUpDownDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(steamDoorUpDownDto.getDeviceId(), channel, redisService);
        SteamDoorUpDownOut steamCageAssemblyOut = new SteamDoorUpDownOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(steamDoorUpDownDto, steamCageAssemblyOut);
        Message<SteamDoorUpDownOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(steamDoorUpDownDto.getDeviceId(), loginMessage, message, redisService);
        message.setExtraData(steamCageAssemblyOut);
        if (steamDoorUpDownDto.getCommand() == CommandType.SIX.getStatus()) {
            return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
        }
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }

    @Override
    public ResultVo sendStreamCommand(TakerOutDto takerOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(takerOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(takerOutDto.getDeviceId(), channel, redisService);
        TakerOut takerOut = new TakerOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(takerOutDto, takerOut);
        Message<TakerOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(takerOutDto.getDeviceId(), loginMessage, message, redisService);
        message.setExtraData(takerOut);
        if (takerOutDto.getCommand() == CommandType.THREE.getStatus()) {
            return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
        }
        return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
    }

    @Override
    public ResultVo sendStreamCommand(BeltStreamFastFoodOutDto beltStreamFastFoodOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(beltStreamFastFoodOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(beltStreamFastFoodOutDto.getDeviceId(), channel, redisService);
        BeltStreamFastFoodOut beltStreamFastFoodOut = new BeltStreamFastFoodOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(beltStreamFastFoodOutDto, beltStreamFastFoodOut);
        Message<BeltStreamFastFoodOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(beltStreamFastFoodOutDto.getDeviceId(), loginMessage, message, redisService);
        message.setExtraData(beltStreamFastFoodOut);
        if (beltStreamFastFoodOutDto.getCommand() == CommandType.TWO.getStatus()) {
            return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
        }
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }
}


