package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.cut.CutHotpotIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author caijunwei
 * date 2020/1/3 17:57
 */
public class CutHotpotDischarge {
    private  int deviceId;
    private  long ct;
    private  int rfid; //餐盘id
    private  int dishId;
    private  int monthDay;
    private  int hourMinute;
    private  long labelId;


    public CutHotpotDischarge (Message<CutHotpotIn> msg){
        this.deviceId = msg.getDeviceId();
        this.ct = System.currentTimeMillis();
        this.monthDay = msg.getExtraData().getMonthDay();
        this.hourMinute = msg.getExtraData().getHourMinute();
        this.rfid = msg.getExtraData().getRfid();
        this.dishId = msg.getExtraData().getDishId();
        this.labelId=msg.getExtraData().getLabelId();
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
        this.ct = ct;
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

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public int getHourMinute() {
        return hourMinute;
    }

    public void setHourMinute(int hourMinute) {
        this.hourMinute = hourMinute;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }
}
