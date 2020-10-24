package com.bgy.gateway.service.store.impl;

import com.alibaba.fastjson.JSON;
import com.bgy.gateway.model.kafka.SteamFastFoodSelfStockCharge;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.belt.BeltStreamSelfFastFoodIn;
import com.bgy.gateway.model.message.belt.BeltStreamSelfWaterFastFoodIn;
import com.bgy.gateway.model.redis.belt.BeltStreamSelfFastFoodDeviceStatus;
import com.bgy.gateway.model.redis.belt.BeltStreamSelfWaterFastFoodDeviceStatus;
import com.bgy.gateway.service.KafkaService;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.service.store.FastFoodSelfService;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.ServiceUtil;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzx
 * @date 2020/3/19.
 */
@Slf4j
@Service
public class FastFoodSelfServiceImpl implements FastFoodSelfService {
    @Autowired
    RedisService redisService;

    @Autowired
    KafkaService kafkaService;

    @Override
    public void handleBeltSelfStreamRequest(ChannelHandlerContext ctx, Message msg) {

        try {
            Message<BeltStreamSelfFastFoodIn> message = msg;
            BeltStreamSelfFastFoodIn beltStreamSelfFastFoodIn = message.getExtraData();
            List<Integer> errorList = beltStreamSelfFastFoodIn.getErrorList();
            int request = beltStreamSelfFastFoodIn.getRequest();
            switch (request) {
                case 1:
                    //第二步：更新设备状态
                    BeltStreamSelfFastFoodDeviceStatus beltStreamSelfFastFoodDeviceStatus = new BeltStreamSelfFastFoodDeviceStatus(ctx, message);
                    beltStreamSelfFastFoodDeviceStatus.setErrorList(errorList);
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY + message.getHeader(), Integer.toString(message.getDeviceId()), beltStreamSelfFastFoodDeviceStatus);
                    log.info("自助式蒸箱主控设备更新redis设备状态：[{}]", message);
                    //第一步：上报设备管理系统
                   // kafkaService.pushToDeviceSystem(msg,errorList);
                    //log.info("自助式蒸箱主控设备上报设备转态到设备管理系统：[{}]", message);
                    break;
                default:
                    log.warn("不支持此操作");
            }
            //回复客户端
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        }catch (Exception e){
            log.error("上报蒸箱出现异常{}",e);
        }

    }

    @Override
    public void handleBeltSelfWaterStreamRequest(ChannelHandlerContext ctx, Message msg) {

        try {
            Message<BeltStreamSelfWaterFastFoodIn> message = msg;
            BeltStreamSelfWaterFastFoodIn beltStreamSelfWaterFastFoodIn = message.getExtraData();
            List<Integer> errorList = beltStreamSelfWaterFastFoodIn.getErrorList();
            int request = beltStreamSelfWaterFastFoodIn.getRequest();
            switch (request) {
                case 1:
                    //第二步：更新设备状态
                    BeltStreamSelfWaterFastFoodDeviceStatus beltStreamSelfWaterFastFoodDeviceStatus = new BeltStreamSelfWaterFastFoodDeviceStatus(ctx, message);
                    beltStreamSelfWaterFastFoodDeviceStatus.setErrorList(errorList);
                    redisService.pushHash(Constant.REDIS_DEVICE_STATE_KEY + message.getHeader(), Integer.toString(message.getDeviceId()), beltStreamSelfWaterFastFoodDeviceStatus);
                    log.info("自助式蒸箱主控设备更新redis设备状态：[{}]", message);
                    //第一步：上报设备管理系统
                    //kafkaService.pushToDeviceSystem(msg, errorList);
                    //log.info("自助式蒸箱主控设备上报设备转态到设备管理系统：[{}]", message);
                    break;
                //进出料上报
                case 2:
                    //将信息放到kafka
                    SteamFastFoodSelfStockCharge streamFastFoodSelfStockCharge = new SteamFastFoodSelfStockCharge();
                    streamFastFoodSelfStockCharge.setDeviceId(message.getDeviceId());
                    streamFastFoodSelfStockCharge.setTime(System.currentTimeMillis());
                    streamFastFoodSelfStockCharge.setNum(beltStreamSelfWaterFastFoodIn.getNum());
                    streamFastFoodSelfStockCharge.setRow(beltStreamSelfWaterFastFoodIn.getRow());
                    streamFastFoodSelfStockCharge.setType(beltStreamSelfWaterFastFoodIn.getType());
                    streamFastFoodSelfStockCharge.setMessageId(message.getUniqueKey());
                    kafkaService.pushToInside(Constant.KAFKA_STEAM_WATER_DEVICE_STOCK, JSON.toJSONString(streamFastFoodSelfStockCharge));
                    log.info("将蒸箱水保温柜进出料信息同步到kafka:{}", streamFastFoodSelfStockCharge);
                    break;
                default:
                    log.warn("不支持此操作");
            }
            //回复客户端
            ServiceUtil.sendRequestCommonReply(ctx, msg);
        }catch (Exception e){
            log.error("上报水保温柜出现异常{}",e);
        }

    }
}
