package com.bgy.gateway.model.dto.belt;

/**
 * @author caijunwei
 * date 2020/2/14 14:19
 */
public class BeltStreamSimpleDto {

    private int plateId;

    private int takerId;

    private int takerState;

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public int getTakerId() {
        return takerId;
    }

    public void setTakerId(int takerId) {
        this.takerId = takerId;
    }

    public int getTakerState() {
        return takerState;
    }

    public void setTakerState(int takerState) {
        this.takerState = takerState;
    }
}
