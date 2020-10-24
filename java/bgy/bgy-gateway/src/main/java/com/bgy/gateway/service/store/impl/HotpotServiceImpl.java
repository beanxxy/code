package com.bgy.gateway.service.store.impl;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.enums.DeviceType;
import com.bgy.gateway.enums.MessageType;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.belt.BeltHotpotOutDto;
import com.bgy.gateway.model.dto.cold.ColdHotpotOutDto;
import com.bgy.gateway.model.dto.cut.CutHotpotOutDto;
import com.bgy.gateway.model.dto.drink.DrinkHotpotOutDto;
import com.bgy.gateway.model.dto.table.TableHotpotOutDto;
import com.bgy.gateway.model.dto.updish.UpdishHotpotOutDto;
import com.bgy.gateway.model.kafka.*;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.arm.FaceArmOut;
import com.bgy.gateway.model.message.belt.BeltHotpotIn;
import com.bgy.gateway.model.message.belt.BeltHotpotOut;
import com.bgy.gateway.model.message.cold.ColdHotpotIn;
import com.bgy.gateway.model.message.cold.ColdHotpotOut;
import com.bgy.gateway.model.message.cut.CutHotpotIn;
import com.bgy.gateway.model.message.cut.CutHotpotOut;
import com.bgy.gateway.model.message.drink.DrinkHotpotIn;
import com.bgy.gateway.model.message.drink.DrinkHotpotOut;
import com.bgy.gateway.model.message.table.TableHotpotIn;
import com.bgy.gateway.model.message.table.TableHotpotOut;
import com.bgy.gateway.model.message.updish.UpdishHotpotIn;
import com.bgy.gateway.model.message.updish.UpdishHotpotOut;
import com.bgy.gateway.model.redis.belt.BeltHotpotDeviceStatus;
import com.bgy.gateway.model.redis.cold.ColdHotpotDeviceStatus;
import com.bgy.gateway.model.redis.cut.CutHotpotDeviceStatus;
import com.bgy.gateway.model.redis.drink.DrinkHotpotDeviceStatus;
import com.bgy.gateway.model.redis.table.TableHotpotDeviceStatus;
import com.bgy.gateway.model.redis.updish.UpdishHotpotDeviceStatus;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.KafkaService;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.service.impl.MessageServiceImpl;
import com.bgy.gateway.service.store.HotpotService;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.CopyObjectUtil;
import com.bgy.gateway.util.SendMsgUtil;
import com.bgy.gateway.util.ServiceUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentMap;


