package com.bgy.gateway.model.redis.cold;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/3/1 14:03
 */
public class ColdChineseFoodDeviceStatus extends RedisDeviceStatus {

    private List<Integer> errorList;
    private int enable;// 1  允许  2 不允许
    private int cookId;//
    private int cookType;
    private int sign;
    private int floor;
    private int dishId;


    public ColdChineseFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
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

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public int getCookType() {
        return cookType;
    }

    public void setCookType(int cookType) {
        this.cookType = cookType;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
