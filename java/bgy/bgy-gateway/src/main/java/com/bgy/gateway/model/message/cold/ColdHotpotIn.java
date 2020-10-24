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
 * date 2019/12/23 21:44
 */
public class ColdHotpotIn  extends RequestMessageIn {

    private List<Integer> errorList;
    private  int beltId;//物流线Id
    private  int location;// 位置
    private  int result; //结果
    private  int rfid;
    private  int monthDay;
    private  int hourMinute;
    private  int dishId;
    private  int code;


    @Override
    public int calcLength() {
        int datalength =10;
        int sublength =0;
        switch (this.getRequest()){
            case 1: sublength=10;break;
            case 2:  sublength=6;break;
            case 3:  sublength=14;break;
            case 4:  sublength=2;break;
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
            beltId = NettyUtil.readShort(in, isBigEndian);
        }else if(this.getRequest() == CommandType.TWO.getStatus()){
            beltId = NettyUtil.readShort(in, isBigEndian);
            location = NettyUtil.readShort(in, isBigEndian);
            result = NettyUtil.readShort(in, isBigEndian);
        }else if(this.getRequest() == CommandType.THREE.getStatus()){
            beltId = NettyUtil.readShort(in, isBigEndian);
            location = NettyUtil.readShort(in, isBigEndian);
            monthDay = NettyUtil.readShort(in, isBigEndian);
            hourMinute = NettyUtil.readShort(in, isBigEndian);
            rfid = NettyUtil.readShort(in, isBigEndian);
            dishId = NettyUtil.readInt(in, isBigEndian);
        }else if(this.getRequest() == CommandType.FOUR.getStatus()){
            code = NettyUtil.readShort(in, isBigEndian);
        } else if(this.getRequest() == CommandType.FIVE.getStatus()){
            monthDay = NettyUtil.readShort(in, isBigEndian);
            hourMinute = NettyUtil.readShort(in, isBigEndian);
            rfid = NettyUtil.readShort(in, isBigEndian);
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

    public int getRfid() {
        return rfid;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public int getHourMinute() {
        return hourMinute;
    }

    public void setHourMinute(int hourMinute) {
        this.hourMinute = hourMinute;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getBeltId() {
        return beltId;
    }

    public void setBeltId(int beltId) {
        this.beltId = beltId;
    }

    public List<Integer> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Integer> errorList) {
        this.errorList = errorList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
