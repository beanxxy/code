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
@TableName("plc")
@ApiModel(value = "plc", description = "PLC配置表")
public class PlcEntity extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
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



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getConfigVersionId() {
        return configVersionId;
    }

    public void setConfigVersionId(int configVersionId) {
        this.configVersionId = configVersionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getBigEndian() {
        return bigEndian;
    }

    public void setBigEndian(Integer bigEndian) {
        this.bigEndian = bigEndian;
    }

    @Override
    public String toString() {
        return "PlcEntity{" +
                "id=" + id +
                ", code=" + code +
                ", configVersionId=" + configVersionId +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", protocolId=" + protocolId +
                ", typeId=" + typeId +
                ", bigEndian=" + bigEndian +
                '}';
    }
}
