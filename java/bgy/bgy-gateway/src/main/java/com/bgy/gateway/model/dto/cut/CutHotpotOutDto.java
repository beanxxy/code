package com.bgy.gateway.model.dto.cut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;

/**
 * @author caijunwei
 * date 2019/12/31 16:00
 */
public class CutHotpotOutDto {
    @NotNull(message = "设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "月日值不能为空。")
    private  int monthDay;
    @NotNull(message = "时分值不能为空。")
    private  int hourMinute;
    @NotNull(message = "rfid不能为空。")
    private  int rfid;
    @NotNull(message = "菜品ID不能为空。")
    private  int dishId;
    @NotNull(message = "标签ID不能为空。")
    private Long labelId;


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

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public int getHourMinute() {
        return hourMinute;
    }

    public void setHourMinute(int hourMinute) {
        this.hourMinute = hourMinute;
    }

    public int getRfid() {
        return rfid;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }
}
