package com.bgy.gateway.model.dto.steam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author caijunwei
 * date 2020/2/17 16:45
 */
public class SteamChineseFoodOutDto {
    @NotNull(message = "蒸箱设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    //@NotNull(message = "任务ID不能为空。")
    private Integer dishId;
    @NotNull(message = "菜品不能为空。")
    private Long missionId;
    @NotNull(message = "层数不能为空。")
    private Integer layer;
    @NotNull(message = "冷库ID不能为空。")
    private Integer coldId;
    @NotNull(message = "冷库层数数量不能为空。")
    private List<SteamColdDto> layerDetails;
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }


    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getColdId() {
        return coldId;
    }

    public void setColdId(Integer coldId) {
        this.coldId = coldId;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public List<SteamColdDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<SteamColdDto> layerDetails) {
        this.layerDetails = layerDetails;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }
}
