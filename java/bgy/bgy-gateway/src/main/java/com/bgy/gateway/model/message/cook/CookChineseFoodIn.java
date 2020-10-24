package com.bgy.gateway.model.message.cook;
import com.bgy.gateway.config.SystemConfig;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

import java.util.List;

public class CookChineseFoodIn extends RequestMessageIn {

    private List<Integer> errorList;
    private  int enable;// 1  允许  2 不允许

    private int dishId;
    private int upId;
    @Override
    public int calcLength() {
        // skip
        return 0;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        if(this.getRequest() == CommandType.ONE.getStatus()){
            errorList = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
            enable = NettyUtil.readShort(in, isBigEndian);
            upId = NettyUtil.readShort(in, isBigEndian);
            dishId = NettyUtil.readInt(in, isBigEndian);
        }else if(this.getRequest() == CommandType.TWO.getStatus()){
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


    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public List<Integer> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Integer> errorList) {
        this.errorList = errorList;
    }
}
