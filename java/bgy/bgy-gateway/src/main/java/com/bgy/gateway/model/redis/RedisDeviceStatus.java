package com.bgy.gateway.model.redis;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RedisDeviceStatus <T extends RequestMessageIn> {
    private int id;
    private int type;
    private int subType;
    private int ctrlMode;
    private int state;
    private int error;
    private String ip;
    private int port;
    private long ct;
    private String time;

    public RedisDeviceStatus() {

    }

    public RedisDeviceStatus(ChannelHandlerContext ctx, Message<T> msg) {
        String[] ipPort = NettyUtil.getChannelIpPortArray(ctx.channel());

        id = msg.getDeviceId();
        type = msg.getDeviceType().getType();
        subType = msg.getExtraData().getDeviceSubType();
        ctrlMode = msg.getExtraData().getControlMode().getMode();
        state = msg.getExtraData().getDeviceStatus().getStatus();
        error = msg.getExtraData().getExceptionStatus().getStatus();
        ip = ipPort[0];
        port = Integer.valueOf(ipPort[1]);
        ct = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public int getCtrlMode() {
        return ctrlMode;
    }

    public void setCtrlMode(int ctrlMode) {
        this.ctrlMode = ctrlMode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getCt() {
        return ct;
    }

    public void setCt(long ct) {
        this.ct = ct;
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public void setTime(String time) {
        this.time =time;
    }


}
