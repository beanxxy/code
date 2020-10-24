package com.bgy.gateway.model.dto.steam;

import com.bgy.gateway.model.dto.belt.DishDeviceMaterial;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author lzx
 * @date 2020/3/19.
 */
public class SteamSelfFastFoodOutDto {
    /**
     * 设备id
     */
    @NotNull(message = "设备id不能为空")
    private Integer deviceId;
    /**
     * 下发类型（1 出料 2 出料确认）
     */
    private Integer command;
    /**
     * 任务ID
     */
    @NotNull(message = "任务号不能为空")
    private Long missionId;
    /**
     * 水保温柜设备id
     */
    @NotNull(message = "水保温柜设备id不能为空")
    private Integer waterId;
    /**
     * 菜品数量
     */
    @NotNull(message = "菜品数量不能为空")
    private Integer count;
    /**
     * 材料
     */
    @NotNull
    private List<DishDeviceMaterial> details;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<DishDeviceMaterial> getDetails() {
        return details;
    }

    public void setDetails(List<DishDeviceMaterial> details) {
        this.details = details;
    }

    public SteamSelfFastFoodOutDto() {
    }

    public Integer getWaterId() {
        return waterId;
    }

    public void setWaterId(Integer waterId) {
        this.waterId = waterId;
    }

    public SteamSelfFastFoodOutDto(Integer deviceId, Integer command, Long missionId, Integer count, List<DishDeviceMaterial> details) {
        this.deviceId = deviceId;
        this.command = command;
        this.missionId = missionId;
        this.count = count;
        this.details = details;
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
}
