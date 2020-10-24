package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.cold.ColdHotpotIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * @author caijunwei
 * date 2019/12/27 21:21
 */

public class ColdHotpotDischarge {

    private  int deviceId;
    private  int beltId;//物流线Id
    private  int location;// 位置
    private  int result; //结果
    private  long ct;
    private  int rfid; //餐盘id
    private  int dishId;
    private  int monthDay;
    private  int hourMinute;


    public ColdHotpotDischarge (Message<ColdHotpotIn> msg){
        this.deviceId = msg.getDeviceId();
        this.beltId = msg.getExtraData().getBeltId();
        this.location = msg.getExtraData().getLocation();
        this.result = msg.getExtraData().getResult();
        this.ct = System.currentTimeMillis();
        this.monthDay = msg.getExtraData().getMonthDay();
        this.hourMinute = msg.getExtraData().getHourMinute();
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

    public int getBeltId() {
        return beltId;
    }

    public void setBeltId(int beltId) {
        this.beltId = beltId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
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
}
