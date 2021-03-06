package gateway.core.imp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import gateway.core.Server;
import gateway.core.config.ServerConfig;
import gateway.core.handler.HttpHandler;
import gateway.core.model.HttpData;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
public class ServerHttp implements Server{
	public static Map<String,ServerConfig> servers = new HashMap<String,ServerConfig>();
	public static Map<String,String> server_port 	= new HashMap<String,String>(); 
	public static  Consumer<? super HttpData> action = null;
	
	public static Server create(ServerConfig address) throws InterruptedException { 
		return null;
	}
	
	public void Accept(Consumer<? super HttpData> actions) {
		ServerHttp.action = actions; 
	}
	
	/**
	 * @param address
	 * @return
	 */
	public static String getKey(ServerConfig address) {
		return address.dataAddr+":"+address.port;
	}
	
	
	@Override
	public CompletableFuture<HttpData> bind(ServerConfig address) {
		// TODO Auto-generated method stub
		if(server_port.get(address.port+"")==null) {
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
		    try {
				sb.bind(address.port).sync();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} 
		server_port.put(address.port+"", "open");
		servers.put(ServerHttp.getKey(address), address);
		return null;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

}
