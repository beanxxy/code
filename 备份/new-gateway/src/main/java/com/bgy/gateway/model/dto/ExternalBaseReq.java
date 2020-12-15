package com.bgy.gateway.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caijunwei
 * date 2020/12/3 15:41
 */
@Setter
@Getter
public class ExternalBaseReq {

    @ApiModelProperty(value = "参数名称")
    String name;

    @ApiModelProperty(value = "参数地址")
    String dataAddress;

    @ApiModelProperty(value = "参数值")
    String value;


    public Map<String, Object> toParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("dataAddress", dataAddress);
        params.put("value", value);
        return params;
    }
}
