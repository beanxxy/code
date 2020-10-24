package com.bgy.gateway.model.dto.updish;

/**
 * 中餐烹饪参数的冷库层选
 * @author caijunwei
 * date 2020/2/14 14:19
 */
public class UpdishSimpleDto {

    private int dishId;

    private int coldId;

    private int layer;

    private int num;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getColdId() {
        return coldId;
    }

    public void setColdId(int coldId) {
        this.coldId = coldId;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
