package com.bgy.gateway.model.dto.steam;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lzx
 * @date 2020/3/14.
 */
@NoArgsConstructor
@Data
public class SteamCageAssemblyDto {
    /**
     * 命令类型
     */
    private int command;
    /**
     * 任务id
     */
    @NotNull(message = "任务号不能为空")
    private Long missionId;
    /**
     * 层数
     */
    @NotNull(message = "层数不能为空")
    private Integer layer;

    /**
     * 设备id
     */
    @NotNull(message = "设备id不能为空")
    private Integer deviceId;

    public SteamCageAssemblyDto(int command, Long missionId, int layer) {
        this.command = command;
        this.missionId = missionId;
        this.layer = layer;
    }

    public SteamCageAssemblyDto(int command, Long missionId, int layer, int deviceId) {
        this.command = command;
        this.missionId = missionId;
        this.layer = layer;
        this.deviceId = deviceId;
    }
}
