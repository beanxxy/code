package com.bgy.gateway.model.message;

import io.netty.buffer.ByteBuf;

/**
 * 服务端接收的命令以 In 结尾
 * 服务端主动发送的命令以 Out 结尾
 * 服务端既接收又发送的命令以 InOut 结尾
 */
public abstract class AbstractMessage {

    /**
     * 以 Out 结尾【必须】要覆盖该方法
     */
    public abstract int calcLength();

    /**
     * 以 In 结尾【必须】要覆盖该方法
     */
    public abstract void decode(ByteBuf in, boolean isBigEndian);

    /**
     * 以 Out 结尾【必须】要覆盖该方法
     */
    public abstract void encode(ByteBuf out, boolean isBigEndian);

}
