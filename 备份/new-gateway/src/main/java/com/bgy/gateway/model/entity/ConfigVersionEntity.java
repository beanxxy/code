package com.bgy.gateway.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caijunwei
 * date 2020/11/26 16:00
 */

@TableName("plc_config_version")
@ApiModel(value = "plc_config_version", description = "PLC配置版本表")
public class ConfigVersionEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "子类型ID")
    private Integer subTypeId;

    @ApiModelProperty(value = "版本名称")
    private String name;

    @ApiModelProperty(value = "是否启用")
    private Integer enabled;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(Integer subTypeId) {
        this.subTypeId = subTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }


    @Override
    public String toString() {
        return "ConfigVersionEntity{" +
                "id=" + id +
                ", subTypeId=" + subTypeId +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
