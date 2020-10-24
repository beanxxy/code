package com.bgy.gateway.model.message.updish;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2020/1/3 17:10
 */
public class UpdishHotpotOut extends AbstractMessage {

    private int command;
    private int rfid;
    private int dishId;
    private int state;
    @Override
    public int calcLength() {
        switch (command){
            case 1: return  10;
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
        if(CommandType.ONE.getStatus()==command ){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeShort(out, isBigEndian, rfid);
            NettyUtil.writeInt(out, isBigEndian, dishId);
            NettyUtil.writeShort(out, isBigEndian, state);
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

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
