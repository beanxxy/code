package com.bgy.gateway.model.redis.taker;

/**
 * @author caijunwei
 * date 2020/2/25 15:20
 */
public class TakerDeviceStatus {

    private int deviceId;
    private int plateId;
    private int orderType;
    private int takerState;
    private long ct;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getTakerState() {
        return takerState;
    }

    public void setTakerState(int takerState) {
        this.takerState = takerState;
    }

    public long getCt() {
        return System.currentTimeMillis();
    }

    public void setCt(long ct) {
        this.ct = ct;
    }
}