@Service
public class HotpotServiceImpl implements HotpotService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotpotServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Autowired
    private KafkaService kafkaService;


    /**
     * 冷库设备上报处理
     * @param ctx
     * @param msg
     */
    @Override
    public void handleColdRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<ColdHotpotIn> message = msg;
            ColdHotpotDischarge coldHotpotDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    ColdHotpotDeviceStatus deviceStatus = new ColdHotpotDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setBeltId(message.getExtraData().getBeltId());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("冷库设备状态上报 {}",msg);
                    //推送状态到Kafka
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_COLD_STATE_TOPIC,deviceStatus);
                    // 上报设备状态到设备管理系统
                   // kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("冷库设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //将菜从冷库推出
                    coldHotpotDischarge = new ColdHotpotDischarge(message);
                    coldHotpotDischarge.setDeviceId(message.getDeviceId());
                    coldHotpotDischarge.setLocation(message.getExtraData().getLocation());
                    coldHotpotDischarge.setResult(message.getExtraData().getResult());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_COLD_OUT_DISH_TOPIC,coldHotpotDischarge);
                    LOGGER.info("冷库设备将菜从冷库推出 {}",coldHotpotDischarge);
                    break;
                case 3:
                    //将盘子放到环形带
                    coldHotpotDischarge = new ColdHotpotDischarge(message);
                    coldHotpotDischarge.setDeviceId(message.getDeviceId());
                    coldHotpotDischarge.setBeltId(message.getExtraData().getBeltId());
                    coldHotpotDischarge.setLocation(message.getExtraData().getLocation());
                    coldHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    coldHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    coldHotpotDischarge.setMonthDay(message.getExtraData().getMonthDay());
                    coldHotpotDischarge.setHourMinute(message.getExtraData().getHourMinute());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_COLD_PUT_GIRDLE_TOPIC,coldHotpotDischarge);
                    LOGGER.info("冷库将盘子放到环形带 {}",coldHotpotDischarge);
                    break;
                case 4:
                    //上报表情
                    int code =message.getExtraData().getCode();
                    LOGGER.info("冷库上报动作表情 {}",code);
                    int faceCode=0;
                    switch (code){
                        case 1: faceCode=Constant.ARM_CODE_ONE;break;
                        case 2: faceCode=Constant.ARM_CODE_TWO;break;
                        case 3: faceCode=Constant.ARM_CODE_THREE;break;
                        case 4: faceCode=Constant.ARM_CODE_FOUR;break;
                        case 5: faceCode=Constant.ARM_CODE_FIVE;break;
                        case 6: faceCode=Constant.ARM_CODE_SIX;break;
                        default:
                            LOGGER.info("没有匹配表情码 {}",code);
                    }
                    sendFaceArmBody(faceCode);
                    break;
                case 5:
                    //读盘上报
                    coldHotpotDischarge = new ColdHotpotDischarge(message);
                    coldHotpotDischarge.setDeviceId(message.getDeviceId());
                    coldHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    coldHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    coldHotpotDischarge.setMonthDay(message.getExtraData().getMonthDay());
                    coldHotpotDischarge.setHourMinute(message.getExtraData().getHourMinute());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_COLD_READ_DISH_TOPIC,coldHotpotDischarge);
                    LOGGER.info("冷库读盘上报 {}",coldHotpotDischarge);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);

        }catch (Exception e){
            LOGGER.error("火锅店冷库上报异常 {}", e);
        }


    }

    private void sendFaceArmBody(int faceCode) {
        try {
            ConcurrentMap<String, ChannelHandlerContext> scanCodeMap = MessageServiceImpl.scanCodeMap;
            if(!scanCodeMap.isEmpty()){
                ChannelHandlerContext ctx2 = scanCodeMap.get(String.valueOf(Constant.ARM_PORT));
                FaceArmOut faceArmOut = new FaceArmOut();
                Message<FaceArmOut>  responseMsg= new Message();
                responseMsg.setHeader(Constant.ARM_HEARDER);
                responseMsg.setMessageType(MessageType.HEARTBEAT);
                responseMsg.setUniqueKey(faceCode);
                Message armMsg = new Message();
                armMsg.setDeviceType(DeviceType.FACE_ARM_CODE_ONE);
                responseMsg.setDeviceType(armMsg.getDeviceType());
                responseMsg.setDeviceId(Constant.ARM_DEVICEID);
                responseMsg.setExtraData(faceArmOut);
                ctx2.writeAndFlush(responseMsg);
                //LOGGER.info("火锅店冷库机械臂表情设备发送成功 {}", responseMsg);
            }else{
                //LOGGER.info("火锅店冷库机械臂表情设备连接断开 {}", scanCodeMap);
            }
        }catch (Exception e){
            LOGGER.error("火锅店冷库机械臂表情设备发送异常 {}", e);
        }

    }

    public static byte[] getHexBytes(String str) {
        str = str.replaceAll(" ", "");
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }



    @Override
    public ResultVo sendColdCommand(ColdHotpotOutDto coldHotpotOutDto)  throws BusinessException{
        Channel channel = ChannelSupervise.getChannel(coldHotpotOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(coldHotpotOutDto.getDeviceId(), channel,redisService);
        ColdHotpotOut coldHotpotOut = new ColdHotpotOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(coldHotpotOutDto, coldHotpotOut);
        Message<ColdHotpotOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(coldHotpotOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(coldHotpotOut);
       // return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
        return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);

    }

    /**
     * 餐桌设备上报处理
     * @param ctx
     * @param msg
     */
    @Override
    public void handleTableRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<TableHotpotIn> message = msg;
            TableHotpotDischarge tableHotpotDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    TableHotpotDeviceStatus deviceStatus = new TableHotpotDeviceStatus(ctx, message);
                    deviceStatus.setBeltId(message.getExtraData().getBeltId());
                    deviceStatus.setSpareSpace(message.getExtraData().getSpareSpace());
                    deviceStatus.setFreeCapacity(message.getExtraData().getFreeCapacity());
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("餐桌设备状态上报 {}",msg);
                    // 上报设备状态到设备管理系统
                   // kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("餐桌设备设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //扫码取菜指令
                    tableHotpotDischarge = new TableHotpotDischarge(message);
                    tableHotpotDischarge.setBeltId(message.getExtraData().getBeltId());
                    tableHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    tableHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_TABLE_PICK_DISH,tableHotpotDischarge);
                    LOGGER.info("餐桌扫码取菜指令 {}",tableHotpotDischarge);
                    break;
                case 3:
                    //当前已分配菜品列表上报
                    tableHotpotDischarge = new TableHotpotDischarge(message);
                    tableHotpotDischarge.setBeltId(message.getExtraData().getBeltId());
                    tableHotpotDischarge.setTotalNum(message.getExtraData().getTotalNum());
                    tableHotpotDischarge.setRfidInfo(message.getExtraData().getRfidInfo());
                    tableHotpotDischarge.setDishIdInfo(message.getExtraData().getDishIdInfo());
                    tableHotpotDischarge.setUniqueKey(message.getUniqueKey());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_TABLE_ALLOCATED_DISH,tableHotpotDischarge);
                    LOGGER.info("当前餐桌已分配菜品列表上报 {}",tableHotpotDischarge);
                    break;
                case 4:
                    //plc已重启上报
                    tableHotpotDischarge = new TableHotpotDischarge(message);
                    tableHotpotDischarge.setBeltId(message.getExtraData().getBeltId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_TABLE_RESTART_STATE,tableHotpotDischarge);
                    LOGGER.info("餐桌plc已重启上报 {}",tableHotpotDischarge);
                    break;
                case 5:
                    //呼叫指令上报
                    tableHotpotDischarge = new TableHotpotDischarge(message);
                    tableHotpotDischarge.setBeltId(message.getExtraData().getBeltId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_TABLE_CALL_OUT,tableHotpotDischarge);
                    LOGGER.info("餐桌呼叫指令上报 {}",tableHotpotDischarge);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);

        }catch (Exception e){
            LOGGER.error("火锅店餐桌上报异常 {}", e);
        }
    }

    @Override
    public ResultVo sendTableCommand(TableHotpotOutDto tableHotpotOutDto) throws BusinessException{
        Channel channel = ChannelSupervise.getChannel(tableHotpotOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(tableHotpotOutDto.getDeviceId(), channel,redisService);
        TableHotpotOut tableHotpotOut = new TableHotpotOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(tableHotpotOutDto, tableHotpotOut);
        Message<TableHotpotOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(tableHotpotOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(tableHotpotOut);
        if(tableHotpotOutDto.getCommand() == CommandType.TWO.getStatus()){
            return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
        }
        return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
    }

    /**
     * 物流线设备上报处理
     * @param ctx
     * @param msg
     */
    @Override
    public void handleBeltRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<BeltHotpotIn> message = msg;
            BeltHotpotDischarge beltHotpotDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    BeltHotpotDeviceStatus deviceStatus = new BeltHotpotDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setFreeCapacity(message.getExtraData().getFreeCapacity());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("物流线设备状态上报 {}",msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("物流线设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //从环形带抓取盘子上报
                    beltHotpotDischarge= new BeltHotpotDischarge(message);
                    beltHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    beltHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_BELT_PICK_DISH,beltHotpotDischarge);
                    LOGGER.info("从环形带抓取盘子上报 {}",beltHotpotDischarge);
                    break;
                case 3:
                    //当前物流线已分配的盘子rfid列表信息上报
                    beltHotpotDischarge = new BeltHotpotDischarge(message);
                    beltHotpotDischarge.setTotalNum(message.getExtraData().getTotalNum());
                    beltHotpotDischarge.setRfidInfo(message.getExtraData().getRfidInfo());
                    beltHotpotDischarge.setDishIdInfo(message.getExtraData().getDishIdInfo());
                    beltHotpotDischarge.setUniqueKey(message.getUniqueKey());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_BELT_ALLOCATED_DISH,beltHotpotDischarge);
                    LOGGER.info("当前物流线已分配的盘子rfid列表信息上报 {}",beltHotpotDischarge);
                    break;
                case 4:
                    //plc已重启上报
                    beltHotpotDischarge = new BeltHotpotDischarge(message);
                    beltHotpotDischarge.setDeviceId(message.getDeviceId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_BELT_RESTART_STATE,beltHotpotDischarge);
                    LOGGER.info("plc已重启上报 {}",beltHotpotDischarge);
                    break;
                case 5:
                    //呼叫指令上报
                    beltHotpotDischarge = new BeltHotpotDischarge(message);
                    beltHotpotDischarge.setDeviceId(message.getDeviceId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_BELT_CALL_OUT,beltHotpotDischarge);
                    LOGGER.info("呼叫指令上报 {}",beltHotpotDischarge);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);


        }catch (Exception e){
            LOGGER.error("火锅店物流线上报异常 {}",e);
        }
    }

    @Override
    public ResultVo sendBeltCommand(BeltHotpotOutDto beltHotpotOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(beltHotpotOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(beltHotpotOutDto.getDeviceId(), channel,redisService);
        BeltHotpotOut beltHotpotOut = new BeltHotpotOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(beltHotpotOutDto, beltHotpotOut);
        Message<BeltHotpotOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(beltHotpotOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(beltHotpotOut);
        if(beltHotpotOutDto.getCommand() == CommandType.TWO.getStatus()){
            return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
        }
        return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
    }

    /**
     * 上菜口设备上报处理
     * @param ctx
     * @param msg
     */
    @Override
    public void handleUpdishRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<UpdishHotpotIn> message = msg;
            UpdishHotpotDischarge updishHotpotDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    UpdishHotpotDeviceStatus deviceStatus = new UpdishHotpotDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    deviceStatus.setRfid(message.getExtraData().getRfid());
                    deviceStatus.setDishId(message.getExtraData().getDishId());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("上菜口设备状态上报 {}",msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("上菜口设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //盘子写入菜品信息上报
                    updishHotpotDischarge = new UpdishHotpotDischarge(message);
                    updishHotpotDischarge.setDeviceId(message.getDeviceId());
                    updishHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    updishHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_UPDISH_WRITE_DISH,updishHotpotDischarge);
                    LOGGER.info("盘子写入菜品信息上报 {}",updishHotpotDischarge);
                    break;
                case 3:
                    //餐盘确认上环形带上报
                    updishHotpotDischarge = new UpdishHotpotDischarge(message);
                    updishHotpotDischarge.setDeviceId(message.getDeviceId());
                    updishHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    updishHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_UPDISH_CONFIRM_DISH,updishHotpotDischarge);
                    LOGGER.info("餐盘确认上环形带上报 {}",updishHotpotDischarge);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);


        }catch (Exception e){
            LOGGER.error("火锅店上菜口上报异常 {}",e);
        }
    }

    @Override
    public ResultVo sendUpdishCommand(UpdishHotpotOutDto updishHotpotOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(updishHotpotOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(updishHotpotOutDto.getDeviceId(), channel,redisService);
        UpdishHotpotOut updishHotpotOut = new UpdishHotpotOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(updishHotpotOutDto, updishHotpotOut);
        Message<UpdishHotpotOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(updishHotpotOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(updishHotpotOut);
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }

    /**
     * 切菜口设备上报
     * @param ctx
     * @param msg
     */
    @Override
    public void handleCutRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<CutHotpotIn> message = msg;
            CutHotpotDischarge cutHotpotDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    CutHotpotDeviceStatus deviceStatus = new CutHotpotDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("切菜口设备状态到上报 {}",msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("切菜口设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //切菜口写入信息上报
                    cutHotpotDischarge = new CutHotpotDischarge(message);
                    cutHotpotDischarge.setDeviceId(message.getDeviceId());
                    cutHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    cutHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_CUT_CONFIRM_DISH,cutHotpotDischarge);
                    LOGGER.info("切菜口写入信息上报 {}",cutHotpotDischarge);
                    break;
                case 3:
                    //切菜口读盘信息上报
                    cutHotpotDischarge = new CutHotpotDischarge(message);
                    cutHotpotDischarge.setDeviceId(message.getDeviceId());
                    cutHotpotDischarge.setDishId(message.getExtraData().getDishId());
                    cutHotpotDischarge.setRfid(message.getExtraData().getRfid());
                    cutHotpotDischarge.setLabelId(message.getExtraData().getLabelId());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_CUT_WRITE_DISH,cutHotpotDischarge);
                    LOGGER.info("切菜口录碟信息上报 {}",cutHotpotDischarge);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);


        }catch (Exception e){
            LOGGER.info("火锅店切菜口上报异常 {}",e);
        }
    }

    @Override
    public void handleDrinkRequest(ChannelHandlerContext ctx, Message msg) {
        try {
            Message<DrinkHotpotIn> message = msg;
            DrinkHotpotDischarge drinkHotpotDischarge;
            switch (message.getExtraData().getRequest()) {
                // 信息上报
                case 1:
                    // 更新设备状态
                    DrinkHotpotDeviceStatus deviceStatus = new DrinkHotpotDeviceStatus(ctx, message);
                    deviceStatus.setErrorList(message.getExtraData().getErrorList());
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY+message.getHeader(), Integer.toString(msg.getDeviceId()), deviceStatus);
                    LOGGER.info("饮料机设备状态上报 {}",msg);
                    // 上报设备状态到设备管理系统
                    //kafkaService.pushToDeviceSystem(msg,message.getExtraData().getErrorList());
                    //LOGGER.info("饮料机设备上报到设备管理系统：[{}]", message);
                    break;
                case 2:
                    //饮料设备完成任务上报
                    drinkHotpotDischarge = new DrinkHotpotDischarge(message);
                    drinkHotpotDischarge.setDeviceId(message.getDeviceId());
                    drinkHotpotDischarge.setMissionId(message.getExtraData().getMissionId());
                    drinkHotpotDischarge.setResult(message.getExtraData().getResult());
                    kafkaService.pushToInside(Constant.KAFKA_HOTPOT_DRINK_TASK_FINISH,drinkHotpotDischarge);
                    LOGGER.info("饮料设备确认完成任务 {}",msg);
                    break;
                default:
                    break;
            }

            ServiceUtil.sendRequestCommonReply(ctx, msg);


        }catch (Exception e){
            LOGGER.error("火锅店饮料机上报异常 {}",e);
        }
    }

    @Override
    public ResultVo sendDrinkCommand(DrinkHotpotOutDto drinkHotpotOutDto) throws BusinessException {
        Channel channel = ChannelSupervise.getChannel(drinkHotpotOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(drinkHotpotOutDto.getDeviceId(), channel,redisService);
        DrinkHotpotOut drinkHotpotOut = new DrinkHotpotOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(drinkHotpotOutDto, drinkHotpotOut);
        Message<DrinkHotpotOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(drinkHotpotOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(drinkHotpotOut);
        return ServiceUtil.sendAndRetryIfFailedAsync(channel, message, redisService);
    }

    @Override
    public ResultVo sendCutCommand(CutHotpotOutDto cutHotpotOutDto) throws BusinessException{
        Channel channel = ChannelSupervise.getChannel(cutHotpotOutDto.getDeviceId());
        Message loginMessage = SendMsgUtil.judgeOnline(cutHotpotOutDto.getDeviceId(), channel,redisService);
        CutHotpotOut cutHotpotOut = new CutHotpotOut();
        CopyObjectUtil.copyPropertiesIgnoreNull(cutHotpotOutDto, cutHotpotOut);
        Message<CutHotpotOut> message = new Message<>();
        SendMsgUtil.sendMessageBody(cutHotpotOutDto.getDeviceId(), loginMessage, message,redisService);
        message.setExtraData(cutHotpotOut);
        return ServiceUtil.sendAndWaitForResponse(channel, message, redisService);
    }


}


