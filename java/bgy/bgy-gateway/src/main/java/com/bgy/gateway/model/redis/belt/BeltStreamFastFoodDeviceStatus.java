package com.bgy.gateway.model.redis.belt;

import com.bgy.gateway.model.dto.belt.BeltStreamSimpleDto;
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
public class BeltStreamFastFoodDeviceStatus extends RedisDeviceStatus {

    private List<Integer> errorList;
    private int plateId;
    private int takerId;
    private int takerState;
    private int orderType;


    public BeltStreamFastFoodDeviceStatus() {
        super();
    }

    public BeltStreamFastFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
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

    public List<Integer> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Integer> errorList) {
        this.errorList = errorList;
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
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
}
