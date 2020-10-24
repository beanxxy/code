package com.bgy.gateway.model.message.cold;

import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

import java.util.List;

public class ColdSimpleChineseFoodOut extends AbstractMessage {
    // 1：烹饪制作
    private int command;
    private int cookId;
    private long missionId;
    // int
    private int productId;

    private int boxNum;
    private List<ColdBox> boxList;

    @Override
    public int calcLength() {
        return 18 + 6 * boxNum;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        // skip
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        NettyUtil.writeShort(out, isBigEndian, command);
        NettyUtil.writeShort(out, isBigEndian, cookId);
        NettyUtil.writeLong(out, isBigEndian, missionId);
        NettyUtil.writeInt(out, isBigEndian, productId);
        NettyUtil.writeShort(out, isBigEndian, boxNum);
        boxList.forEach(box -> {
            NettyUtil.writeShort(out, isBigEndian, box.getSequence());
            NettyUtil.writeShort(out, isBigEndian, box.getRow());
            NettyUtil.writeShort(out, isBigEndian, box.getColumn());
        });
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

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
    }

    public List<ColdBox> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<ColdBox> boxList) {
        this.boxList = boxList;
    }
}
