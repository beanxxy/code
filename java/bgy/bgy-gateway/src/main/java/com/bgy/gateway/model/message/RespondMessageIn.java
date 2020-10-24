package com.bgy.gateway.model.message;

import com.bgy.gateway.enums.RespondStatus;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2019/12/31 17:32
 */
public class RespondMessageIn extends  AbstractMessage{

    private RespondStatus respondStatus;

    @Override
    public int calcLength() {
        // skip
        return 0;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        respondStatus = RespondStatus.fromMode(NettyUtil.readShort(in, isBigEndian));
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        // skip
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

    public RespondStatus getRespondStatus() {
        return respondStatus;
    }

    public void setRespondStatus(RespondStatus respondStatus) {
        this.respondStatus = respondStatus;
    }
}
