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
public class SteamChineseFoodIn extends RequestMessageIn {

    private List<Integer> errorList;
    private int enable;// 1  允许  2 不允许
    private int totalLayer;
    private List<SteamSimpleDto> layerDetails;
    private int dishId;
    private int layer;
    private int result;
    private Long missionId;



    @Override
    public int calcLength() {
        int datalength =10;
        int sublength =0;
        switch (this.getRequest()){
            case 1: sublength=12+totalLayer*6;break;
            case 2:  sublength=16;break;
            default:
                break;
        }
        return datalength +sublength;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        if(this.getRequest() == CommandType.ONE.getStatus()){
            errorList = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
            enable = NettyUtil.readShort(in, isBigEndian);
            totalLayer = NettyUtil.readShort(in, isBigEndian);
            layerDetails = NettyUtil.readObject(in,isBigEndian,totalLayer,false);
        }else if(this.getRequest() == CommandType.TWO.getStatus()){
            result = NettyUtil.readShort(in, isBigEndian);
            missionId = NettyUtil.readLong(in,isBigEndian);
            layer = NettyUtil.readShort(in, isBigEndian);
            dishId = NettyUtil.readInt(in, isBigEndian);

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


    public List<Integer> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Integer> errorList) {
        this.errorList = errorList;
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

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }
}
