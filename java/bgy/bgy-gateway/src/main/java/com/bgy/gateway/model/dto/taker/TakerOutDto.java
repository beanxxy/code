package com.bgy.gateway.model.dto.taker;

import javax.validation.constraints.NotNull;

/**
 * @author caijunwei
 * date 2020/2/19 14:48
 */
public class TakerOutDto {
    @NotNull(message = "设备ID不能为空。")
    private Integer deviceId;//取菜设备id
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "取餐口编号ID不能为空。")
    private Integer takerId;//取菜口编号
    @NotNull(message = "餐盘ID不能为空。")
    private Integer plateId;//餐盘ID

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getTakerId() {
        return takerId;
    }

    public void setTakerId(Integer takerId) {
        this.takerId = takerId;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }
}
