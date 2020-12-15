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
public class DataModelInfo extends CommonInfo {

    @ApiModelProperty(value = "参数主键")
    private Long id;

    @ApiModelProperty(value = "部件ID")
    private Long componentId;

    @ApiModelProperty(value = "编号")
    private Integer code;

    @ApiModelProperty(value = "父ID")
    private Long parentId;

    @ApiModelProperty(value = "第三方ID 与设备管理系统交互使用")
    private String thirdPartyId;

    @ApiModelProperty(value = "地址 非连续块时可空")
    private String address;

    @ApiModelProperty(value = "数据类型 (枚举)数据类型与长度不能同时为空")
    private Integer dataTypeId;

    @ApiModelProperty(value = "长度 数据类型与长度不能同时为空")
    private Integer length;

    @ApiModelProperty(value = "解析顺序")
    private Integer sort;

    @ApiModelProperty(value = "是否连续块 1:是，0:否")
    private Integer continuous;

    @ApiModelProperty(value = "是否采集 1:是，0:否")
    private Integer acquisition;

}
