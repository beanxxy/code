package com.bgy.gateway.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author caijunwei
 * date 2020/12/9 10:54
 */
@Setter
@Getter
public class MonitorInfo extends CommonInfo {

    @ApiModelProperty(value = "参数主键")
    private Long id;

    @ApiModelProperty(value = "部件ID")
    private Long componentId;

    @ApiModelProperty(value = "方法ID")
    private Long functionId;

    @ApiModelProperty(value = "数据模型ID")
    private Long dataModelId;

    @ApiModelProperty(value = "编号")
    private Integer code;

    @ApiModelProperty(value = "监听值")
    private String monitorValue;

    @ApiModelProperty(value = "监听信息")
    private String message;

}
