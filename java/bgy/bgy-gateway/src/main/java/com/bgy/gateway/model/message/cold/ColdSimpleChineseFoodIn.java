package com.bgy.gateway.model.message.cold;

import com.bgy.gateway.model.message.RequestWarningMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

public class ColdSimpleChineseFoodIn extends RequestWarningMessageIn {
    // 0：无任务，1：任务开始，2：任务进行中，3：任务完成
    private int missionStatus;
    private long missionId;
    // int
    private int productId;
    private int row;
    private int column;
    private int dischargeStatus;

    @Override
    public int calcLength() {
        // skip
        return 0;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        missionStatus = NettyUtil.readShort(in, isBigEndian);
        missionId = NettyUtil.readLong(in, isBigEndian);
        productId = NettyUtil.readInt(in, isBigEndian);
        row = NettyUtil.readShort(in, isBigEndian);
        column = NettyUtil.readShort(in, isBigEndian);
        dischargeStatus = NettyUtil.readShort(in, isBigEndian);
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

    public int getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(int missionStatus) {
        this.missionStatus = missionStatus;
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDischargeStatus() {
        return dischargeStatus;
    }

    public void setDischargeStatus(int dischargeStatus) {
        this.dischargeStatus = dischargeStatus;
    }
}
