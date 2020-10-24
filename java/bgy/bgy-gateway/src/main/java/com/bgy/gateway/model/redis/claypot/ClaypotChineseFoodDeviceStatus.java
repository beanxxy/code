package com.bgy.gateway.model.redis.claypot;

import com.bgy.gateway.model.dto.claypot.ClaypotSimpleDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/3 15:52
 */
public class ClaypotChineseFoodDeviceStatus extends RedisDeviceStatus {

    private List<Integer> errorList;
    private int enable;// 1  允许  2 不允许
    private int upId;
    private int totalLayer;
    private List<ClaypotSimpleDto> layerDetails;




    public ClaypotChineseFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
        super(ctx, msg);
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

    public int getTotalLayer() {
        return totalLayer;
    }

    public void setTotalLayer(int totalLayer) {
        this.totalLayer = totalLayer;
    }

    public List<ClaypotSimpleDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<ClaypotSimpleDto> layerDetails) {
        this.layerDetails = layerDetails;
    }
}
