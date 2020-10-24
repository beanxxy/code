package com.bgy.gateway.model.message.claypot;
import com.bgy.gateway.config.SystemConfig;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.dto.claypot.ClaypotSimpleDto;
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
public class ClaypotChineseFoodIn extends RequestMessageIn {

    private List<Integer> errorList;
    private int enable;// 1  允许  2 不允许
    private int upId;
    private int totalLayer;
    private List<ClaypotSimpleDto> layerDetails;


    @Override
    public int calcLength() {
        int datalength =10;
        int sublength =0;
        switch (this.getRequest()){
            case 1: sublength=14+totalLayer*14;break;
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
            upId = NettyUtil.readShort(in, isBigEndian);
            totalLayer = NettyUtil.readShort(in, isBigEndian);
            layerDetails = NettyUtil.readObjectForClaypot(in,isBigEndian,totalLayer,true);
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

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public List<ClaypotSimpleDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<ClaypotSimpleDto> layerDetails) {
        this.layerDetails = layerDetails;
    }
}
