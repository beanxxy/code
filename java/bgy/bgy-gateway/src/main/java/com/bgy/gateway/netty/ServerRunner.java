package com.bgy.gateway.netty;
import com.bgy.gateway.netty.handler.MessageHandler;
import com.bgy.gateway.netty.handler.ScanCodeInHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("gateway")
public class ServerRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerRunner.class);

    @Value("${gateway.ports}")
    private String ports;
    @Value("${gateway.byte-orders}")
    private String byteOrders;
    @Value("${gateway.restart-sleep-seconds}")
    private int restartSleepSeconds;

    @Value("${gateway.version}")
    private String version;

    @Autowired
    private MessageHandler messageHandler;

    @Autowired
    private ScanCodeInHandler scanCodeInHandler;


    @Override
    public void run(String... args) throws Exception {
        String[] portArray = ports.split(",");
        String[] byteOrderArray = byteOrders.split(",");

        for(int i = 0; i < portArray.length; i++) {
            int port = Integer.valueOf(portArray[i]);
            boolean isBigEndian = byteOrderArray[i].toLowerCase().equals("1") ? true : false;
            if(port==9000){
                new Thread(new ScanCodeServer(port, isBigEndian, restartSleepSeconds, scanCodeInHandler),
                        "port-" + port).start();
            } else {
                //if(port ==9002){
                    new Thread(new Server(port, isBigEndian, restartSleepSeconds, messageHandler,version),
                            "port-" + port).start();
               //}

            }

        }
    }

}
