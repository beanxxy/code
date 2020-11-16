package com.snimay.test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class RunnableDemo implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			CustomCL cl = new CustomCL("E:\\software\\snimay1\\snimay\\target\\classes\\", new String[]{"com.snimay.test.FileClassLoader2"});
			 //创建自定义文件类加载器
	        try {
	            Class<?> object2=cl.loadClass("com.snimay.test.FileClassLoader2");
	            System.out.println(object2.newInstance().toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
       
	}
		
	private String threadName;
	public RunnableDemo( String name) {
		threadName = name;
    }
	private Thread t;
	public void start () {
	    if (t == null) {
	    	t = new Thread (this, threadName);
	    	t.start ();
	    }
   }
   public static void main(String[] args) {
	   while(true) {
		   RunnableDemo R1 = new RunnableDemo("1123123");
		   R1.start();
		  // R1=null;
		  // System.gc(); 
	   }
   }
}