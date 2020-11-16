package com.snimay.test.xx;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.snimay.app.vo.SysLog;
import com.snimay.hibernate.dao.ItemsRepository;
import com.snimay.test.CustomCL;

public class hb extends Thread{
	public void run() {
		while(true) {
			try {
				CustomCL cl 					= new CustomCL("E:\\software\\snimay1\\snimay\\target\\classes\\", new String[]{"com.snimay.app.vo.SysLog"});
				ItemsRepository itemsRepository = new ItemsRepository();
				
				Configuration cfg 				= new Configuration().configure();
				Class b							= cl.loadClass("com.snimay.app.vo.SysLog");;
				cfg.addAnnotatedClass(b);
				SessionFactory sy	=	cfg.buildSessionFactory();
				String s;
				try {
					s = new Gson().toJson(itemsRepository.seach(sy,b.newInstance(), "1=1"));
					System.out.println(s);
					sy.close();
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
		}
	}
	public static void main(String[] args) {
		new hb().start();
	}
}
