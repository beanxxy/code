package com.bgy.gateway.model.message.steam;

import com.bgy.gateway.model.message.AbstractMessage;
import com.bgy.gateway.util.NettyUtil;
import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzx
 * @date 2020/3/14.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteamDoorUpDownOut extends AbstractMessage {
    /**
     * 命令类型
     */
    private int command;
    /**
     * 类型
     */
    private int type;
    /**
     * 层数
     */
    private int layer;

    /**
     * 设备id
     */
    private int deviceId;

    @Override
    public int calcLength() {
        return 6;
    }

    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {

    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        NettyUtil.writeShort(out, isBigEndian, command);
        NettyUtil.writeShort(out, isBigEndian, layer);
        NettyUtil.writeShort(out, isBigEndian, type);
    }


}
