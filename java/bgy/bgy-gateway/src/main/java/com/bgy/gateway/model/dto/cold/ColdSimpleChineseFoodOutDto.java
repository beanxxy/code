package com.bgy.gateway.model.dto.cold;

import com.bgy.gateway.model.message.cold.ColdBox;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ColdSimpleChineseFoodOutDto {

    @NotNull(message = "冷库ID不能为空。")
    private Integer deviceId;
    @NotNull(message = "命令不能为空。")
    private Integer command;
    @NotNull(message = "炒锅ID不能为空。")
    private Integer cookId;
    @NotNull(message = "任务ID不能为空。")
    private Long missionId;
    @NotNull(message = "菜品ID不能为空。")
    private Integer productId;
    @NotNull(message = "料盒不能为空。")
    private List<ColdBox> boxList;

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

    public Integer getCookId() {
        return cookId;
    }

    public void setCookId(Integer cookId) {
        this.cookId = cookId;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<ColdBox> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<ColdBox> boxList) {
        this.boxList = boxList;
    }
}
