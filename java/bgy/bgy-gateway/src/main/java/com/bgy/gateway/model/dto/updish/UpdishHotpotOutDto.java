package com.bgy.gateway.model.dto.updish;

import com.bgy.gateway.enums.CommandType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;

/**
 * @author caijunwei
 * date 2020/1/3 17:01
 */
public class UpdishHotpotOutDto {

    @NotNull(message = "上菜口设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "rfid不能为空。")
    private Integer rfid;
    @NotNull(message = "dishId不能为空。")
    private Integer dishId;
    @NotNull(message = "state不能为空。")
    private Integer state; //status :1 允许  2 不允许   3 等待

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

    public Integer getRfid() {
        return rfid;
    }

    public void setRfid(Integer rfid) {
        this.rfid = rfid;
    }

    public Integer getDishId() {
        return dishId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }
}
