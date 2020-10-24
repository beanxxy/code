package com.bgy.gateway.netty;

import com.bgy.gateway.model.message.Message;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ChannelSupervise {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelSupervise.class);


    private static ConcurrentMap<Integer, Channel> DeviceChannelMap = new ConcurrentHashMap();
    private static ConcurrentMap<String, Message> ChannelMessageMap = new ConcurrentHashMap();

    /*public static void addChannel(Channel channel, Message message){
        Integer deviceId = message.getDeviceId();
        try {
            if(!DeviceChannelMap.containsKey(deviceId)) {
                DeviceChannelMap.put(deviceId, channel);
                String channelKey = getChannelKey(channel);
                ChannelMessageMap.put(channelKey, message);
                LOGGER.info("登录设备ID：{} ,ip端口:{},消息类型 {}", deviceId, channel.remoteAddress(),message.getMessageType().getType());
            }
        }catch (Exception e){
            LOGGER.error("登录设备ID：{} ,ip端口:{},消息类型 {},发生异常 ：{}", deviceId, channel.remoteAddress(),message.getMessageType().getType(),e);
        }

    }*/

    public static void addChannel(Channel channel, Message message){
        Integer deviceId = message.getDeviceId();
        try {
            String channelKey = getChannelKey(channel);
            ChannelMessageMap.put(channelKey, message);
            DeviceChannelMap.put(deviceId, channel);
            LOGGER.info("登录设备ID：{} ,ip端口:{},消息类型 {}", deviceId, channel.remoteAddress(),message.getMessageType().getType());
        }catch (Exception e){
            LOGGER.error("登录设备ID：{} ,ip端口:{},消息类型 {},发生异常 ：{}", deviceId, channel.remoteAddress(),message.getMessageType().getType(),e);
        }

    }




    public static void removeChannel(Channel channel){
        String channelKey = getChannelKey(channel);
        Message message = ChannelMessageMap.get(channelKey);
        if(message == null) {
            return;
        }
        Integer deviceId = ChannelMessageMap.get(channelKey).getDeviceId();
        if(deviceId != null) {
            if(DeviceChannelMap.containsKey(deviceId)) {
                DeviceChannelMap.remove(deviceId);
            }
            ChannelMessageMap.remove(channelKey);
        }
    }

    public static void removeAllChannel() {
        DeviceChannelMap.clear();
        ChannelMessageMap.clear();
    }

    public static Channel getChannel(Integer deviceId) {
        return DeviceChannelMap.get(deviceId);
    }
    public static Message getLoginMessage(Channel channel) {
        String channelKey = getChannelKey(channel);
        return ChannelMessageMap.get(channelKey);
    }

    private static String getChannelKey(Channel channel) {
        return channel.id().asShortText();
    }

    public static List getLoginMessage(){
        List<Integer> deviceList = new ArrayList<>();
        for (Integer deviceId : DeviceChannelMap.keySet()){
            deviceList.add(deviceId);
       }
       return deviceList;
    }

}
