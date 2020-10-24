package com.bgy.gateway.model.redis.table;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author caijunwei
 * date 2019/12/30 16:16
 */
public class TableHotpotDeviceStatus extends RedisDeviceStatus {
    private List<Integer> errorList;
    private  int beltId;//物流线Id


    private  int spareSpace;//剩余菜品存放的容量
    private int freeCapacity; //剩余可写入菜品的寄存器位的数量

    public TableHotpotDeviceStatus() {
        super();
    }

    public TableHotpotDeviceStatus(ChannelHandlerContext ctx, Message msg) {
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

    public int getBeltId() {
        return beltId;
    }

    public void setBeltId(int beltId) {
        this.beltId = beltId;
    }

    public int getSpareSpace() {
        return spareSpace;
    }

    public void setSpareSpace(int spareSpace) {
        this.spareSpace = spareSpace;
    }

    public int getFreeCapacity() {
        return freeCapacity;
    }

    public void setFreeCapacity(int freeCapacity) {
        this.freeCapacity = freeCapacity;
    }
}