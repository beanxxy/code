package com.bgy.gateway.model.dto.steam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author caijunwei
 * date 2020/2/17 16:45
 */
public class SteamFastFoodOutDto {
    @NotNull(message = "蒸箱设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "任务ID不能为空。")
    private Long missionId;
   // @NotNull(message = "菜品不能为空。")
    private Integer dishId;
    @NotNull(message = "层数不能为空。")
    private Integer layer;
   // @NotNull(message = "冷库ID不能为空。")
    //private Integer cookId;
  //  @NotNull(message = "保温温度不能为空。")
    private Integer warmTemp;
   // @NotNull(message = "烹饪温度不能为空。")
    private Integer cookTemp;
   // @NotNull(message = "烹饪时长不能为空。")
    private Integer cookTime;
   // @NotNull(message = "菜品库存数量。")
    private Integer stock;
   // @NotNull(message = "冷库层数数量不能为空。")
    //private List<SteamColdDto> coldDtoList;

    private Integer type;  //1 开门  2 关门

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

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
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

    public Integer getWarmTemp() {
        return warmTemp;
    }

    public void setWarmTemp(Integer warmTemp) {
        this.warmTemp = warmTemp;
    }

    public Integer getCookTemp() {
        return cookTemp;
    }

    public void setCookTemp(Integer cookTemp) {
        this.cookTemp = cookTemp;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
