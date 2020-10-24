package com.bgy.gateway.model.dto.belt;

/**
 * @author caijunwei
 * date 2020/2/26 9:54
 */
public class DishDevicesDto {
    private int dishId;
    private int deviceId;//保温柜编号编号
    private int layer;//第几层
    private int size;//盘子大小

    public static DishDevicesDto getDishDevicesDtoDefault(){
        DishDevicesDto dishDevicesDto = new DishDevicesDto();
        dishDevicesDto.setSize(0);
        dishDevicesDto.setLayer(0);
        dishDevicesDto.setDishId(0);
        return dishDevicesDto;
    };

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
