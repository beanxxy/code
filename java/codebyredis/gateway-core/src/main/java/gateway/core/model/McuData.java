package gateway.core.model;

import java.util.concurrent.CompletableFuture;

import gateway.core.config.Ioinfo;

public class McuData {
	public CompletableFuture<String> future;
	public CompletableFuture<Void> wfuture;
	public Ioinfo address;
	public String wdata;
	public McuData(CompletableFuture<String> f,Ioinfo as) {
		this.address = as;
		this.future = f;
	}
	public McuData(CompletableFuture<String> f,Ioinfo as,String w) {
		this.address = as;
		this.future = f;
		this.wdata = w;
	}
	public McuData(CompletableFuture<Void> f,Ioinfo as,String w,String t) {
		this.address = as;
		this.wfuture = f;
		this.wdata = w;
	}
}
