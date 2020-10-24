package com.comon.gateway.protocol.http;

import java.util.Map; 

import com.comon.gateway.protocol.Std;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 **实现HTTP
 * @author bean
 *
 */
public class HttpServer implements Std{

	@Override
	public void start(int port, String id) throws Exception {
		// TODO Auto-generated method stub
		ServerBootstrap sb = new ServerBootstrap();
	    NioEventLoopGroup group = new NioEventLoopGroup();
	    sb.group(group)
		    .channel(NioServerSocketChannel.class)
		    .childHandler(new ChannelInitializer<SocketChannel>() {
		        @Override
		        public void initChannel(SocketChannel ch)throws Exception {
		            //System.out.println("initChannel ch:" + ch);
		            ch.pipeline()
		                .addLast("decoder", new HttpRequestDecoder())   				// 1
		                .addLast("encoder", new HttpResponseEncoder())  				// 2
		                .addLast("aggregator", new HttpObjectAggregator(512 * 1024))    // 3
		                .addLast("handler", new HttpHandler());        					// 4
		        }
		    })
		    .option(ChannelOption.SO_BACKLOG, 128) // determining the number of connections queued
		    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
	    sb.bind(port).sync();
	}

	@Override
	public Map read() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void write(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
