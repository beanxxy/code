package com.bgy.gateway.model.message.steam;

import com.bgy.gateway.config.SystemConfig;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.dto.steam.SteamSimpleDto;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/3 17:46
 */
public class SteamFastFoodIn extends RequestMessageIn {
    private List<Integer> warningInfo;
    //设备总状态（1 可烹饪 2 不可烹饪）
    private int cookState;
    private int totalLayer;
    private List<SteamSimpleDto> layerDetails;
    private long missionId;
    private int dishId;
    private int mode;  //是否是上位机备料  1 是  2否
    private int result; //1 成功  2 失败
    private int doNum; //操作数量
    // private  int outNum;//冷库出料量
    private int plateId;
    private int layer;

    @Override
    public int calcLength() {
        int datalength = 22;
        int sublength = 0;
        switch (this.getRequest()) {
            case 1:
                sublength = 10 + totalLayer * 8;
                break;
            case 2:
                sublength = 16;
                break;
            case 3:
                sublength = 10;
                break;
            case 4:
                sublength = 10;
                break;
            default:
                break;
        }
        return datalength + sublength;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        if (this.getRequest() == CommandType.ONE.getStatus()) {
            warningInfo = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
            cookState = NettyUtil.readShort(in, isBigEndian);
            totalLayer = NettyUtil.readShort(in, isBigEndian);
            layerDetails = NettyUtil.readObject(in, isBigEndian, totalLayer, true);
        } else if (this.getRequest() == CommandType.TWO.getStatus()) {
            result = NettyUtil.readShort(in, isBigEndian);
            missionId = NettyUtil.readLong(in, isBigEndian);
            dishId = NettyUtil.readInt(in, isBigEndian);
            mode = NettyUtil.readShort(in,isBigEndian);
            doNum = NettyUtil.readShort(in, isBigEndian);
            // outNum = NettyUtil.readShort(in, isBigEndian);
        } else if (this.getRequest() == CommandType.THREE.getStatus()) {
            result = NettyUtil.readShort(in, isBigEndian);
            missionId = NettyUtil.readLong(in, isBigEndian);
            dishId = NettyUtil.readInt(in, isBigEndian);
            layer = NettyUtil.readShort(in, isBigEndian);
        } else if (this.getRequest() == CommandType.FOUR.getStatus()) {
            result = NettyUtil.readShort(in, isBigEndian);
            missionId = NettyUtil.readLong(in, isBigEndian);
        }
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


    public List<Integer> getWarningInfo() {
        return warningInfo;
    }

    public void setWarningInfo(List<Integer> warningInfo) {
        this.warningInfo = warningInfo;
    }

    public int getTotalLayer() {
        return totalLayer;
    }

    public void setTotalLayer(int totalLayer) {
        this.totalLayer = totalLayer;
    }

    public List<SteamSimpleDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<SteamSimpleDto> layerDetails) {
        this.layerDetails = layerDetails;
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getDoNum() {
        return doNum;
    }

    public void setDoNum(int doNum) {
        this.doNum = doNum;
    }

 /*   public int getOutNum() {
        return outNum;
    }

    public void setOutNum(int outNum) {
        this.outNum = outNum;
    }*/

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getCookState() {
        return cookState;
    }

    public void setCookState(int cookState) {
        this.cookState = cookState;
    }
}
