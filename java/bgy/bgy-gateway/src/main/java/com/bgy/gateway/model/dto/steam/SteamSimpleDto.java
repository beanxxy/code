package com.bgy.gateway.model.dto.steam;

/**
 * @author caijunwei
 * date 2020/2/14 14:19
 */
public class SteamSimpleDto {

    private int layer;

    private int mode;

    private int cookState;

    private int doorState;

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getCookState() {
        return cookState;
    }

    public void setCookState(int cookState) {
        this.cookState = cookState;
    }

    public int getDoorState() {
        return doorState;
    }

    public void setDoorState(int doorState) {
        this.doorState = doorState;
    }
}
