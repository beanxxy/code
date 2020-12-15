package com.bgy.gateway.model.dto;

import javax.validation.constraints.NotNull;

/**
 * @author caijunwei
 * date 2020/11/26 18:00
 */
public class ParamDTO {

    @NotNull(message = "组件编号不能为空")
    private Integer componentCode;

    @NotNull(message = "方法编号不能为空")
    private Integer functionCode;

    @NotNull(message = "任务ID不能为空")
    private String taskId;

    @NotNull(message = "参数值不能为空")
    private String value;

    public Integer getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(Integer componentCode) {
        this.componentCode = componentCode;
    }

    public Integer getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(Integer functionCode) {
        this.functionCode = functionCode;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParamDTO{" +
                "componentCode=" + componentCode +
                ", functionCode=" + functionCode +
                ", taskId='" + taskId + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
