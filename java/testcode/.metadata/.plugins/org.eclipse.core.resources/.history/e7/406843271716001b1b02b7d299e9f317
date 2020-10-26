package gateway.core.model;

import java.util.concurrent.CompletableFuture;

import gateway.core.config.AddressConfig;

public class McuData {
	public CompletableFuture<String> future;
	public AddressConfig address;
	public String wdata;
	public McuData(CompletableFuture<String> f,AddressConfig as) {
		this.address = as;
		this.future = f;
	}
	public McuData(CompletableFuture<String> f,AddressConfig as,String w) {
		this.address = as;
		this.future = f;
		this.wdata = w;
	}
}
