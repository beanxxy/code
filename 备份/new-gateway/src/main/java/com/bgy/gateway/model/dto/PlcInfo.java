package com.bgy.gateway.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author caijunwei
 * date 2020/12/9 10:52
 */
@Setter
@Getter
public class PlcInfo extends  CommonInfo{

    @ApiModelProperty(value = "参数主键")
    private Long id;

    @ApiModelProperty(value = "编号 PLC实际ID")
    private int code;

    @ApiModelProperty(value = "配置版本ID")
    private int configVersionId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "端口")
    private Integer port;

    @ApiModelProperty(value = "协议类型")
    private Integer protocolId;

    @ApiModelProperty(value = "类型")
    private Integer typeId;

    @ApiModelProperty(value = "是否大端 1:是，0:否")
    private Integer bigEndian;

}
