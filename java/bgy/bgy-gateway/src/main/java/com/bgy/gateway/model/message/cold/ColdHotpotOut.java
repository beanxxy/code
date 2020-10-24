package com.bgy.gateway.model.message.cold;

import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2019/12/29 14:56
 */

public class ColdHotpotOut extends AbstractMessage {

    private int command;
    private int location;

    @Override
    public int calcLength() {
        return 4;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {

    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        NettyUtil.writeShort(out, isBigEndian, command);
        NettyUtil.writeShort(out, isBigEndian, location);
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

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
