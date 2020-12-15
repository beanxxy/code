package com.bgy.gateway.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author caijunwei
 * date 2020/12/9 10:49
 */

@Setter
@Getter
public class CommonInfo {

    @ApiModelProperty(value = "创建人")
    private Integer createdBy;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新人")
    private Integer updatedBy;

    @ApiModelProperty(value = "创建时间")
    private Date dateTime;

    @ApiModelProperty(value = "删除标志")
    private Integer deleted;
}
