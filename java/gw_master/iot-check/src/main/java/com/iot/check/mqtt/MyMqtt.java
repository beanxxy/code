package com.iot.check.mqtt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.yaml.snakeyaml.Yaml;

public class MyMqtt {
    private static String host = "tcp://localhost:61613";
    private static String userName = "admin";
    private static String passWord = "password";
    private MqttClient client;
    private static String id;
    private static MyMqtt instance; // = new MyMqtt();
    private MqttTopic mqttTopic;
    private static String myTopic = "Topics/htjs/serverToPhone";
    private MqttMessage message;
    public MyMqtt() { 
        this(null, false);
   
    }
    public static void init() {
    	try { 
    		Yaml yaml = new Yaml();
    		InputStream inputStream = Resources.getResourceAsStream("app.yaml"); 
    		Map<String, Object> map = (Map<String, Object>) yaml.loadAs(inputStream, Map.class).get("mqtt"); 
    		host = map.get("host")+"";
    		userName = map.get("username")+"";
    		passWord = map.get("password")+"";
    		myTopic  = map.get("tcpic1")+"";
    		id		  = map.get("clientid")+"";    		
    	}catch(IOException e) {
    		
    	}
    }
    static {
    	init();
    }
    
    public MyMqtt(MqttCallback callback, boolean cleanSession){
        
        try {
             //id应该保持唯一性
            client = new MqttClient(host, id, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(cleanSession);
            options.setUserName(userName);
            options.setPassword(passWord.toCharArray());
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);
            if (callback == null) {
                client.setCallback(new MqttCallback() {
    
                    public void connectionLost(Throwable arg0) {
                         
                    }
    
                    public void deliveryComplete(IMqttDeliveryToken arg0) {
                        
                    }
    
                    public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
                         
                    }
                });
            } else {
                client.setCallback(callback);
            }
            client.connect(options);
        } catch (MqttException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String msg) throws MqttException, Exception {
        sendMessage(myTopic, msg);
    }
    
    public void sendMessage(String topic, String msg) throws Exception, MqttException{
         
    	message = new MqttMessage(); 
        message.setQos(0);
        message.setRetained(false); 
        message.setPayload(msg.getBytes()); 
        mqttTopic = client.getTopic(topic); 
        mqttTopic.publish(message);
           // MqttDeliveryToken token = mqttTopic.publish(message);//发布主题
           // token.waitForCompletion(1000);
            
         
    }
    
    public void subscribe(String[] topicFilters, int[] qos) {
        try {
            client.subscribe(topicFilters, qos);
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// 订阅主题

    }
    
}