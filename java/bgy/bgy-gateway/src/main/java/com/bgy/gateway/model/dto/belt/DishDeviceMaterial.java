package com.bgy.gateway.model.dto.belt;

/**
 * @author lzx
 * @date 2020/3/19.
 */
public class DishDeviceMaterial {
    /**
     * 菜品id
     */
    private int dishId;
    /**
     * 工位
     */
    private Integer station;
    /**
     * 层数
     */
    private Integer layer;
    /**
     * 包材编号
     */
    private Integer materialNum;
    /**
     * 保温柜列数
     */
    private Integer row;

    public static DishDeviceMaterial SteamDishDeviceMaterialDtoDefault() {
        return new DishDeviceMaterial(0, 0, 0, 0);
    }

    public DishDeviceMaterial() {
    }

    public DishDeviceMaterial(int dishId, Integer layer, Integer materialNum, Integer row) {
        this.dishId = dishId;
        this.layer = layer;
        this.materialNum = materialNum;
        this.row = row;
    }

    public DishDeviceMaterial(int dishId, Integer station, Integer layer, Integer materialNum, Integer row) {
        this.dishId = dishId;
        this.station = station;
        this.layer = layer;
        this.materialNum = materialNum;
        this.row = row;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public Integer getStation() {
        return station;
    }

    public void setStation(Integer station) {
        this.station = station;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(Integer materialNum) {
        this.materialNum = materialNum;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }
}
