package com.bgy.gateway.service.impl;

import com.bgy.gateway.enums.MessageType;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.RespondMessageIn;
import com.bgy.gateway.model.redis.RedisHeartbeat;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.service.DeviceService;
import com.bgy.gateway.service.MessageService;
import com.bgy.gateway.service.RedisService;
import com.bgy.gateway.constant.Constant;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    public static ConcurrentMap<String, ChannelHandlerContext> scanCodeMap = new ConcurrentHashMap();

    @Autowired
    private RedisService redisService;
    @Autowired
    private DeviceService deviceService;


    @Override
    public void messageCommonAction(ChannelHandlerContext ctx, Message msg) {
        RedisHeartbeat redisHeartbeat = new RedisHeartbeat();
        redisHeartbeat.setDeviceId(msg.getDeviceId());
        redisHeartbeat.setDeviceType(msg.getDeviceType());
        redisHeartbeat.setLastRequestTime(System.currentTimeMillis());
        redisService.pushHash(Constant.REDIS_HEARTBEAT_KEY, Integer.toString(msg.getDeviceId()), redisHeartbeat);
    }

    @Override
    public void handleHeartbeat(ChannelHandlerContext ctx, Message msg) {
        Message message = new Message();
        message.setHeader(msg.getHeader());
        message.setMessageType(MessageType.HEARTBEAT_RESPONSE);
        message.setUniqueKey(msg.getUniqueKey());
        message.setDeviceType(msg.getDeviceType());
        message.setDeviceId(msg.getDeviceId());
        ctx.writeAndFlush(message);
    }

    @Override
    public void handleRequest(ChannelHandlerContext ctx, Message msg) {
        // skip

        // 更新数据库
//        Device device = deviceService.getById(msg.getDeviceId());
//        String[] ipPort = NettyUtil.getChannelIpPortArray(ctx.channel());
//        if(device == null) {
//            device = new Device();
//            device.setId(message.getDeviceId());
//            device.setName("");
//            device.setDeviceType(message.getDeviceType().getType());
//            device.setSubType(message.getExtraData().getDeviceSubType());
//            device.setPid(0);
//            device.setLayerNum(0);
//            device.setCreateAt(new Date());
//            device.setEnable(1);
//            device.setDel(0);
//        }
//        device.setIp(ipPort[0]);
//        device.setPort(Integer.valueOf(ipPort[1]));
//        device.setUpdateAt(new Date());
//
//        deviceService.saveOrUpdate(device);
    }

    @Override
    public void handleResponse(ChannelHandlerContext ctx, Message msg) {
        String hashKey = msg.getDeviceId() + "_" + msg.getUniqueKey();
        if(redisService.hasHashKey(Constant.REDIS_RESPONSE_KEY, hashKey)) {
            redisService.pushHash(Constant.REDIS_RESPONSE_KEY, hashKey, Constant.REQUEST_RESPONSE_FLAG);
        }
    }

    @Override
    public void handleHeartbeatResponse(ChannelHandlerContext ctx, Message msg) {
        // skip
    }


    //带结果回复
    @Override
    public void handleResultResponse(ChannelHandlerContext ctx, Message msg) {
        String hashKey = msg.getDeviceId() + "_" + msg.getUniqueKey();
        Message<RespondMessageIn> message = msg;
        redisService.pushHash(Constant.REDIS_RESPONSE_RESULT_KEY, hashKey,message.getExtraData().getRespondStatus().toString());
        redisService.expire(Constant.REDIS_RESPONSE_RESULT_KEY,5, TimeUnit.MINUTES);
        LOGGER.info("客户端上报回复结果 key :{},结果:{}", hashKey,message.getExtraData().getRespondStatus().toString());
    }

    @Override
    public void handleLogin(ChannelHandlerContext ctx, Message msg) {
        LOGGER.info("服务端口：{}，设备登录：{}，设备id：{}", getLocalPort(ctx), getChannelIpPort(ctx), msg.getDeviceId());
        ChannelSupervise.addChannel(ctx.channel(), msg);
        msg.setMessageType(MessageType.LOGIN_RESPONSE);
        ctx.writeAndFlush(msg);

    }

    @Override
    public void handleLoginResponse(ChannelHandlerContext ctx, Message msg) {
        // skip
    }

    @Override
    public void handleActive(ChannelHandlerContext ctx) {
        LOGGER.info("服务端口：{}，设备上线：{}", getLocalPort(ctx), getChannelIpPort(ctx));
        if(getLocalPort(ctx)==Constant.ARM_PORT){
            scanCodeMap.put(String.valueOf(Constant.ARM_PORT), ctx);
            //LOGGER.info("表情机械臂设备上线 {}", scanCodeMap.get(String.valueOf(Constant.ARM_PORT)));
        }
    }

    @Override
    public void handleInactive(ChannelHandlerContext ctx) {
        if(!ctx.channel().isActive()){
            LOGGER.info("服务端口：{}，设备下线：{}", getLocalPort(ctx), getChannelIpPort(ctx));
            ChannelSupervise.removeChannel(ctx.channel());
            if(Integer.valueOf(getLocalPort(ctx))==Constant.ARM_PORT){
                scanCodeMap.clear();
            }
            ctx.close();
        }

    }

    @Override
    public void handleExceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        LOGGER.error("服务端口：" + getLocalPort(ctx) + "，捕获异常：" + getChannelIpPort(ctx),  cause);
        ctx.close();
    }

    @Override
    public String getChannelIpPort(ChannelHandlerContext ctx) {
        return ctx.channel().remoteAddress().toString().substring(1);
    }

    @Override
    public int getLocalPort(ChannelHandlerContext ctx) {
        return Integer.valueOf(ctx.channel().localAddress().toString().substring(1).split(":")[1]);
    }
}
