package com.bgy.gateway.netty.handler;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.util.NettyUtil;
import com.bgy.gateway.util.TaskUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageEncoder extends MessageToByteEncoder<Message> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageEncoder.class);

    private boolean isBigEndian;

    public MessageEncoder(boolean isBigEndian) {
        this.isBigEndian = isBigEndian;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
       if(TaskUtil.isHeartLog()){
           LOGGER.info("服务端发送：{}", msg);
       }else{
           if( msg.getMessageType().getType()!= CommandType.THREE.getStatus()){
               LOGGER.info("服务端发送：{}", msg);
           }
       }
        NettyUtil.writeShort(out, isBigEndian, msg.getHeader());
        NettyUtil.writeShort(out, isBigEndian, msg.getDataLength());
        NettyUtil.writeShort(out, isBigEndian, msg.getMessageType().getType());
        NettyUtil.writeShort(out, isBigEndian, msg.getUniqueKey());
        NettyUtil.writeShort(out, isBigEndian, msg.getDeviceType().getType());
        NettyUtil.writeShort(out, isBigEndian, msg.getDeviceId());

        if(msg.getExtraData() != null) {
            msg.getExtraData().encode(out, isBigEndian);
        }

        if(LOGGER.isInfoEnabled()) {
            byte[] bytes = new byte[out.readableBytes()];
            out.getBytes(out.readerIndex(), bytes);
            if(TaskUtil.isHeartLog()){
                LOGGER.info("发送报文：{}", NettyUtil.bytesToHexString(bytes));
            }else{
                if( msg.getMessageType().getType()!=CommandType.THREE.getStatus()) {
                    LOGGER.info("发送报文：{}", NettyUtil.bytesToHexString(bytes));
                }
            }
        }
    }
}
