import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import gateway.core.mqtt.MyMqtt;

public class mqtt {
	public static void main(String arg[]) {
		MyMqtt qt = new MyMqtt(new MqttCallback() {
		    
            @Override
            public void connectionLost(Throwable arg0) {
                // TODO 自动生成的方法存根
                System.out.println(  " connectionLost " + arg0);
            } 
            @Override
            public void deliveryComplete(IMqttDeliveryToken arg0) {
                // TODO 自动生成的方法存根
                //System.out.println(  " deliveryComplete " + arg0);
            } 
            @Override
            public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
                // TODO 自动生成的方法存根
            	String msg = new String(arg1.getPayload());
                System.out.println(arg0+  " messageArrived: " + msg+"xx"+ arg1.getId());
                arg1.clearPayload();
                
                //qt.u
                //qt.unsubscribe(arg0);
            }
        },false); 
		//qt.sendMessage("xxx");
		String[] arrstr = new String[] { "test" };
		int[] arri = new int[] {0};
		qt.subscribe(arrstr, arri); 
		qt.sendMessage("test1","12312312");
	}
}