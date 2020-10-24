package com.bgy.gateway.model.message.belt;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.dto.belt.DishDevicesDto;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author caijunwei
 * date 2020/1/2 18:08
 */
@Slf4j
public class BeltStreamFastFoodOut extends RequestMessageIn {

    private int command;
    private int takerId;
    private int plateId;
    private int orderType;
    private int num;
    private List<DishDevicesDto> dishDevicesDTO;


    @Override
    public int calcLength() {
        switch (command) {
            case 1:
                return 50;
            case 2:
                return 50;
            default:
                break;
        }
        return 0;
    }


    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        // skip
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        if (CommandType.ONE.getStatus() == command || CommandType.TWO.getStatus() == command) {
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeShort(out, isBigEndian, takerId);
            NettyUtil.writeShort(out, isBigEndian, plateId);
            NettyUtil.writeShort(out, isBigEndian, orderType);
            NettyUtil.writeShort(out, isBigEndian, num);
            if (!this.dishDevicesDTO.isEmpty() && this.dishDevicesDTO.size() > Constant.STREAM_PLANT_SPECIFICATION) {
                log.warn("调度系统传参有误");
            }
            // 这里协议定的有问题
            Map<Integer, DishDevicesDto> form = dishDevicesDTO.stream().collect(Collectors.toMap(DishDevicesDto::getDeviceId, t -> t, (t1, t2) -> t1));
            if (this.dishDevicesDTO.size() < Constant.STREAM_PLANT_SPECIFICATION) {
                for (int i = 1; i <= Constant.STREAM_PLANT_SPECIFICATION; i++) {
                    DishDevicesDto dishDevicesDto = form.get(i);
                    if (null == dishDevicesDto) {
                        DishDevicesDto dishDevicesDtoDefault = DishDevicesDto.getDishDevicesDtoDefault();
                        dishDevicesDtoDefault.setDeviceId(i);
                        this.dishDevicesDTO.add(dishDevicesDtoDefault);
                    }
                }
            }
            //sort
            List<DishDevicesDto> result = this.dishDevicesDTO.stream().sorted(Comparator.comparing(DishDevicesDto::getDeviceId)).collect(Collectors.toList());
            result.stream().map(DishDevicesDto::getDeviceId).forEach(e -> NettyUtil.writeShort(out, isBigEndian, e));
            result.stream().map(DishDevicesDto::getDishId).forEach(e -> NettyUtil.writeInt(out, isBigEndian, e));
            result.stream().map(DishDevicesDto::getLayer).forEach(e -> NettyUtil.writeShort(out, isBigEndian, e));
            result.stream().map(DishDevicesDto::getSize).forEach(e -> NettyUtil.writeShort(out, isBigEndian, e));
        }
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

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getTakerId() {
        return takerId;
    }

    public void setTakerId(int takerId) {
        this.takerId = takerId;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<DishDevicesDto> getDishDevicesDTO() {
        return dishDevicesDTO;
    }

    public void setDishDevicesDTO(List<DishDevicesDto> dishDevicesDTO) {
        this.dishDevicesDTO = dishDevicesDTO;
    }
}
