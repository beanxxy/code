package com.bgy.gateway.model.kafka;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.cold.ColdHotpotIn;
import com.bgy.gateway.model.message.table.TableHotpotIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

/**
 * @author caijunwei
 * date 2019/12/27 21:21
 */
public class TableHotpotDischarge {

    private  int deviceId;
    private  int beltId;//物流线Id
    private  int rfid;
    private  int dishId;
    private List<Integer> rfidInfo; //rfid 集合
    private  List<Integer> dishIdInfo;  //菜品集合
    private  int totalNum; //分发数量的总和
    private  long ct;
    private  int uniqueKey;  //密钥



    public TableHotpotDischarge(Message<TableHotpotIn> msg){
        this.deviceId = msg.getDeviceId();
        this.beltId = msg.getExtraData().getBeltId();
        this.rfid = msg.getExtraData().getRfid();
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

    public int getBeltId() {
        return beltId;
    }

    public void setBeltId(int beltId) {
        this.beltId = beltId;
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

    public long getCt() {
        return ct;
    }

    public void setCt(long ct) {
        this.ct = System.currentTimeMillis();
    }

    public int getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(int uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
