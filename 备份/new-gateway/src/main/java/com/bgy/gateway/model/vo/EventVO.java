package com.bgy.gateway.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author caijunwei
 * date 2020/12/2 17:27
 */
@Getter
@Setter
public class EventVO {

    @ApiModelProperty(value = "监控编号")
    private int code;


    @ApiModelProperty(value = "监控值及其地址")
    private String address;
}
