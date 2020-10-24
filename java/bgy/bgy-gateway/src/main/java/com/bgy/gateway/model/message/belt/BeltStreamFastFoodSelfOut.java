package com.bgy.gateway.model.message.belt;

import com.bgy.gateway.model.dto.belt.DishDeviceMaterial;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.util.NettyUtil;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lzx
 * @date 2020/3/19.
 */
@Slf4j
public class BeltStreamFastFoodSelfOut extends RequestMessageIn {
    /**
     * 下发类型（1 出料 2 出料确认）
     */
    private Integer command;
    /**
     * 任务ID
     */
    private Long missionId;
    /**
     * 水保温柜ID
     */
    private Integer waterId;
    /**
     * 菜品数量
     */
    private Integer count;
    /**
     * 材料
     */
    private List<DishDeviceMaterial> details;

    public BeltStreamFastFoodSelfOut() {
    }

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<DishDeviceMaterial> getDetails() {
        return details;
    }

    public void setDetails(List<DishDeviceMaterial> details) {
        this.details = details;
    }

    public Integer getWaterId() {
        return waterId;
    }

    public void setWaterId(Integer waterId) {
        this.waterId = waterId;
    }

    @Override
    public int calcLength() {
        return 62;

    }

    @Override
    @SuppressWarnings("all")
    public void encode(ByteBuf out, boolean isBigEndian) {
        super.encode(out, isBigEndian);
        NettyUtil.writeShort(out, isBigEndian, command);
        NettyUtil.writeLong(out, isBigEndian, missionId);
        NettyUtil.writeShort(out, isBigEndian, waterId);
        NettyUtil.writeShort(out, isBigEndian, count);
        int size = details.size();
        if (!details.isEmpty() && size > Constant.STREAM_PLANT_SPECIFICATION) {
            log.warn("调度传参有误 oops");
        }
        Map<Integer, DishDeviceMaterial> stations = details.stream().collect(Collectors.toMap(DishDeviceMaterial::getStation, s -> s, (s1, s2) -> s1));
        if (size < Constant.STREAM_PLANT_SPECIFICATION) {
            for (int i = 1; i <= Constant.STREAM_PLANT_SPECIFICATION; i++) {
                DishDeviceMaterial dishDeviceMaterial = stations.get(i);
                if (null == dishDeviceMaterial) {
                    DishDeviceMaterial dto = DishDeviceMaterial.SteamDishDeviceMaterialDtoDefault();
                    dto.setStation(i);
                    details.add(dto);
                }
            }
        }
        List<DishDeviceMaterial> result = details.stream().sorted(Comparator.comparing(DishDeviceMaterial::getStation)).collect(Collectors.toList());
        result.stream().map(DishDeviceMaterial::getDishId).forEach(e -> NettyUtil.writeInt(out, isBigEndian, e));
        result.stream().map(DishDeviceMaterial::getStation).forEach(e -> NettyUtil.writeShort(out, isBigEndian, e));
        result.stream().map(DishDeviceMaterial::getLayer).forEach(e -> NettyUtil.writeShort(out, isBigEndian, e));
        result.stream().map(DishDeviceMaterial::getMaterialNum).forEach(e -> NettyUtil.writeShort(out, isBigEndian, e));
        result.stream().map(DishDeviceMaterial::getRow).forEach(e -> NettyUtil.writeShort(out, isBigEndian, e));
    }
}
