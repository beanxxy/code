package com.bgy.gateway.model.message.drink;

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
public class DrinkHotpotOut extends RequestMessageIn {

    private int command;
    private long missionId;
    private int num;

    @Override
    public int calcLength() {
        switch (command){
            case 1: return  12;
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
            NettyUtil.writeLong(out, isBigEndian, missionId);
            NettyUtil.writeShort(out, isBigEndian, num);
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

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }
}

