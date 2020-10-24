package com.bgy.gateway.model.dto.belt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/2 18:04
 */
public class BeltStreamFastFoodOutDto {

    @NotNull(message = "物流线设备ID不能为空。")
    private Integer deviceId;
    //@NotNull(message = "下发类型不能为空。")
    private Integer command;
    @NotNull(message = "取餐口编号takerId不能为空。")
    private Integer takerId;
    @NotNull(message = "餐盘编号plateId不能为空。")
    private Integer plateId;
    @NotNull(message = "orderType不能为空。")
    private Integer orderType;
    @NotNull(message = "数量num不能为空。")
    private Integer num;
    @NotNull(message = "菜品dishId不能为空。")
    private List<DishDevicesDto> dishDevicesDTO;


    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    public Integer getTakerId() {
        return takerId;
    }

    public void setTakerId(Integer takerId) {
        this.takerId = takerId;
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public List<DishDevicesDto> getDishDevicesDTO() {
        return dishDevicesDTO;
    }

    public void setDishDevicesDTO(List<DishDevicesDto> dishDevicesDTO) {
        this.dishDevicesDTO = dishDevicesDTO;
    }
}
