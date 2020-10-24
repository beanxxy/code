package com.bgy.gateway.model.message.belt;

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
 * date 2020/1/2 15:55
 */
public class BeltHotpotIn extends RequestMessageIn {
    private List<Integer> errorList;
    private  int freeCapacity; //剩余可写入菜品的寄存器位的数量
    private  int rfid;//
    private  int dishId;//
    private  int totalNum; //分发数量的总和
    private List<Integer>  rfidInfo; //rfid 集合
    private  List<Integer> dishIdInfo;  //菜品集合


    @Override
    public int calcLength() {
        int datalength =10;
        int sublength =0;
        switch (this.getRequest()){
            case 1: sublength=10;break;
            case 2:  sublength=6;break;
            case 3:  sublength=2+totalNum*6;break;
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
            freeCapacity = NettyUtil.readShort(in, isBigEndian);
        }else if(this.getRequest() == CommandType.TWO.getStatus()){
            rfid = NettyUtil.readShort(in, isBigEndian);
            dishId = NettyUtil.readInt(in, isBigEndian);
        }else if(this.getRequest() == CommandType.THREE.getStatus()){
            totalNum = NettyUtil.readShort(in, isBigEndian);
            rfidInfo = NettyUtil.readManyInfo(in,isBigEndian,totalNum,SystemConfig.IS_READ_SHORT);
            dishIdInfo = NettyUtil.readManyInfo(in,isBigEndian,totalNum,!SystemConfig.IS_READ_SHORT);
        }else if(this.getRequest() == CommandType.FOUR.getStatus()){
            errorList = NettyUtil.readWarningInfo(in, isBigEndian, SystemConfig.IS_WARNING_INFO_REAL_LONG);
            freeCapacity = NettyUtil.readShort(in, isBigEndian);
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

    public int getFreeCapacity() {
        return freeCapacity;
    }

    public void setFreeCapacity(int freeCapacity) {
        this.freeCapacity = freeCapacity;
    }

    public int getRfid() {
        return rfid;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<Integer> getRfidInfo() {
        return rfidInfo;
    }

    public void setRfidInfo(List<Integer> rfidInfo) {
        this.rfidInfo = rfidInfo;
    }

    public List<Integer> getDishIdInfo() {
        return dishIdInfo;
    }

    public void setDishIdInfo(List<Integer> dishIdInfo) {
        this.dishIdInfo = dishIdInfo;
    }
}
