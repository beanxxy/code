package com.bgy.gateway.model.redis.updish;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.redis.RedisDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/3 15:52
 */
public class UpdishChineseFoodDeviceStatus extends RedisDeviceStatus {

    private List<Integer> errorList;
    private  int enable;// 1  允许  2 不允许
    private  int mechanism;// 1 自动  2 人工
    private  int runState;
    private  int pushState;
    private  int empty;
    private  int sign;
    private  long missionId;
    private  int dishId;



    public UpdishChineseFoodDeviceStatus(ChannelHandlerContext ctx, Message msg) {
        super(ctx, msg);
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
