package gateway.core;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bean
 * 2020年11月14日
 */
public interface Client {
	/**
	 * 数据模型
	 */
	public static Map<String,List<DataModel>> datamap 	= new ConcurrentHashMap<String,List<DataModel>>();
	/**
	 * 输入，当值改变时调用change
	 * @param info
	 */
	void read(Ioinfo info);
	/**
	 * 写入
	 * @param iofo
	 * @param value
	 */
	void write(Ioinfo iofo,String value);
}
