package com.bgy.gateway.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author caijunwei
 * date 2020/12/3 15:41
 */
@TableName("command_log")
@ApiModel(value = "CommandLogEntity对象", description = "命令日志表")
public class CommandLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一Id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "发送命令地址")
    private String path;

    @ApiModelProperty(value = "唯一编号")
    private String reqCode;

    @ApiModelProperty(value = "设备Id")
    private Integer deviceId;

    @ApiModelProperty(value = "请求内容")
    private String req;

    @ApiModelProperty(value = "回应内容")
    private String resp;

    @ApiModelProperty(value = "结果(1  数控引擎回应成功;2  数控引擎回应失败;3  调用数控引擎超时;4  调用数控引擎内部报错;)")
    private Integer result;

    @ApiModelProperty(value = "请求时间")
    private Long reqTime;

    @ApiModelProperty(value = "响应时间")
    private Long respTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getReqCode() {
        return reqCode;
    }

    public void setReqCode(String reqCode) {
        this.reqCode = reqCode;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public void setReqTime(Long reqTime) {
        this.reqTime = reqTime;
    }

    public Long getRespTime() {
        return respTime;
    }

    public void setRespTime(Long respTime) {
        this.respTime = respTime;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "CommandLogEntity{" +
                "id=" + id +
                ", path=" + path +
                ", reqCode=" + reqCode +
                ", deviceId=" + deviceId +
                ", req=" + req +
                ", resp=" + resp +
                ", result=" + result +
                ", reqTime=" + reqTime +
                ", respTime=" + respTime +
                ", createAt=" + createAt +
                "}";
    }
}
