package gateway.core.model;

import java.util.concurrent.CompletableFuture;

import gateway.core.config.Ioinfo;

public class MelseData {
	public CompletableFuture<String> future;
	public CompletableFuture<Void> wfuture;
	public Ioinfo address;
	public String wdata;
	
	public MelseData(CompletableFuture<String> f,Ioinfo as) {
		this.address = as;
		this.future = f;
	}
	 
	public MelseData(CompletableFuture<Void> f,Ioinfo as,String w) {
		this.address = as;
		this.wfuture = f;
		this.wdata = w;
	}
	public MelseData(CompletableFuture<Void> f,Ioinfo as,String w,String t) {
		this.address = as;
		this.wfuture = f;
		this.wdata = w;
	}
}
