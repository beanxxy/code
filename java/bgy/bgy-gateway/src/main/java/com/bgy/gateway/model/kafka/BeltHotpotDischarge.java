package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.belt.BeltHotpotIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/2 16:44
 */
public class BeltHotpotDischarge {
    private  int deviceId;
    private  int rfid;
    private  int dishId;
    private List<Integer> rfidInfo; //rfid 集合
    private  List<Integer> dishIdInfo;  //菜品集合
    private  int totalNum;  //数量分发总和
    private  int uniqueKey;  //密钥

    public BeltHotpotDischarge(Message<BeltHotpotIn> msg){
        this.deviceId = msg.getDeviceId();
        this.rfid =msg.getExtraData().getRfid();
        this.dishId = msg.getExtraData().getDishId();
        this.rfidInfo = msg.getExtraData().getRfidInfo();
        this.dishIdInfo = msg.getExtraData().getDishIdInfo();
        this.totalNum = msg.getExtraData().getTotalNum();
        this.uniqueKey = msg.getUniqueKey();

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

    public List<Integer> getRfidInfo() {
        return rfidInfo;
    }

    public void setRfidInfo(List<Integer> rfidInfo) {
        this.rfidInfo = rfidInfo;
    }

    public List<Integer> getDishIdInfo() {
        return dishIdInfo;
    }

    public void setDishIdInfo(List<Integer> dishIdInfo) {
        this.dishIdInfo = dishIdInfo;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(int uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
