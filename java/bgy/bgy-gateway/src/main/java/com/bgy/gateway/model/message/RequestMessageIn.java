package com.bgy.gateway.model.message;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.enums.ControlMode;
import com.bgy.gateway.enums.DeviceStatus;
import com.bgy.gateway.enums.ExceptionStatus;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

/**
 * 信息上报(不包含报警信息)继承：RequestMessageIn
 * 信息上报(包含报警信息)继承：RequestWarningMessageIn
 */
public class RequestMessageIn extends AbstractMessage {

    private int deviceSubType;
    private ControlMode controlMode;
    private DeviceStatus deviceStatus;
    private ExceptionStatus exceptionStatus;
    private int request;

    @Override
    public int calcLength() {
        // skip
        return 10;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        deviceSubType = NettyUtil.readShort(in, isBigEndian);
        controlMode = ControlMode.fromMode(NettyUtil.readShort(in, isBigEndian));
        deviceStatus = DeviceStatus.fromStatus(NettyUtil.readShort(in, isBigEndian));
        exceptionStatus = ExceptionStatus.fromStatus(NettyUtil.readShort(in, isBigEndian));
        if(CommandType.ZERO.getStatus() ==deviceStatus.getStatus()){
            deviceStatus =DeviceStatus.fromStatus(1);
        }
        request = NettyUtil.readShort(in, isBigEndian);
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

    public int getDeviceSubType() {
        return deviceSubType;
    }

    public void setDeviceSubType(int deviceSubType) {
        this.deviceSubType = deviceSubType;
    }

    public ControlMode getControlMode() {
        return controlMode;
    }

    public void setControlMode(ControlMode controlMode) {
        this.controlMode = controlMode;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public ExceptionStatus getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(ExceptionStatus exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }
}
