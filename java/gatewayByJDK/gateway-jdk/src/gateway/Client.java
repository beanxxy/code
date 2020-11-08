package gateway; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import gateway.config.DataModel;
import gateway.config.Ioinfo;
 
/**
 * @author bean
 * 2020年10月15日 
 */
public interface Client {
	public static Map<String,List<DataModel>> datamap 	= new HashMap<String,List<DataModel>>();
	/**
	 * 创建
	 * 
	 * @param address
	 * @return
	 */
	public static Client create(Ioinfo address) {
		return null;
	}
	
	/**
     *  读取
     *
     * @param address  地址ַ
     * @return  回调 
     */
    CompletableFuture<String> batchRead(Ioinfo address);

    /**
     *  写入
     *
     * @param address 地址ַ
     * @param data    写入数据
     * ByteBuf data
     * @return  回调 
     */
    CompletableFuture<String> batchWrite(Ioinfo address, String data);
}
