package com.vsdata.melsec.message;

import io.netty.buffer.ByteBuf;

/**
 * @author xxybean
 */
public interface Principal extends BinaryCodec {

    void setAddress(String address);

    String getAddress();

    void setRealAddress(String realAddress);

    String getRealAddress();

    void setPoints(int points);

    int getPoints();

    void setDevice(Device device);

    Device getDevice();

    void setFunction(Function function);

    Function getFunction();

    void setSubcommand(int subcommand);

    int getSubcommand();

    void setData(ByteBuf data);

    ByteBuf getData();
}
