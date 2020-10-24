package com.bgy.gateway.model.message.updish;

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
 * date 2020/1/3 15:02
 */
public class UpdishChineseFoodIn extends RequestMessageIn {

    private  List<Integer> errorList;
    private  int enable;// 1  允许  2 不允许
    private  int mechanism;// 1 自动  2 人工
    private  int runState;
    private  int pushState;
    private  int empty;
    private  int sign;
    private  long missionId;
    private  int dishId;


    @Override
    public int calcLength() {
        int datalength =22;
        int sublength =30;
        switch (this.getRequest()){
            case 1: sublength=30;break;
            case 2:  sublength=6;break;
            default:
                break;
        }
        return datalength +sublength;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        super.decode(in, isBigEndian);
        if(this.getRequest() == CommandType.ONE.getStatus()){
            errorList = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
            enable = NettyUtil.readShort(in, isBigEndian);
            mechanism = NettyUtil.readShort(in, isBigEndian);
            runState = NettyUtil.readShort(in, isBigEndian);
            pushState = NettyUtil.readShort(in, isBigEndian);
            empty = NettyUtil.readShort(in, isBigEndian);
            sign = NettyUtil.readShort(in, isBigEndian);
            missionId = NettyUtil.readLong(in, isBigEndian);
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

    public int getMechanism() {
        return mechanism;
    }

    public void setMechanism(int mechanism) {
        this.mechanism = mechanism;
    }

    public int getPushState() {
        return pushState;
    }

    public void setPushState(int pushState) {
        this.pushState = pushState;
    }

    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getRunState() {
        return runState;
    }

    public void setRunState(int runState) {
        this.runState = runState;
    }
}
