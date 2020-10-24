package com.bgy.gateway.model.dto.updish;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/3 17:01
 */
public class UpdishChineseFoodOutDto {

    @NotNull(message = "上菜口设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "任务ID不能为空。")
    private Long missionId;
   // @NotNull(message = "烹饪(炒锅/蒸箱/煲仔饭设备ID)cookId不能为空。")
    private Integer cookId;
   // @NotNull(message = "冷库层选不能为空。")
    private List<UpdishSimpleDto> layerDetails;
   // @NotNull(message = "机构类型mechanism不能为空。")
    private  Integer mechanism;// 1 自动  2 人工
    //@NotNull(message = "盘子size 不能为空。")
    private  Integer size;// 1 大  2 中  3  小

   // @NotNull(message = "菜品dishId 不能为空。")
    private  Integer dishId;// 1 大  2 中  3  小

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

    public Integer getCookId() {
        return cookId;
    }

    public void setCookId(Integer cookId) {
        this.cookId = cookId;
    }

    public List<UpdishSimpleDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<UpdishSimpleDto> layerDetails) {
        this.layerDetails = layerDetails;
    }

    public Integer getMechanism() {
        return mechanism;
    }

    public void setMechanism(Integer mechanism) {
        this.mechanism = mechanism;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }
}
