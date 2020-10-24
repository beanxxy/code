package com.bgy.gateway.model.message.cold;

import com.bgy.gateway.config.SystemConfig;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/3/1 13:53
 */
public class ColdChineseFoodIn extends RequestMessageIn {

    private List<Integer> errorList;
    private int enable;// 1  允许  2 不允许
    private int cookId;//
    private int cookType;
    private int sign;
    private int layer;
    private int dishId;


    @Override
    public int calcLength() {
        int datalength = 22;
        int sublength = 0;
        switch (this.getRequest()) {
            case 1: sublength = 22;break;
            default:
                break;
        }
        return datalength + sublength;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        if (this.getRequest() == CommandType.ONE.getStatus()) {
            errorList = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
            enable = NettyUtil.readShort(in, isBigEndian);
            cookId = NettyUtil.readShort(in, isBigEndian);
            cookType = NettyUtil.readShort(in, isBigEndian);
            sign = NettyUtil.readShort(in, isBigEndian);
            layer = NettyUtil.readShort(in, isBigEndian);
            dishId = NettyUtil.readInt(in, isBigEndian);

        }
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        // skip
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

    public List<Integer> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Integer> errorList) {
        this.errorList = errorList;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public int getCookType() {
        return cookType;
    }

    public void setCookType(int cookType) {
        this.cookType = cookType;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
