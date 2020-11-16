package com.snimay.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**   
 * : ip获取 
 * @title      : Ip.java
 * @package    : com.snimay.common
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:15:20
 * @version    : V1.0   
 */
public class Ip {
	public static String toString(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
	/**
     * 获取来访者的浏览器版本
     * @param request
     * @return
     */
    public static String getRequestBrowserInfo(HttpServletRequest request){
		String browserVersion = null;
		String header = request.getHeader("user-agent");
		if(header == null || header.equals("")){
		   return "";
		 }
        if(header.indexOf("MSIE")>0){
            browserVersion = "IE";
        }else if(header.indexOf("Firefox")>0){
            browserVersion = "Firefox";
        }else if(header.indexOf("Chrome")>0){
            browserVersion = "Chrome";
        }else if(header.indexOf("Safari")>0){
            browserVersion = "Safari";
        }else if(header.indexOf("Camino")>0){
            browserVersion = "Camino";
        }else if(header.indexOf("Konqueror")>0){
            browserVersion = "Konqueror";
        }
        return browserVersion;
    }

    /**
     * 获取系统版本信息
     * @param request
     * @return
     */
    public static String getRequestSystemInfo(HttpServletRequest request){
	  String systenInfo = null;
	  String header = request.getHeader("user-agent");
	  if(header == null || header.equals("")){
	   return "";
	  }
        //得到用户的操作系统
        if (header.indexOf("NT 6.0") > 0){
            systenInfo = "Windows Vista/Server 2008";
        } else if (header.indexOf("NT 5.2") > 0){
            systenInfo = "Windows Server 2003";
        } else if (header.indexOf("NT 5.1") > 0){
            systenInfo = "Windows XP";
        } else if (header.indexOf("NT 6.0") > 0){
            systenInfo = "Windows Vista";
        } else if (header.indexOf("NT 6.1") > 0){
            systenInfo = "Windows 7";
        } else if (header.indexOf("NT 6.2") > 0){
            systenInfo = "Windows Slate";
        } else if (header.indexOf("NT 6.3") > 0){
            systenInfo = "Windows 9";
        } else if (header.indexOf("NT 5") > 0){
            systenInfo = "Windows 2000";
        } else if (header.indexOf("NT 4") > 0){
            systenInfo = "Windows NT4";
        } else if (header.indexOf("Me") > 0){
            systenInfo = "Windows Me";
        } else if (header.indexOf("98") > 0){
            systenInfo = "Windows 98";
        } else if (header.indexOf("95") > 0){
            systenInfo = "Windows 95";
        } else if (header.indexOf("Mac") > 0){
            systenInfo = "Mac";
        } else if (header.indexOf("Unix") > 0){
            systenInfo = "UNIX";
        } else if (header.indexOf("Linux") > 0){
            systenInfo = "Linux";
        } else if (header.indexOf("SunOS") > 0){
            systenInfo = "SunOS";
        }
        return systenInfo;
	 }
    
    /**
     * 获取来访者的主机名称
     * @param ip
     * @return
     */
    public static String getHostName(String ip){
    	InetAddress inet;
    	try {
			inet = InetAddress.getByName(ip);
			return inet.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	return "";
    } 
}
