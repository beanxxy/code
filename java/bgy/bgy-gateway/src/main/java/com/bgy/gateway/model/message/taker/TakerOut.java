package com.bgy.gateway.model.message.taker;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2020/2/17 17:20
 */
public class TakerOut extends RequestMessageIn {
    private int command;
    private int takerNum;
    private int platId;


    @Override
    public int calcLength() {
        switch (command){
            case 1: return  6;
            case 2: return  6;
            case 3: return  6;
            case 4: return  6;
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
        if(CommandType.TWO.getStatus()==command || CommandType.THREE.getStatus()==command){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeShort(out, isBigEndian, takerNum);
            NettyUtil.writeShort(out, isBigEndian, platId);
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


    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getTakerNum() {
        return takerNum;
    }

    public void setTakerNum(int takerNum) {
        this.takerNum = takerNum;
    }

    public int getPlatId() {
        return platId;
    }

    public void setPlatId(int platId) {
        this.platId = platId;
    }
}
