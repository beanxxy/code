package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.down.DownChineseFoodIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2019/12/27 21:21
 */

public class DownChineseFoodDischarge {

    private  int deviceId;
    private  long missionId;
    private  int runState;
    private  long ct;



    public DownChineseFoodDischarge(Message<DownChineseFoodIn> msg){
        this.deviceId = msg.getDeviceId();
        this.runState = msg.getExtraData().getExceptionStatus().getStatus();
        this.missionId = msg.getExtraData().getMissionId();
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

    public int getRunState() {
        return runState;
    }

    public void setRunState(int runState) {
        this.runState = runState;
    }

    public long getCt() {
        return ct;
    }

    public void setCt(long ct) {
        this.ct = ct;
    }
}
