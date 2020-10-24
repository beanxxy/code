package com.bgy.gateway.model.dto.down;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;

/**
 * @author caijunwei
 * date 2020/1/3 17:01
 */
public class DownChineseFoodOutDto {

    @NotNull(message = "下菜口设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "任务ID不能为空。")
    private Long missionId;
    //@NotNull(message = "盘子size不能为空。")
    private  Integer size;// 1 大  2 中  3  小
    //@NotNull(message = "盘子size不能为空。")
    private  Integer tableId;// 餐桌ID

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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
}
