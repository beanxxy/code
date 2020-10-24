package com.bgy.gateway.model.message.belt;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2020/1/2 18:08
 */
public class BeltHotpotOut extends RequestMessageIn {
    private int command;
    private int rfid;
    private int dishId;

    @Override
    public int calcLength() {
        switch (command){
            case 1: return  8;
            case 2: return  2;
            case 3: return  2;
            case 4: return  8;
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
        if(CommandType.ONE.getStatus()==command || CommandType.FOUR.getStatus()==command){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeShort(out, isBigEndian, rfid);
            NettyUtil.writeInt(out, isBigEndian, dishId);
        }else if(CommandType.TWO.getStatus()==command || CommandType.THREE.getStatus()==command){
            NettyUtil.writeShort(out, isBigEndian, command);
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
}
