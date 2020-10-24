package com.bgy.gateway.service;

import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.RequestMessageIn;

import java.util.List;

public interface KafkaService {

    //void pushToDeviceSystem(Message<RequestMessageIn> msg);
   // void pushToDeviceSystem(Message<RequestMessageIn> msg, List<Integer> errorList);

    void pushToInside(String topic, Object obj);
}
