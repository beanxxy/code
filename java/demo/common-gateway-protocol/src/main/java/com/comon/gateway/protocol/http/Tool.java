package com.comon.gateway.protocol.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;

/**
 * @author bean
 * 2020年9月25日
 */
public class Tool { 
	/**
	 **获取数据
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getRequestParams(FullHttpRequest request) {
	    HttpPostRequestDecoder decoder 			= new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), request); 
	    List<InterfaceHttpData> httpPostData 	= decoder.getBodyHttpDatas();
	    Map<String, Object> params = new HashMap<>(); 
	    for (InterfaceHttpData data : httpPostData) {
	        //if (data.getHttpDataType() == InterfaceHttpData.HttpDataType.Attribute) {
	        MemoryAttribute attribute = (MemoryAttribute) data;
	        params.put(attribute.getName(), attribute.getValue());
	        //}
	    } 
	    String url 	  =	request.uri().split("\\?")[0]; 
	    String method = request.method().toString();
	    String port	  = request.headers().get("Host");
	    
	    params.put("@port",port.split(":")[1]);
	    params.put("@url",url);
	    params.put("@method",method); 
	    return params;
	}
	public static String getAddress(FullHttpRequest msg) {
		//ByteBuf buf = msg.content();
		Tool.println(Tool.getRequestParams(msg));
		Map map = Tool.getRequestParams(msg);
		return ""+map.get("@port")+map.get("method")+map.get("@url");
	}
	
	/**
	 **查看
	 * @param map
	 */
	public static void println(Map<String, Object> map) {
		for(Map.Entry<String, Object> entry : map.entrySet()){
		    String mapKey = entry.getKey();
		    String mapValue = (String) entry.getValue();
		    System.out.println(mapKey+":"+mapValue);
		}
	}
}
