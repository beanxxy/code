package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.steam.SteamFastFoodIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2019/12/27 21:21
 */
public class SteamOutDishFastFoodDischarge {

    private  int deviceId;
    private  int plateId;
    private  int dishId;
    private  int result; //1 成功  2 失败
    private  int layer;//第几层
    private  long ct;
    private  long  missionId;

    public SteamOutDishFastFoodDischarge(Message<SteamFastFoodIn> msg){
        this.deviceId = msg.getDeviceId();
        this.plateId = msg.getExtraData().getPlateId();
        this.dishId = msg.getExtraData().getDishId();
        this.result = msg.getExtraData().getResult();
        this.layer = msg.getExtraData().getLayer();
        this.ct = System.currentTimeMillis();
        this.missionId = msg.getExtraData().getMissionId();
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

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public long getCt() {
        return ct;
    }

    public void setCt(long ct) {
        this.ct = System.currentTimeMillis();
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }
}
