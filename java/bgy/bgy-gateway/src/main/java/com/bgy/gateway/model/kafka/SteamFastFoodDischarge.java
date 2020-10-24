package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.steam.SteamFastFoodIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2019/12/27 21:21
 */
public class SteamFastFoodDischarge {

    private  int deviceId;
    private  long missionId;
    private  int dishId;
    private  int mode;
    private  int result; //1 成功  2 失败
    private  int doNum; //操作数量
    //private  int outNum;//冷库出料量
    private  long ct;


    public SteamFastFoodDischarge(Message<SteamFastFoodIn> msg){
        this.deviceId = msg.getDeviceId();
        this.missionId = msg.getExtraData().getMissionId();
        this.dishId = msg.getExtraData().getDishId();
        this.mode = msg.getExtraData().getMode();
        this.result = msg.getExtraData().getResult();
        this.doNum = msg.getExtraData().getDoNum();
        //this.outNum = msg.getExtraData().getOutNum();

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

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getDoNum() {
        return doNum;
    }

    public void setDoNum(int doNum) {
        this.doNum = doNum;
    }

   /* public int getOutNum() {
        return outNum;
    }

    public void setOutNum(int outNum) {
        this.outNum = outNum;
    }*/

    public long getCt() {
        return  System.currentTimeMillis();
    }

    public void setCt(long ct) {
        this.ct =ct;
    }
}
