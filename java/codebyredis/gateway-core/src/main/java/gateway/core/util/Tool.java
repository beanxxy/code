package gateway.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tool {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StringToId("上菜口ioi").substring(32));
	}

}
