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
@TableName("plc_component")
@ApiModel(value = "plc_component", description = "PLC组件表")
public class ComponentEntity extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlcId() {
        return plcId;
    }

    public void setPlcId(Long plcId) {
        this.plcId = plcId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "ComponentEntity{" +
                "id=" + id +
                ", plcId=" + plcId +
                ", code=" + code +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", port=" + port +
                ", typeId=" + typeId +
                '}';
    }
}
