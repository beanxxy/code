package com.bgy.gateway.model.message.steam;

import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import io.netty.buffer.ByteBuf;

/**
 * @author lzx
 * @date 2020/3/14.
 */
public class SteamCageAssemblyOut extends AbstractMessage {
    /**
     * 命令类型
     */
    private int command;
    /**
     * 任务id
     */
    private Long missionId;
    /**
     * 层数
     */
    private int layer;

    /**
     * 设备id
     */
    private int deviceId;

    public SteamCageAssemblyOut() {
    }

    public SteamCageAssemblyOut(int command, Long missionId, int layer) {
        this.command = command;
        this.missionId = missionId;
        this.layer = layer;
    }

    public SteamCageAssemblyOut(int command, Long missionId, int layer, int deviceId) {
        this.command = command;
        this.missionId = missionId;
        this.layer = layer;
        this.deviceId = deviceId;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "SteamCageAssemblyDto{" +
                "command=" + command +
                ", missionId=" + missionId +
                ", layer=" + layer +
                ", deviceId=" + deviceId +
                '}';
    }

    @Override
    public int calcLength() {
        return 12;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {

    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        NettyUtil.writeShort(out, isBigEndian, command);
        NettyUtil.writeLong(out, isBigEndian, missionId);
        NettyUtil.writeShort(out, isBigEndian, layer);
    }
}
