package com.bgy.gateway.util;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bgy.gateway.http.HttpUtils;

/**
 * @author bean
 * 2020年12月14日
 */
public class ToolUtil {
	private static final Logger logger = LoggerFactory.getLogger(ToolUtil.class);
	public static boolean ping(String ipAddress) throws Exception {
		//超时应该在3钞以上   
		int  timeOut =  3000 ;    
        String testCheck = ipAddress;
        // 当返回值是true时，说明host是可用的，false则不可。
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut); 
        return status;
    }
	public static String StringToId(String psw) {
        {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(psw.getBytes("UTF-8"));
                byte[] encryption = md5.digest();
 
                StringBuffer strBuf = new StringBuffer();
                for (int i = 0; i < encryption.length; i++) {
                    if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    	strBuf.append("0").append(0xff & encryption[i]); 
                    } else {
                    	strBuf.append(0xff & encryption[i]); 
                    }
                } 
                return strBuf.toString();
            } catch (NoSuchAlgorithmException e) {
            	logger.error("error {}", e);
                return "";
            } catch (UnsupportedEncodingException e) {
            	logger.error("error {}", e);
                return "";
            }
        }
    } 

}
