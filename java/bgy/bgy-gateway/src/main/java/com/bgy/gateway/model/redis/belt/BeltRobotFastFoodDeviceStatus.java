package com.bgy.gateway.model.redis.belt;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/3 15:39
 */
public class BeltRobotFastFoodDeviceStatus extends RedisDeviceStatus {
    private int deviceId;
    private int takerId;
    private int takerState;
    private int orderType;
    private int robotId;
    private int actionType;
    private int takePosition;
    private int platePosition;
    private long  ct;



    public BeltRobotFastFoodDeviceStatus() {
        super();
    }

    public BeltRobotFastFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
        super(ctx, msg);
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

    public int getTakerId() {
        return takerId;
    }

    public void setTakerId(int takerId) {
        this.takerId = takerId;
    }

    public int getTakerState() {
        return takerState;
    }

    public void setTakerState(int takerState) {
        this.takerState = takerState;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getRobotId() {
        return robotId;
    }

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public int getTakePosition() {
        return takePosition;
    }

    public void setTakePosition(int takePosition) {
        this.takePosition = takePosition;
    }

    public int getPlatePosition() {
        return platePosition;
    }

    public void setPlatePosition(int platePosition) {
        this.platePosition = platePosition;
    }

    @Override
    public long getCt() {
        return System.currentTimeMillis();
    }

    @Override
    public void setCt(long ct) {
        this.ct = ct;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
