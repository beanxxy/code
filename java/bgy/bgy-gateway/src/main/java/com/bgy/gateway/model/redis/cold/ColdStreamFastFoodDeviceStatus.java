package com.bgy.gateway.model.redis.cold;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public class ColdStreamFastFoodDeviceStatus extends RedisDeviceStatus {

    private List<Integer> errorList;


    public ColdStreamFastFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
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
}
