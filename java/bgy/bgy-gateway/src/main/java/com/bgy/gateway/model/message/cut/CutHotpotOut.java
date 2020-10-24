package com.bgy.gateway.model.message.cut;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2019/12/29 22:22
 */
public class CutHotpotOut extends RequestMessageIn {

    private int command;
    private  int monthDay;
    private  int hourMinute;
    private  int rfid;
    private  int dishId;
    private  long labelId;

    @Override
    public int calcLength() {
        switch (command){
            case 1: return  20;
            default:
                break;
        }
        return 0;
    }


    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        // skip
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        if(CommandType.ONE.getStatus()==command){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeShort(out, isBigEndian, monthDay);
            NettyUtil.writeShort(out, isBigEndian, hourMinute);
            NettyUtil.writeInt(out, isBigEndian, dishId);
            NettyUtil.writeLong(out, isBigEndian, labelId);
        }
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

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public int getHourMinute() {
        return hourMinute;
    }

    public void setHourMinute(int hourMinute) {
        this.hourMinute = hourMinute;
    }

    public int getRfid() {
        return rfid;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }
}

