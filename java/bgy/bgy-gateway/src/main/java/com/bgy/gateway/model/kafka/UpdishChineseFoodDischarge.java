package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.updish.UpdishChineseFoodIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2019/12/27 21:21
 */

public class UpdishChineseFoodDischarge {

    private  int deviceId;
    private  long missionId;
    private  int dishId;
    private  int error;
    private  long ct;



    public UpdishChineseFoodDischarge(Message<UpdishChineseFoodIn> msg){
        this.deviceId = msg.getDeviceId();
        this.error = msg.getExtraData().getExceptionStatus().getStatus();
        this.missionId = msg.getExtraData().getMissionId();
        this.dishId = msg.getExtraData().getDishId();
        this.ct = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public long getCt() {
        return ct;
    }

    public void setCt(long ct) {
        this.ct = ct;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
