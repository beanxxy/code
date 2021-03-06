package com.bgy.gateway.util;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Logger;


/**
 * @author bean
 * 2020年12月14日
 */
public class LittleByteUtil {
	static Logger logger = Logger.getLogger(LittleByteUtil.class.getName());
	
	static final long fx = 0xff;
	/**
	 * short ת byte[]
	 * 转换
	 * @param data
	 * @return
	 */
	public static byte[] getShortBytes(short data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data & fx);
		bytes[1] = (byte) ((data >> 8) & fx);
		return bytes;
	}

	/**
	 * chart ת byte[]
	 * 转换
	 * @param data
	 * @return
	 */
	public static byte[] getCharBytes(char data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data & fx);
		bytes[1] = (byte) ((data >> 8) & fx);
		return bytes;
	}

	/**
	 * int ת byte[]
	 * 转换
	 * @param data
	 * @return
	 */
	public static byte[] getIntBytes(int data) {
		int length = 4;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = (byte) ((data >> (i*8)) & fx);
		}
		return bytes;
	}

	/**
	 * long ת byte[]
	 * 转换
	 * @param data
	 * @return
	 */
	public static byte[] getLongBytes(long data) {
		int length = 8;
		byte[] bytes = new byte[length];
		
		for (int i = 0; i < length; i++) {
			bytes[i] = (byte) ((data >> (i*8)) & fx);
		}
		return bytes;
	}

	/**
	 * float ת byte[]
	 * 转换
	 * @param data
	 * @return
	 */
	public static byte[] getFloatBytes(float data) {
		int intBits = Float.floatToIntBits(data);

		byte[] bytes = getIntBytes(intBits);
		
		return bytes;
	}

	/**
	 * double ת byte[]
	 * 转换
	 * @param data
	 * @return
	 */
	public static byte[] getDoubleBytes(double data) {
		long intBits = Double.doubleToLongBits(data);
		byte[] bytes = getLongBytes(intBits);
		return bytes;
	}

	/**
	 * String ת byte[]
	 * 转换
	 * @param data
	 * @param charsetName
	 * @return
	 */
	public static byte[] getStringBytes(String data, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		byte[] bytes = data.getBytes(charset);
		return bytes;
	}

	/**
	 * String ת byte[]
	 * 转换
	 * @param data
	 * @return
	 */
	public static byte[] getStringBytes(String data) {
		byte[] bytes = null;
		if(data != null){
			bytes = data.getBytes();
		}else{
			bytes = new byte[0];
		}
		return bytes;
	}

	/**
	 * byte[] תshort
	 * С��
	 * @param bytes
	 * @return
	 */
	public static short getShort(byte[] bytes) { 
		short result = (short) ((fx & bytes[0])
				| ((fx & bytes[1]) << 8));
		
		return result;
	}

	/**
	 * byte[] ת char
	 * 转换
	 * @param bytes
	 * @return
	 */
	public static char getChar(byte[] bytes) {
		char result = (char) ((fx & bytes[0])
				| ((fx & bytes[1]) << 8));
		return result;
	}

	/**
	 * byte[] ת int
	 * 转换
	 * @param bytes
	 * @return
	 */
	public static int getInt(byte[] bytes) {
		int result = (int) ((fx & bytes[0])
			| ((fx & bytes[1]) << 8)
			| ((fx & bytes[2]) << 16)
			| ((fx & bytes[3]) << 24));
		
		return result;
	}

	/**
	 * byte[] ת long
	 * 转换
	 * @param bytes
	 * @return
	 */
	public static long getLong(byte[] bytes) {
		long result = fx & bytes[0]
				| (fx & bytes[1]) << 8
				| (fx & bytes[2]) << 16
				| (fx & bytes[3]) << 24
				| (fx & bytes[4]) << 32
				| (fx & bytes[5]) << 40
				| (fx & bytes[6]) << 48
				| (fx & bytes[7]) << 56;
		
		return result;
	}

	/**
	 * byte[] ת float
	 * 转换
	 * @param bytes
	 * @return
	 */
	public static float getFloat(byte[] b) {
		int l = getInt(b);
		return Float.intBitsToFloat(l);
	}

	/**
	 * byte[] ת double
	 * 
	 * @param bytes
	 * @return
	 */
	public static double getDouble(byte[] bytes) {
		
		long l = getLong(bytes);
		return Double.longBitsToDouble(l);
	}

	/**
	 * byte[] ת String
	 * 转换
	 * @param bytes
	 * @param charsetName
	 * @return
	 */
	public static String getString(byte[] bytes, String charsetName) {
		String result = new String(bytes, Charset.forName(charsetName));
		return result;
	}

	/**
	 * byte[] ת String
	 * 
	 * @param bytes
	 * @return
	 */
	public static String getString(byte[] bytes) {
		String result = new String(bytes);
		return result;
	}

	/**
	 * 转换
	 * 
	 * @param target
	 * @param append
	 * @return
	 */
	public static byte[] appendByte(byte[] target, byte[] append) {
		int originalLength = target.length;
		int appendLength = append.length; 
		int totalLength = originalLength + appendLength; 
		target = Arrays.copyOf(target, totalLength); 
		System.arraycopy(append, 0, target, originalLength, appendLength); 
		return target;
	}
	
 
}