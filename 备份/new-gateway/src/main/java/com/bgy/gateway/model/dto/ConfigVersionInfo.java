package com.bgy.gateway.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author caijunwei
 * date 2020/12/9 10:56
 */
@Setter
@Getter
public class ConfigVersionInfo extends CommonInfo{

    @ApiModelProperty(value = "参数主键")
    private Long id;

    @ApiModelProperty(value = "子类型ID")
    private Integer subTypeId;

    @ApiModelProperty(value = "版本名称")
    private String name;

    @ApiModelProperty(value = "是否启用")
    private Integer enabled;

}
