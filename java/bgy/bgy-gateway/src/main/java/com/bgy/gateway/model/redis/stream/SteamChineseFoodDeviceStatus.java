package com.bgy.gateway.model.redis.stream;

import com.bgy.gateway.model.dto.steam.SteamSimpleDto;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author caijunwei
 * date 2019/12/30 16:16
 */
public class SteamChineseFoodDeviceStatus extends RedisDeviceStatus {
    private List<Integer> errorList;
    private  int enable;// 1  允许  2 不允许
    private  int totalLayer;//总共层数
    private List<SteamSimpleDto> layerDetails;  //层数数组

    public SteamChineseFoodDeviceStatus() {
        super();
    }

    public SteamChineseFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
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

    public List<SteamSimpleDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<SteamSimpleDto> layerDetails) {
        this.layerDetails = layerDetails;
    }
}
