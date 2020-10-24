package com.bgy.gateway.vo;

import com.bgy.gateway.model.message.Message;
import io.netty.channel.Channel;

/**
 * @author lzx
 * @date 2020/3/14.
 */
public class ChannelMessage<T> {
    private Message message;
    private Channel channel;

    public ChannelMessage() {
    }

    public ChannelMessage(Message message, Channel channel) {
        this.message = message;
        this.channel = channel;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "ChannelMessage{" +
                "message=" + message +
                ", channel=" + channel +
                '}';
    }
}
