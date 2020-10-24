package com.bgy.gateway.model.message.belt;

import com.bgy.gateway.config.SystemConfig;
import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.dto.belt.BeltStreamSimpleDto;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/1/2 15:55
 */
public class BeltStreamFastFoodIn extends RequestMessageIn {
    private List<Integer> errorList;
   // private List<BeltStreamSimpleDto> beltStreamSimpleDtoList;
    private long missionId;
    private int result;
    private int dishId;
    private int plateId;
    private int takerId;
    private int takerState;
    private int orderType;
    private int robotId;
    private int actionType;
    private int takePosition;
    private int platePosition;
    @Override
    public int calcLength() {
        int datalength =22;
        int sublength =0;
        switch (this.getRequest()){
            case 1: sublength=16;break;
            case 2: sublength=16;break;
            case 3: sublength=10;break;
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
            orderType = NettyUtil.readShort(in,isBigEndian);
            plateId = NettyUtil.readShort(in,isBigEndian);
            takerId = NettyUtil.readShort(in,isBigEndian);
            takerState = NettyUtil.readShort(in,isBigEndian);
        }else if(this.getRequest() == CommandType.THREE.getStatus()){
            takerId = NettyUtil.readShort(in,isBigEndian);
            robotId = NettyUtil.readShort(in,isBigEndian);
            actionType = NettyUtil.readShort(in,isBigEndian);
            takePosition = NettyUtil.readShort(in,isBigEndian);
            platePosition = NettyUtil.readShort(in,isBigEndian);
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

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public int getTakerId() {
        return takerId;
    }

    public void setTakerId(int takerId) {
        this.takerId = takerId;
    }

    public int getTakerState() {
        return takerState;
    }

    public void setTakerState(int takerState) {
        this.takerState = takerState;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getRobotId() {
        return robotId;
    }

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public int getTakePosition() {
        return takePosition;
    }

    public void setTakePosition(int takePosition) {
        this.takePosition = takePosition;
    }

    public int getPlatePosition() {
        return platePosition;
    }

    public void setPlatePosition(int platePosition) {
        this.platePosition = platePosition;
    }
}
