package com.bgy.gateway.model.dto.steam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lzx
 * @date 2020/3/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteamDoorUpDownDto {
    @NotNull(message = "类型不能为空")
    private Integer type;
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

    private Integer command;
}
