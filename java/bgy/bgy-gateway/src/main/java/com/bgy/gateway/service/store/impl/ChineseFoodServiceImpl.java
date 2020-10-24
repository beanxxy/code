package com.bgy.gateway.service.store.impl;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.enums.MessageType;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.down.DownChineseFoodCheckDto;
import com.bgy.gateway.model.dto.down.DownChineseFoodOutDto;
import com.bgy.gateway.model.dto.steam.SteamChineseFoodOutDto;
import com.bgy.gateway.model.dto.updish.UpdishChineseFoodOutDto;
import com.bgy.gateway.model.kafka.ColdChineseFoodDischarge;
import com.bgy.gateway.model.kafka.DownChineseFoodDischarge;
import com.bgy.gateway.model.kafka.SteamOutDishChineseFoodDischarge;
import com.bgy.gateway.model.kafka.UpdishChineseFoodDischarge;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.claypot.ClaypotChineseFoodIn;
import com.bgy.gateway.model.message.cold.ColdChineseFoodIn;
import com.bgy.gateway.model.message.cook.CookChineseFoodIn;
import com.bgy.gateway.model.message.cook.CookChineseFoodOut;
import com.bgy.gateway.model.message.down.DownChineseFoodIn;
import com.bgy.gateway.model.message.down.DownChineseFoodOut;
import com.bgy.gateway.model.message.steam.SteamChineseFoodIn;
import com.bgy.gateway.model.message.steam.SteamChineseFoodOut;
import com.bgy.gateway.model.message.updish.UpdishChineseFoodIn;
import com.bgy.gateway.model.message.updish.UpdishChineseFoodOut;
import com.bgy.gateway.model.redis.claypot.ClaypotChineseFoodDeviceStatus;
import com.bgy.gateway.model.redis.cold.ColdChineseFoodDeviceStatus;
import com.bgy.gateway.model.redis.cook.CookChineseFoodDeviceStatus;
import com.bgy.gateway.model.redis.down.DownChineseFoodDeviceStatus;
import com.bgy.gateway.model.redis.stream.SteamChineseFoodDeviceStatus;
import com.bgy.gateway.model.redis.updish.UpdishChineseFoodDeviceStatus;
import com.bgy.gateway.model.vo.ResultEnum;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.KafkaService;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.service.store.ChineseFoodService;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.CopyObjectUtil;
import com.bgy.gateway.util.NettyUtil;
import com.bgy.gateway.util.SendMsgUtil;
import com.bgy.gateway.util.ServiceUtil;
import com.bgy.gateway.util.Udp;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChineseFoodServiceImpl implements ChineseFoodService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChineseFoodServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Autowired
    private KafkaService kafkaService;

    @Value("${gateway.file-full-name}")
    private String fileFullName;

    /**
     * 上菜口设备上报处理
     * @param ctx
     * @param msg
     */
    @Override
    public void handleUpdishRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<UpdishChineseFoodIn> message = msg;
            UpdishChineseFoodDischarge updishChineseFoodDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    UpdishChineseFoodDeviceStatus deviceStatus = new UpdishChineseFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setEnable(message.getExtraData().getEnable());
                    deviceStatus.setDishId(message.getExtraData().getDishId());
                    deviceStatus.setMechanism(message.getExtraData().getMechanism());
                    deviceStatus.setRunState(message.getExtraData().getRunState());
                    deviceStatus.setMissionId(message.getExtraData().getMissionId());
                    deviceStatus.setSign(message.getExtraData().getSign());
                    deviceStatus.setPushState(message.getExtraData().getPushState());
                    deviceStatus.setEmpty(message.getExtraData().getEmpty());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("上菜设备上报状态 {}",deviceStatus);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("上菜设备上报到设备管理系统：[{}]", message);
                    if(message.getExtraData().getSign() == CommandType.ONE.getStatus()){
                        updishChineseFoodDischarge = new UpdishChineseFoodDischarge(message);
                        updishChineseFoodDischarge.setDeviceId(message.getDeviceId());
                        updishChineseFoodDischarge.setMissionId(message.getExtraData().getMissionId());
                        updishChineseFoodDischarge.setDishId(message.getExtraData().getDishId());
                        kafkaService.pushToInside(Constant.KAFKA_CHINESE_FOOD_UP_TOPIC,updishChineseFoodDischarge);
                        LOGGER.info("上菜设备上报菜品完成状态 {}",updishChineseFoodDischarge);
                    }
                    if(message.getExtraData().getExceptionStatus().getStatus() ==CommandType.THREE.getStatus() ||
                            message.getExtraData().getExceptionStatus().getStatus() ==CommandType.SEVEN.getStatus() ||
                            message.getExtraData().getExceptionStatus().getStatus() ==CommandType.EIGHT.getStatus()){
                        updishChineseFoodDischarge = new UpdishChineseFoodDischarge(message);
                        updishChineseFoodDischarge.setDeviceId(message.getDeviceId());
                        updishChineseFoodDischarge.setError(message.getExtraData().getExceptionStatus().getStatus());
                        updishChineseFoodDischarge.setMissionId(message.getExtraData().getMissionId());
                        updishChineseFoodDischarge.setDishId(message.getExtraData().getDishId());
                        kafkaService.pushToInside(Constant.KAFKA_CHINESE_FOOD_UP_TOPIC,updishChineseFoodDischarge);
                        LOGGER.info("上菜设备上报事件异常状态 {}",updishChineseFoodDischarge);
                    }
                    break;
                default:
                    break;
            }
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        }catch (Exception e){
            LOGGER.error("中餐厅上菜口设备上报异常 {}",e);
        }


    }

    @Override
    public ResultVo sendUpdishCommand(UpdishChineseFoodOutDto updishChineseFoodOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(updishChineseFoodOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(updishChineseFoodOutDto.getDeviceId(), channel,redisService);
        UpdishChineseFoodOut updishChineseFoodOut = new UpdishChineseFoodOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(updishChineseFoodOutDto, updishChineseFoodOut);
        Message<UpdishChineseFoodOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(updishChineseFoodOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(updishChineseFoodOut);
        if(updishChineseFoodOutDto.getCommand()==CommandType.SEVEN.getStatus()){
            return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
        }
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);

    }

    @Override
    public void handleCookRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<CookChineseFoodIn> message = msg;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    CookChineseFoodDeviceStatus deviceStatus = new CookChineseFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setEnable(message.getExtraData().getEnable());
                    deviceStatus.setDishId(message.getExtraData().getDishId());
                    deviceStatus.setUpId(message.getExtraData().getUpId());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("炒锅设备上报状态 {}",msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("炒锅设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    try {
                        LOGGER.info("炒锅请求的菜品Id {}",  message.getExtraData().getDishId());
                        String cookFileFullName = String.format(fileFullName, message.getExtraData().getDishId());
                        byte[] cookParam = ServiceUtil.getFileBytes(cookFileFullName);
                        CookChineseFoodOut cookChineseFoodOut = new CookChineseFoodOut();
                        cookChineseFoodOut.setCookParam(cookParam);
                        Message<CookChineseFoodOut> responseMessage = new Message<>();
                        responseMessage.setHeader(msg.getHeader());
                        responseMessage.setMessageType(MessageType.RESPONSE);
                        responseMessage.setUniqueKey(msg.getUniqueKey());
                        responseMessage.setDeviceType(msg.getDeviceType());
                        responseMessage.setDeviceId(msg.getDeviceId());
                        responseMessage.setExtraData(cookChineseFoodOut);
                        ctx.writeAndFlush(responseMessage);
                        break;
                    }catch (Exception e){
                        LOGGER.error("中餐厅炒锅请求的菜品异常 {}", e.getStackTrace());
                    }

                default:
                    break;
            }
            switch (message.getExtraData().getRequest()) {
                // 获取烹饪参数
                case 2:
                    // 已经在上面代码回复请求
                    break;
                default:
                    ServiceUtil.sendRequestCommonReply(ctx, msg);
                    break;
            }
        }catch (Exception e){
            LOGGER.error("中餐厅炒锅上报异常 {}",e);
        }

    }

    @Override
    public void handleColdRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<ColdChineseFoodIn> message = msg;
            ColdChineseFoodDischarge coldChineseFoodDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    ColdChineseFoodDeviceStatus deviceStatus = new ColdChineseFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setEnable(message.getExtraData().getEnable());
                    deviceStatus.setCookId(message.getExtraData().getCookId());
                    deviceStatus.setCookType(message.getExtraData().getCookType());
                    deviceStatus.setSign(message.getExtraData().getSign());
                    deviceStatus.setFloor(message.getExtraData().getLayer());
                    deviceStatus.setDishId(message.getExtraData().getDishId());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("冷库设备上报状态 {}",msg);
                    //冷库出料上报
                    coldChineseFoodDischarge = new ColdChineseFoodDischarge(message);
                    if(message.getExtraData().getSign()== CommandType.ONE.getStatus()){
                        coldChineseFoodDischarge.setDeviceId(message.getDeviceId());
                        coldChineseFoodDischarge.setCookId(message.getDeviceId());
                        coldChineseFoodDischarge.setCookType(message.getExtraData().getCookType());
                        coldChineseFoodDischarge.setDishId(message.getExtraData().getDishId());
                        coldChineseFoodDischarge.setLayer(message.getExtraData().getLayer());
                        kafkaService.pushToInside(Constant.KAFKA_CHINESE_FOOD_COLD_TOPIC,coldChineseFoodDischarge);
                        LOGGER.info("中餐冷库设备上报出料 {}",coldChineseFoodDischarge);
                    }
                    // 上报设备状态到设备管理系统
                   // kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("冷库设备上报到设备管理系统：[{}]", message);
                    break;
                default:
                    break;
            }
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        }catch (Exception e){
            LOGGER.error("中餐厅冷库设备上报异常 {}",e);
        }

    }

    @Override
    public void handleSteamRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<SteamChineseFoodIn> message = msg;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    SteamChineseFoodDeviceStatus deviceStatus = new SteamChineseFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setEnable(message.getExtraData().getEnable());
                    deviceStatus.setTotalLayer(message.getExtraData().getTotalLayer());
                    deviceStatus.setLayerDetails(message.getExtraData().getLayerDetails());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("蒸箱备上报状态 {}",msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("蒸箱设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //蒸箱上报出料
                    SteamOutDishChineseFoodDischarge streamOutDishChineseFoodDischarge = new SteamOutDishChineseFoodDischarge(message);
                    streamOutDishChineseFoodDischarge.setDeviceId(message.getDeviceId());
                    streamOutDishChineseFoodDischarge.setDishId(message.getExtraData().getDishId());
                    streamOutDishChineseFoodDischarge.setLayer(message.getExtraData().getLayer());
                    streamOutDishChineseFoodDischarge.setResult(message.getExtraData().getResult());
                    streamOutDishChineseFoodDischarge.setMissionId(message.getExtraData().getMissionId());
                    kafkaService.pushToInside(Constant.KAFKA_CHINESE_FOOD_STEAM_TOPIC,streamOutDishChineseFoodDischarge);
                    LOGGER.info("中餐蒸箱设备上报出料 {}",streamOutDishChineseFoodDischarge);
                    break;
                default:
                    break;
            }
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        }catch (Exception e){
            LOGGER.info("中餐厅蒸箱设备上报异常 {}", e);
        }
    }

    @Override
    public ResultVo sendSteamCommand(SteamChineseFoodOutDto steamChineseFoodOutDto) throws  BusinessException{
        Channel channel = ChannelSupervise.getChannel(steamChineseFoodOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(steamChineseFoodOutDto.getDeviceId(), channel,redisService);
        SteamChineseFoodOut steamChineseFoodOut = new SteamChineseFoodOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(steamChineseFoodOutDto, steamChineseFoodOut);
        Message<SteamChineseFoodOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(steamChineseFoodOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(steamChineseFoodOut);
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);

    }


    @Override
    public void handleDownRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<DownChineseFoodIn> message = msg;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    DownChineseFoodDeviceStatus deviceStatus = new DownChineseFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setEnable(message.getExtraData().getEnable());
                    deviceStatus.setPushState(message.getExtraData().getPushState());
                    deviceStatus.setRunState(message.getExtraData().getRunState());
                    deviceStatus.setMissionId(message.getExtraData().getMissionId());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("下菜口上报状态 {}",msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("下菜口设备上报到设备管理系统：[{}]", message);
                    if(deviceStatus.getRunState()==CommandType.TWO.getStatus() || deviceStatus.getRunState()==CommandType.THREE.getStatus() ||
                            deviceStatus.getRunState()==CommandType.FOUR.getStatus() ||deviceStatus.getRunState()==CommandType.FIVE.getStatus()
                    ){
                        DownChineseFoodDischarge downChineseFoodDischarge = new DownChineseFoodDischarge(message);
                        downChineseFoodDischarge.setDeviceId(message.getDeviceId());
                        downChineseFoodDischarge.setMissionId(message.getExtraData().getMissionId());
                        downChineseFoodDischarge.setRunState(message.getExtraData().getRunState());
                        downChineseFoodDischarge.setCt(System.currentTimeMillis());
                        kafkaService.pushToInside(Constant.KAFKA_CHINESE_FOOD_DOWN_TOPIC,downChineseFoodDischarge);
                        //LOGGER.info("下菜口上报下降动作状态 {}",downChineseFoodDischarge);
                    }
                    break;
                default:
                    break;
            }
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        }catch (Exception e){
            LOGGER.error("中餐厅下菜口设备上报异常 {}",e);
        }
    }

    @Override
    public ResultVo sendDownCommand(DownChineseFoodOutDto downChineseFoodOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(downChineseFoodOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(downChineseFoodOutDto.getDeviceId(), channel,redisService);
        DownChineseFoodOut downChineseFoodOut = new DownChineseFoodOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(downChineseFoodOutDto, downChineseFoodOut);
        Message<DownChineseFoodOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(downChineseFoodOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(downChineseFoodOut);
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }
    
    @Override
    public ResultVo sendDownCheckCommand(DownChineseFoodCheckDto downChineseFoodCheckDto) throws BusinessException {
    	if(downChineseFoodCheckDto.getDeviceId().equals("")||downChineseFoodCheckDto.getDeviceId().equals("0")) {
    		List<String> ips = Udp.getLocalIPList();
    		for(String ip : ips) {
    			Map<String,byte[]> map = Udp.sendAll(ip, 50000, "a00c","",50);
    		}
    	}else {
    		Channel channel = ChannelSupervise.getChannel(downChineseFoodCheckDto.getDeviceId());
            String ip = NettyUtil.parseChannelRemoteAddr(channel);//channel.remoteAddress();
            ip = ip.split(":")[0];  
            byte[] bt = Udp.send(ip, 50000, "a00c","");
            if(bt==null) {
            	ResultVo.error(ResultEnum.CALL_NETTY_FAIL.getCode(),ResultEnum.CALL_NETTY_FAIL.getMessage());
            } 
    	}
        
        return ResultVo.success("发送成功!");//ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }

    @Override
    public void handleClaypotRequest(ChannelHandlerContext ctx, Message msg) throws BusinessException {
        try {
            Message<ClaypotChineseFoodIn> message = msg;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    ClaypotChineseFoodDeviceStatus deviceStatus = new ClaypotChineseFoodDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setEnable(message.getExtraData().getEnable());
                    deviceStatus.setTotalLayer(message.getExtraData().getTotalLayer());
                    deviceStatus.setUpId(message.getExtraData().getUpId());
                    deviceStatus.setLayerDetails(message.getExtraData().getLayerDetails());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("煲仔饭上报状态 {}",msg);
                    // 上报设备状态到设备管理系统
                   // kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    break;
                default:
                    break;
            }
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        }catch (Exception e){
            LOGGER.error("中餐厅煲仔饭设备上报异常 {}",e);
        }
    }


}


