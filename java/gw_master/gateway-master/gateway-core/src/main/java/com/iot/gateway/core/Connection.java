package com.iot.gateway.core;

import java.util.concurrent.CompletableFuture;

/**
 * @author bean
 * 2020年11月14日
 */
public interface Connection {
	/**
	 * @param address
	 * @return
	 */
	CompletableFuture<String> batchRead(Ioinfo address);
	/**
	 * @param address
	 * @param data
	 * @return
	 */
	CompletableFuture<String> batchWrite(Ioinfo address, String data);
}
