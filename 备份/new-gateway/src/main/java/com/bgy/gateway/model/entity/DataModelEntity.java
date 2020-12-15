package com.bgy.gateway.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author caijunwei
 * date 2020/11/30 17:02
 */
@TableName("plc_data_model")
@ApiModel(value = "plc_data_model", description = "PLC数据模型表")
public class DataModelEntity extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Integer dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getContinuous() {
        return continuous;
    }

    public void setContinuous(Integer continuous) {
        this.continuous = continuous;
    }

    public Integer getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(Integer acquisition) {
        this.acquisition = acquisition;
    }

    @Override
    public String toString() {
        return "DataModelEntity{" +
                "id=" + id +
                ", componentId=" + componentId +
                ", code=" + code +
                ", parentId=" + parentId +
                ", thirdPartyId='" + thirdPartyId + '\'' +
                ", address='" + address + '\'' +
                ", dataTypeId=" + dataTypeId +
                ", length=" + length +
                ", sort=" + sort +
                ", continuous=" + continuous +
                ", acquisition=" + acquisition +
                '}';
    }
}
