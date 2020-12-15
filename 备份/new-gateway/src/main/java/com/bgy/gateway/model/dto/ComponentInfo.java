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
public class ComponentInfo extends CommonInfo {


    @ApiModelProperty(value = "参数主键")
    private Long id;

    @ApiModelProperty(value = "plcID")
    private Long plcId;

    @ApiModelProperty(value = "编号")
    private Integer code;

    @ApiModelProperty(value = "父ID")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "端口")
    private Integer port;

    @ApiModelProperty(value = "部件类型")
    private Integer typeId;
}
