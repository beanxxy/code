package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.cold.ColdChineseFoodIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2019/12/27 21:21
 */

public class ColdChineseFoodDischarge {

    private  int deviceId;
    private int cookId;//
    private int cookType;
    private int layer;
    private int dishId;
    private  long ct;



    public ColdChineseFoodDischarge(Message<ColdChineseFoodIn> msg){
        this.deviceId = msg.getDeviceId();
        this.cookId = msg.getExtraData().getCookId();
        this.cookType = msg.getExtraData().getCookType();
        this.layer = msg.getExtraData().getLayer();
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

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public int getCookType() {
        return cookType;
    }

    public void setCookType(int cookType) {
        this.cookType = cookType;
    }


    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
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
}
