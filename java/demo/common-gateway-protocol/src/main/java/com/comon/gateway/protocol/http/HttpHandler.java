package com.comon.gateway.protocol.http;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

/**
 * @author bean
 * 2020年9月25日
 */
public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> { // 1

  
    /**
     **接入排队队列 
     */
    //private static BlockingQueue<Channel> basket = new LinkedBlockingQueue<Channel>();
    /**
     **同一个接口下的不同入口地址
     */
    public static ConcurrentMap<String, BlockingQueue<ChannelHandlerContext>> DeviceChannelMap = new ConcurrentHashMap();
    public static ConcurrentMap<String, BlockingQueue<FullHttpRequest>>   DeviceHttpRequestMap = new ConcurrentHashMap();
    /**
     **接入
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
    	System.out.println("class:" + msg.getClass().getName());
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1
            ,HttpResponseStatus.OK
            ,Unpooled.wrappedBuffer("test".getBytes())); // 2 
        HttpHeaders heads = response.headers();
        heads.add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN + "; charset=UTF-8");
        heads.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes()); // 3
        heads.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
         
        this.add(ctx,msg);
        //DeviceChannelMap.put(addr, ctx.channel());
        //String method 	= msg.method().name();
        //String path		= msg.uri(); 
        //System.out.println("method:" + method);
        //System.out.println("path:");
        //Thread.sleep(1000); 
        ctx.write(response);
    }
    protected void add(ChannelHandlerContext ctx,FullHttpRequest msg) {
    	 String 							addr  = Tool.getAddress(msg); 
    	 BlockingQueue<ChannelHandlerContext> bl  = DeviceChannelMap.get(addr);
         if(bl == null)						  bl  = new LinkedBlockingQueue<ChannelHandlerContext>(); 
         bl.add(ctx); 
         DeviceChannelMap.put(addr, bl);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    	System.out.println("channelReadComplete");
        super.channelReadComplete(ctx);
        ctx.flush(); // 4
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    	System.out.println("exceptionCaught");
        if(null != cause) cause.printStackTrace();
        if(null != ctx) ctx.close();
    }
 
}