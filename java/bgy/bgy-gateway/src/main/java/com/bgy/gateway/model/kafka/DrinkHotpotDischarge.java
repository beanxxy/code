package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.drink.DrinkHotpotIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2020/1/3 17:57
 */
public class DrinkHotpotDischarge {
    private  int deviceId;
    private long missionId;
    private int result;
    private long ct;


    public DrinkHotpotDischarge(Message<DrinkHotpotIn> msg){
        this.deviceId = msg.getDeviceId();
        this.ct = System.currentTimeMillis();
        this.missionId = msg.getExtraData().getMissionId();
        this.result = msg.getExtraData().getResult();
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

    public long getCt() {
        return ct;
    }

    public void setCt(long ct) {
        this.ct = System.currentTimeMillis();
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
