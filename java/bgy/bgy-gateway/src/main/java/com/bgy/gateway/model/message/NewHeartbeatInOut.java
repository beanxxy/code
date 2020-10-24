package com.bgy.gateway.model.message;

import com.bgy.gateway.enums.ControlMode;
import com.bgy.gateway.enums.DeviceStatus;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;

public class NewHeartbeatInOut extends AbstractMessage {
    private int deviceSubType;
    private ControlMode controlMode;
    private DeviceStatus deviceStatus;

    @Override
    public int calcLength() {
        return 0;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
       /* deviceSubType = NettyUtil.readShort(in, isBigEndian);
        controlMode = ControlMode.fromMode(NettyUtil.readShort(in, isBigEndian));
        deviceStatus = DeviceStatus.fromStatus(NettyUtil.readShort(in, isBigEndian));*/
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
      /*  NettyUtil.writeShort(out, isBigEndian, deviceSubType);
        NettyUtil.writeShort(out, isBigEndian, controlMode.getMode());
        NettyUtil.writeShort(out, isBigEndian, deviceStatus.getStatus());*/
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
}
