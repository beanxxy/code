package com.bgy.gateway.model.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author caijunwei
 * date 2020/12/1 9:53
 */
public class BaseEntity {

    @ApiModelProperty(value = "创建人")
    private Integer createdBy;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新人")
    private Integer updatedBy;

    @ApiModelProperty(value = "创建时间")
    private Date dateTime;

    @ApiModelProperty(value = "删除标志")
    private Integer deleted;

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", dateTime=" + dateTime +
                ", deleted=" + deleted +
                '}';
    }
}
