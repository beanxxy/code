package com.snimay.common.access;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.google.gson.Gson;
 
/**   
 * : token加密 
 * @title      : Token.java
 * @package    : com.snimay.common.access
 * @author     : xxy
 * @date       : 2018年8月7日 上午10:14:45
 * @version    : V1.0   
 */
public class Token {
	public static String publickey ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUrkaRRJ65ZGwP7pl4MA66dngJl02DQbuZrjW89I+W+CJDoH9++3qz5JGNbNYOn3YQoVd9qR/VO4EG4b5Dw0aR1/AP79+Pmzk4A5fljXSGDOdqTgFXo0TVqYWpAuTcFKyEuUuBTuKYBJYnWl56qehBehKiPvsab9Zaajfb0eLLdQIDAQAB";
	public static String privatekey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJSuRpFEnrlkbA/umXgwDrp2eAmXTYNBu5muNbz0j5b4IkOgf377erPkkY1s1g6fdhChV32pH9U7gQbhvkPDRpHX8A/v34+bOTgDl+WNdIYM52pOAVejRNWphakC5NwUrIS5S4FO4pgElidaXnqp6EF6EqI++xpv1lpqN9vR4st1AgMBAAECgYB0sC5sFonoALua6W0DWdxFVXMyO9A24qEEpShBy0Lifo4Nu2o009PiWdIuR6vcQCReOvI6ikCUjqXeK8+yyRCZdS7m+Nix3+OVUnnhxhcitCKMSTjKPk5zR/lM0etcY5SXoV3GJWJejI9887q5o9jURsOKWwC6srCbtwczX8IihQJBAM9I1bEW5FmWn1TGHsZ2ccaNePGXZHcbfPsCofFJdCplztit7JOUxEBg/XVSmjLa1J7SSTNcA5+2CWcsf/zPovMCQQC3n5OtEHnM6yb/128raDVG6FPCsGYy9jpkweexEwAd6g9FtaNUMJEc2wjmaq4J5CEPtiQ+ufjjZCsCFY4Ol+H3AkEAt06Ny0GXRrKwzGM4LAHqs8/AOMXNDpe8eq3lUF/I3wWRWoTURd61fslG203lFzv18027djPU8JQm1JrBxGxKiQJAfGu1jeQHFBIWl+7rVhdDWmucLeSHK2rqgFFfY/3C64IonQyJwkcyXMISEscgbHVW7aV2g8ZR3gqGld/zJPJHWwJASoMAhlKFEeWINQUtjh+LCjyjUHe1JW9rxxAHFPllP52heo648ezMk3D0jRksMFPhqMzj4ARn3HJcMBsV0DgYuA==";
	static Decoder decoder = Base64.getDecoder();
	static Encoder encoder = Base64.getEncoder();
	/**
	 * 获取涉密钥匙
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	public static byte[] privatekey() {
		return decoder.decode(privatekey);
	}
	/**
	 * 获取公钥
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	public static byte[] publickey() {
		return decoder.decode(publickey);
	}
	/**
	 * 获取值
	 * @author     : xxy
	 * @param tokendata
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws
	 */
	public static String toString(TokenData tokendata) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String src = new Gson().toJson(tokendata);
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(Token.privatekey());
		KeyFactory keyFactory=KeyFactory.getInstance("RSA");
		PrivateKey privateKey=keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] result=cipher.doFinal(src.getBytes());
		return encoder.encodeToString(result);
	}
	/**
	 * 获取值
	 * @author     : xxy
	 * @param token
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws
	 */
	public static TokenData get(String token) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		byte[] result = decoder.decode(token);
		X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(Token.publickey());
		KeyFactory keyFactory=KeyFactory.getInstance("RSA");
		PublicKey publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE,publicKey);
		result=cipher.doFinal(result);
		TokenData  takendata = new Gson().fromJson(new String(result), TokenData.class);
		return takendata;
	}
}
