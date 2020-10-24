package com.bgy.gateway.model.message.cook;

import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

public class CookSimpleChineseFoodOut extends AbstractMessage {

    private byte[] cookParam;

    @Override
    public int calcLength() {
        if(cookParam != null) {
            return cookParam.length;
        }
        return 0;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        // skip
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        if(cookParam != null) {
            NettyUtil.writeBytes(out, isBigEndian, cookParam);
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

    public byte[] getCookParam() {
        return cookParam;
    }

    public void setCookParam(byte[] cookParam) {
        this.cookParam = cookParam;
    }
}
