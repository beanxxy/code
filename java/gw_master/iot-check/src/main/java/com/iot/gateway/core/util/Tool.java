package com.iot.gateway.core.util;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import com.iot.check.AlarmEvent;
import com.iot.check.Star;

/**
 * @author bean
 *
 */
public class Tool {
	static Logger logger = Logger.getLogger(Tool.class.getName());
	public static boolean ping(String ipAddress) throws Exception {
		//超时应该在3钞以上     
        int  timeOut =  3000 ;   
        // 当返回值是true时，说明host是可用的，false则不可。
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);      
        if(Star.debug)logger.info("ping:"+ipAddress+":"+status);
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
                        //strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                    } else {
                    	strBuf.append(0xff & encryption[i]);
                        //strBuf.append(Integer.toHexString(0xff & encryption[i]));
                    }
                }
 
                return strBuf.toString();
            } catch (NoSuchAlgorithmException e) {
                return "";
            } catch (UnsupportedEncodingException e) {
                return "";
            }
        }
    } 

}
