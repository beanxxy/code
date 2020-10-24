package com.bgy.gateway.model.message.updish;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.dto.updish.UpdishSimpleDto;
import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/3 17:10
 */
public class UpdishChineseFoodOut extends AbstractMessage {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdishChineseFoodOut.class);

    private  int command;
    private  Long missionId;
    private  int cookId;
    private  List<UpdishSimpleDto> layerDetails;
    private  int mechanism;// 1 自动  2 人工
    private  int size;// 1 大  2 中  3  小
    private  int dishId;

    @Override
    public int calcLength() {
        switch (command){
            case 2: return  14;
            case 3: return  6;
            case 4: return  22;
            case 5: return  22;
            case 6: return  32;
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
        try {
            if(CommandType.TWO.getStatus()==command ){
                NettyUtil.writeShort(out, isBigEndian, command);
                NettyUtil.writeLong(out, isBigEndian, missionId);
                NettyUtil.writeInt(out, isBigEndian, dishId);
            }else if(CommandType.THREE.getStatus()==command || CommandType.SEVEN.getStatus()==command ){
                NettyUtil.writeShort(out, isBigEndian, command);
                NettyUtil.writeShort(out, isBigEndian, mechanism);
                NettyUtil.writeShort(out, isBigEndian, size);
            }else if(CommandType.FOUR.getStatus()==command
                    || CommandType.FIVE.getStatus()==command
                    || CommandType.SIX.getStatus()==command){
                NettyUtil.writeShort(out, isBigEndian, command);
                NettyUtil.writeLong(out, isBigEndian, missionId);
                NettyUtil.writeShort(out, isBigEndian, cookId);
                layerDetails.sort(Comparator.comparing(UpdishSimpleDto::getColdId));
                layerDetails.forEach(updishSimpleDto -> {
                    NettyUtil.writeInt(out, isBigEndian, updishSimpleDto.getDishId());
                    NettyUtil.writeShort(out, isBigEndian, updishSimpleDto.getColdId());
                    NettyUtil.writeShort(out, isBigEndian, updishSimpleDto.getLayer());
                    NettyUtil.writeShort(out, isBigEndian, updishSimpleDto.getNum());
                });
            }
        }catch (Exception e){
            LOGGER.info("中餐厅上菜口下发命令异常：{}", e.getStackTrace());
            LOGGER.error("中餐厅上菜口下发命令异常：{}", e.getStackTrace());
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

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public List<UpdishSimpleDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<UpdishSimpleDto> layerDetails) {
        this.layerDetails = layerDetails;
    }

    public int getMechanism() {
        return mechanism;
    }

    public void setMechanism(int mechanism) {
        this.mechanism = mechanism;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }
}
