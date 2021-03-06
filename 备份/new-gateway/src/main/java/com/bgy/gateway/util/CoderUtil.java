package com.bgy.gateway.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test; 
import com.bgy.gateway.enums.DataTypeEnum;
import com.bgy.gateway.enums.EndianEnum;
import com.bgy.gateway.model.vo.DataModelVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * json => 数据块
 * 数据块 => json
 * @author bean
 * date 2020年12月1日
 */
public class CoderUtil {  
	
	
	public static Map<Integer,DataTypeEnum> DataTypeEnumMap = new ConcurrentHashMap<Integer,DataTypeEnum>(); 
	public static Map<Integer,EndianEnum> EndianEnumEnumMap = new ConcurrentHashMap<Integer,EndianEnum>(); 
	
	static {
		for (EndianEnum e : EndianEnum.values()) { 
			EndianEnumEnumMap.put(e.getIndex(), e);
		} 
		for (DataTypeEnum e : DataTypeEnum.values()) { 
			DataTypeEnumMap.put(e.getIndex(), e);
		}
	} 
	 
	
	/**
	 * 大小端转义
	 * @param bytes
	 * @return
	 */
	public static byte[] endian(byte[] bytes,EndianEnum endianEnum) { 
		switch(endianEnum) {
		case ABCD:
			return bytes; 
		case BADC:
			for(int i=0;i<bytes.length;i+=1) {
				byte t = bytes[i];
				int tmp = t & 0xff;
				int a = (tmp >> 4);
				int b = (tmp << 4);  
				bytes[i]= (byte) (a | b) ;
			}
			return bytes; 
		case CDAB:
			for(int i=0;i<bytes.length;i+=4) {
				if(i+3 < bytes.length) {
					byte t0		= bytes[i];
					byte t1		= bytes[i+1]; 
					bytes[i]	= bytes[i+2];
					bytes[i+1]	= bytes[i+3];
					bytes[i+2]  = t0;
					bytes[i+3]  = t1;	
				} 
			}
			return bytes; 
		case DCBA:
			bytes = endian(bytes,EndianEnum.CDAB);
			bytes = endian(bytes,EndianEnum.BADC);
			return bytes; 
		default:
			return bytes;
		} 
	}
	/**
	 * @param Byt 数据块
	 * @param arrayDataModelVo 数据模型
	 * @return
	 */
	public static String decode(byte[] Byte,List<DataModelVO> arrayDataModelVo,int endianEnum) {
		return decode(Byte,arrayDataModelVo,EndianEnumEnumMap.get(endianEnum));
	}
	/**
	 * @param Byt 数据块
	 * @param arrayDataModelVo 数据模型
	 * @return
	 */
	public static String decode(byte[] Byt,List<DataModelVO> arrayDataModelVo,EndianEnum endianEnum) {
		// 排序
		arrayDataModelVo.sort(Comparator.comparing(DataModelVO::getSort));
		// 工具封装
		ByteBuf bytebuf = Unpooled.copiedBuffer(endian(Byt,endianEnum));
		// 数据
		Map<String,String> datavalue = new HashMap<String,String>();
		// 遍历 
		for(DataModelVO datamodel : arrayDataModelVo){ 
			switch(DataTypeEnumMap.get(datamodel.getDataType())) {
			case BIT:
			case BOOL:
				datavalue.put(datamodel.getName(), bytebuf.readBoolean()?"1":"0"); 
				break;
			case INT:
			case WORD:
				datavalue.put(datamodel.getName(), bytebuf.readInt()+""); 
				break;  
			case CHAR:
				datavalue.put(datamodel.getName(), bytebuf.readChar()+""); 
				break; 
			case FLOAT:
			case REAL:
				datavalue.put(datamodel.getName(), bytebuf.readFloat()+""); 
				break; 
			case SHORT:
				datavalue.put(datamodel.getName(), bytebuf.readShort()+""); 
				break;
			case DINT:
			case LONG:
				datavalue.put(datamodel.getName(), bytebuf.readLong()+""); 
				break;	
			case DOUBLE:
			case DREAL:
				datavalue.put(datamodel.getName(), bytebuf.readDouble()+""); 
				break;	
			case UNSIGNEDSHORT:
				datavalue.put(datamodel.getName(), bytebuf.readUnsignedShort()+""); 
				break;	
			case UNSIGNEDINT:
				datavalue.put(datamodel.getName(), bytebuf.readUnsignedInt()+""); 
				break;	
			case UNSIGNEDBYTE:
				datavalue.put(datamodel.getName(), bytebuf.readUnsignedByte()+""); 
				break;	
			default:
				datavalue.put(datamodel.getName(), new String(bytebuf.array())+""); 
				break;	
			}
		}
		return new Gson().toJson(datavalue);
	} 

	/**
	 * @param json	数据
	 * @param arrayDataModelVo 数据模型
	 * @return
	 */
	public static byte[] encode(String json,List<DataModelVO> arrayDataModelVo,int endianEnum) {
		return encode(json,arrayDataModelVo,EndianEnumEnumMap.get(endianEnum));
	}
	/**
	 * @param json	数据
	 * @param arrayDataModelVo 数据模型
	 * @return
	 */
	public static byte[] encode(String json,List<DataModelVO> arrayDataModelVo,EndianEnum endianEnum) {
		//排序
		arrayDataModelVo.sort(Comparator.comparing(DataModelVO::getSort));
		int datalangth = 0;
		Map<String,String> datavalue = new Gson().fromJson(json,new TypeToken<Map<String,String>>(){}.getType());
		//遍历
		for(DataModelVO datamodel : arrayDataModelVo){ 
			datalangth += datamodel.getLength(); 
		}
		// 工具封装 位转换字节
		ByteBuf bytebuf = Unpooled.buffer((datalangth / 8)+(datalangth % 8 == 0 ?0:1));
		// 遍历
		for(DataModelVO datamodel : arrayDataModelVo){ 
			String value = datavalue.get(datamodel.getName());  
			switch(DataTypeEnumMap.get(datamodel.getDataType())) {
			case BIT:
			case BOOL:
				if(value.equals("1")) {
					bytebuf.writeBoolean(true);
				}else {
					bytebuf.writeBoolean(false);
				}
				break;
			case INT:
			case WORD:
				int ivalue = Integer.parseInt(value);
				bytebuf.writeInt(ivalue);
				break;  
			case CHAR:
				bytebuf.writeChar(value.charAt(0)); 
				break; 
			case FLOAT:
			case REAL:
				float Floatvalue = Float.parseFloat(value);
				bytebuf.writeFloat(Floatvalue); 
				break; 
			case SHORT:
				short svalue = Short.parseShort(value);
				bytebuf.writeShort(svalue); 
				break;
			case DINT:
			case LONG:
				long lg = Long.parseLong(value);
				bytebuf.writeLong(lg);  
				break;	
			case DOUBLE:
			case DREAL:
				double db = Double.parseDouble(value);
				bytebuf.writeDouble(db);  
				break;	
			case UNSIGNEDSHORT:
				int iv = Integer.parseInt(value);
				bytebuf.writeShort((char)iv);
				break;	
			case UNSIGNEDINT:
				int nint = Integer.parseInt(value);
				bytebuf.writeInt(nint & 0xffff);
				break;	
			case UNSIGNEDBYTE:
				int byt = Integer.parseInt(value);
				bytebuf.writeByte((char)byt);
				break;
			default:
				bytebuf.writeBytes(value.getBytes());
				break;	
			}
		} 
		return endian(bytebuf.array(),endianEnum);
	}
}
