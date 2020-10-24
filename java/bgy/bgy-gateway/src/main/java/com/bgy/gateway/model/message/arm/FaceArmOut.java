package com.bgy.gateway.model.message.arm;

import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2019/12/29 14:56
 */

public class FaceArmOut extends AbstractMessage {

    private int zeroCode=0;
    private int endCode=23294;

    @Override
    public int calcLength() {
        return 40949;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {

    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        NettyUtil.writeShort(out, isBigEndian, zeroCode);
        NettyUtil.writeShort(out, isBigEndian, endCode);
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

    public int getZeroCode() {
        return zeroCode;
    }

    public void setZeroCode(int zeroCode) {
        this.zeroCode = zeroCode;
    }

    public int getEndCode() {
        return endCode;
    }

    public void setEndCode(int endCode) {
        this.endCode = endCode;
    }
}
