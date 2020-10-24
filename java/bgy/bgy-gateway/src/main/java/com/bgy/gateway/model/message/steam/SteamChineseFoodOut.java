package com.bgy.gateway.model.message.steam;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.dto.steam.SteamColdDto;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/2/17 17:20
 */
public class SteamChineseFoodOut extends RequestMessageIn {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteamChineseFoodOut.class);
    private Integer command;
    private Long missionId;
    private Integer layer;
    private Integer dishId;
    private Integer coldId;
    private List<SteamColdDto> layerDetails;



    @Override
    public int calcLength() {
        switch (command){
            case 1: return  26;
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
            if(CommandType.ONE.getStatus()==command){
                NettyUtil.writeShort(out, isBigEndian, command);
                NettyUtil.writeLong(out, isBigEndian, missionId);
                NettyUtil.writeShort(out, isBigEndian, layer);
                NettyUtil.writeInt(out, isBigEndian, dishId);
                NettyUtil.writeShort(out, isBigEndian, coldId);
                layerDetails.forEach(streamColdDto -> {
                    NettyUtil.writeShort(out, isBigEndian, streamColdDto.getLayer());
                    NettyUtil.writeShort(out, isBigEndian, streamColdDto.getNum());
                });
            }
        }catch (Exception e){
            LOGGER.info("中餐蒸箱解码异常 {}", e.getStackTrace());
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

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public List<SteamColdDto> getLayerDetails() {
        return layerDetails;
    }

    public void setLayerDetails(List<SteamColdDto> layerDetails) {
        this.layerDetails = layerDetails;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getColdId() {
        return coldId;
    }

    public void setColdId(Integer coldId) {
        this.coldId = coldId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }
}
