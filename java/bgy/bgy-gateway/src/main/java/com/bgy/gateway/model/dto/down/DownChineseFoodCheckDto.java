package com.bgy.gateway.model.dto.down;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DownChineseFoodCheckDto {
	@NotNull(message = "下菜口设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "任务ID不能为空。")
    private Long missionId;
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
    
}
