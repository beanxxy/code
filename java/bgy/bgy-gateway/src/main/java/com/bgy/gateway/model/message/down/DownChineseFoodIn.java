package com.bgy.gateway.model.message.down;

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
public class DownChineseFoodIn extends RequestMessageIn {
    private  List<Integer> errorList;
    private  int enable;// 1  允许  2 不允许
    private  int runState;
    private  int pushState;
    private  long missionId;



    @Override
    public int calcLength() {
        int datalength =22;
        int sublength =22;
        switch (this.getRequest()){
            case 1: sublength=8;break;
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
            runState = NettyUtil.readShort(in, isBigEndian);
            pushState = NettyUtil.readShort(in, isBigEndian);
            missionId = NettyUtil.readLong(in, isBigEndian);

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

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getRunState() {
        return runState;
    }

    public void setRunState(int runState) {
        this.runState = runState;
    }

    public int getPushState() {
        return pushState;
    }

    public void setPushState(int pushState) {
        this.pushState = pushState;
    }
}
