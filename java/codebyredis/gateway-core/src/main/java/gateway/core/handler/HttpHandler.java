package gateway.core.handler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.google.gson.Gson;

import gateway.core.imp.ServerHttp;
import gateway.core.model.HttpData;
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
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.util.CharsetUtil;

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
        //System.out.println(ctx.channel().remoteAddress());
    	//System.out.println("class:" + msg.getClass().getName());
    	Map<String,String> map = new HashMap(); 
    	map.put("code","0");
    	map.put("message","成功接收!");
    	map.put("data","");
		 Gson gson = new Gson();
    	String sjosn = gson.toJson(map);
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1
            ,HttpResponseStatus.OK
            ,Unpooled.wrappedBuffer(sjosn.getBytes())); // 2 
        HttpHeaders heads = response.headers();
        heads.add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN + "; charset=UTF-8");
        heads.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes()); // 3
        heads.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
         
        this.add(ctx,msg);
        //DeviceChannelMap.put(addr, ctx.channel());
        HttpData httpdata 	= new HttpData();
        String path			= msg.uri(); 
        httpdata.data 		= msg.content().toString(CharsetUtil.UTF_8);
        httpdata.method 	= msg.method().name(); 
        httpdata.port 	  	= msg.headers().get("Host").split(":")[1]; 
        httpdata.url		= path; 
        //System.out.println(ServerHttp.future.complete(httpdata));  
        //ServerHttp.future.getNow(httpdata);
        ServerHttp.action.accept(httpdata);
        //System.out.println("===========");
        //System.out.println("method:" + method);
        //System.out.println("path:"+path);
        //System.out.println("Params:"+this.getRequestParams(msg));
        //System.out.println(msg.content().toString(CharsetUtil.UTF_8));
        //System.out.println("cone:"+new String(msg.content().array()));
        //Thread.sleep(1000); 
        
        ctx.write(response);
    } 
    private Map<String, Object> getRequestParams(FullHttpRequest request) {
        HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), request);
        List<InterfaceHttpData> httpPostData = decoder.getBodyHttpDatas();
        Map<String, Object> params = new HashMap<>();

        for (InterfaceHttpData data : httpPostData) {
            if (data.getHttpDataType() == InterfaceHttpData.HttpDataType.Attribute) {
                MemoryAttribute attribute = (MemoryAttribute) data;
                params.put(attribute.getName(), attribute.getValue());
            }
        }
        return params;
    }
    protected void add(ChannelHandlerContext ctx,FullHttpRequest msg) {
    	 /*String 							addr  = Tool.getAddress(msg); 
    	 BlockingQueue<ChannelHandlerContext> bl  = DeviceChannelMap.get(addr);
         if(bl == null)						  bl  = new LinkedBlockingQueue<ChannelHandlerContext>(); 
         bl.add(ctx); 
         DeviceChannelMap.put(addr, bl);*/
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    	//System.out.println("channelReadComplete");
        super.channelReadComplete(ctx);
        ctx.flush(); // 4
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    	//System.out.println("exceptionCaught");
        if(null != cause) cause.printStackTrace();
        if(null != ctx) ctx.close();
    }
 
}