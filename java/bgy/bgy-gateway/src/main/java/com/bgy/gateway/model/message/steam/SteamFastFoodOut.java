package com.bgy.gateway.model.message.steam;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * @author caijunwei
 * date 2020/2/17 17:20
 */
public class SteamFastFoodOut extends AbstractMessage {
    private Integer command;
    private Integer dishId;
    private Long missionId;
    private Integer layer;
    //private Integer cookId;
    private Integer warmTemp;
    private Integer cookTemp;
    private Integer cookTime;
    private Integer stock;
    private Integer type;


    @Override
    public int calcLength() {
        switch (command){
            case 1: return  24;
            case 2: return  24;
            case 3: return  2;
            case 4: return  8;
            case 5: return  6;
            case 6: return  6;
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
        if(CommandType.ONE.getStatus()==command || CommandType.TWO.getStatus()==command){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeLong(out, isBigEndian, missionId);
            NettyUtil.writeShort(out, isBigEndian, layer);
            NettyUtil.writeShort(out, isBigEndian, warmTemp);
            NettyUtil.writeShort(out, isBigEndian, cookTemp);
            NettyUtil.writeShort(out, isBigEndian, cookTime);
            //NettyUtil.writeShort(out, isBigEndian, cookId);
            NettyUtil.writeInt(out,isBigEndian,dishId);
            NettyUtil.writeShort(out, isBigEndian, stock);
        }else if(CommandType.THREE.getStatus()==command || CommandType.FOUR.getStatus()==command){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeLong(out, isBigEndian, missionId);
            NettyUtil.writeShort(out, isBigEndian, layer);
        }else if(CommandType.FIVE.getStatus()==command || CommandType.SIX.getStatus()==command) {
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeLong(out, isBigEndian, layer);
            NettyUtil.writeShort(out, isBigEndian, type);
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

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    /*public Integer getCookId() {
        return cookId;
    }

    public void setCookId(Integer cookId) {
        this.cookId = cookId;
    }*/

    public Integer getWarmTemp() {
        return warmTemp;
    }

    public void setWarmTemp(Integer warmTemp) {
        this.warmTemp = warmTemp;
    }

    public Integer getCookTemp() {
        return cookTemp;
    }

    public void setCookTemp(Integer cookTemp) {
        this.cookTemp = cookTemp;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
