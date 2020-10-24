package com.bgy.gateway.netty;

import com.bgy.gateway.netty.handler.MessageDecoder;
import com.bgy.gateway.netty.handler.MessageEncoder;
import com.bgy.gateway.netty.handler.MessageHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteOrder;
import java.util.concurrent.TimeUnit;

public class Server implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    private int port;
    private boolean isBigEndian;
    private int restartSleepSeconds;
    private MessageHandler messageHandler;
    private String version;

    public Server(int port, boolean isBigEndian, int restartSleepSeconds, MessageHandler messageHandler,String version) {
        this.port = port;
        this.isBigEndian = isBigEndian;
        this.restartSleepSeconds = restartSleepSeconds;
        this.messageHandler = messageHandler;
        this.version = version;
    }

    @Override
    public void run() {
        bind();
    }

    private void bind() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast("frame",
                                    new LengthFieldBasedFrameDecoder(isBigEndian ?  ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN,
                                            1024 * 2, 2, 2, -4, 0, true));
                            channel.pipeline().addLast("encoder", new MessageEncoder(isBigEndian));
                            channel.pipeline().addLast("decoder", new MessageDecoder(isBigEndian,version));
                            channel.pipeline().addLast("message", messageHandler);
                        }
                    });
            ChannelFuture future = serverBootstrap.bind(port).sync();
            //ChannelFuture future = serverBootstrap.bind("172.16.255.120",9002).sync();
            LOGGER.info("服务启动，端口：{}，{}", port, isBigEndian ? "大端" : "小端");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            LOGGER.error("服务异常关闭，端口：" + port, e);
            ChannelSupervise.removeAllChannel();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            LOGGER.error("服务异常关闭");
            try {
                TimeUnit.SECONDS.sleep(restartSleepSeconds);
                LOGGER.info("服务重新启动，端口：", port);
                bind();
            } catch (Exception e) {
                LOGGER.error("重启服务异常，端口：" + port, e);
            }
        }
    }
}
