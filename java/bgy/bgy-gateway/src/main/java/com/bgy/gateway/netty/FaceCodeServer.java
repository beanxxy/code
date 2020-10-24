/*
package com.bgy.gateway.netty;

import com.bgy.gateway.netty.handler.FaceCodeInHandler;
import com.bgy.gateway.netty.handler.ScanCodeInHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

*/
/**
 * @author caijunwei
 * date 2020/1/15 11:08
 *//*

public class FaceCodeServer implements Runnable{
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    private int port;
    private boolean isBigEndian;
    private int restartSleepSeconds;

    private FaceCodeInHandler faceCodeInHandler;

    public FaceCodeServer(int port, boolean isBigEndian, int restartSleepSeconds, FaceCodeInHandler faceCodeInHandler) {
        this.port = port;
        this.isBigEndian = isBigEndian;
        this.restartSleepSeconds = restartSleepSeconds;
        this.faceCodeInHandler = faceCodeInHandler;
    }

    @Override
    public void run() {
        bind();
    }

    private void bind() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            //字符串类解析
                            // ByteBuf delimiter = Unpooled.copiedBuffer("\r\n".getBytes());
                            ByteBuf delimiter = Unpooled.copiedBuffer("$$".getBytes());
                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, true, delimiter));
                            ch.pipeline().addLast(new StringEncoder());
                            ch.pipeline().addLast(new IdleStateHandler(0, 0, 300), faceCodeInHandler);
                        }
                    });

            ChannelFuture future = b.bind(port).sync();
            LOGGER.info("服务启动，端口：{}，{}", port, "机械表情端");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            LOGGER.error("服务异常关闭，端口：" + port, e);
            ChannelSupervise.removeAllChannel();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();

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
*/
