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
@TableName("plc_alarm")
@ApiModel(value = "plc_alarm", description = "PLC报警表")
public class PlcAlarmEntity extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "部件ID")
    private Long componentId;

    @ApiModelProperty(value = "方法ID")
    private Long functionId;

    @ApiModelProperty(value = "编号")
    private Integer code;

    @ApiModelProperty(value = "监听值")
    private String monitorValue;

    @ApiModelProperty(value = "监听信息")
    private String message;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMonitorValue() {
        return monitorValue;
    }

    public void setMonitorValue(String monitorValue) {
        this.monitorValue = monitorValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PlcAlarmEntity{" +
                "id=" + id +
                ", componentId=" + componentId +
                ", functionId=" + functionId +
                ", code=" + code +
                ", monitorValue='" + monitorValue + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
