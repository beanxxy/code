package gateway.core;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import gateway.core.config.ServerConfig;
import gateway.core.model.HttpData;

/**
 * @author bean
 * 2020年10月17日
 */
public interface Server {
	
	
	
	
	/**
	 * @param address
	 * @return
	 */
	public static Server create(ServerConfig address) {
		return null;
	}
	
	 /**
	 * 绑定到主机和端口
	 * @param host
	 * @param port
	 * @return
	 */
	CompletableFuture<HttpData> bind(ServerConfig address);
	
	/**
     * 关闭
     */
    void shutdown();

	void Accept(Consumer<? super HttpData> action);
}
