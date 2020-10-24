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
public class SteamFastFoodDeviceStatus extends RedisDeviceStatus {
    private List<Integer> warningInfo;
    // 设备总状态（1 可烹饪 0 不可烹饪）
    private int cookState;
    private int totalLayer;//总共层数
    private List<SteamSimpleDto> layerDetails;  //层数数组

    public SteamFastFoodDeviceStatus() {
        super();
    }

    public SteamFastFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
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

    public int getCookState() {
        return cookState;
    }

    public void setCookState(int cookState) {
        this.cookState = cookState;
    }
}
