package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.updish.UpdishHotpotIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2020/1/3 15:17
 */
public class UpdishHotpotDischarge {

    private  int deviceId;
    private  int rfid;
    private  int dishId;

    public UpdishHotpotDischarge(Message<UpdishHotpotIn> msg){
        this.deviceId = msg.getDeviceId();
        this.rfid = msg.getExtraData().getRfid();
        this.dishId = msg.getExtraData().getDishId();

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

    public int getRfid() {
        return rfid;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }
}
