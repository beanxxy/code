package com.snimay.test;

import com.snimay.compiler.compiler.JavaFile;
import com.snimay.compiler.compiler.MyClassloader;

public class dfd {
	public static void main(String[] args) throws ClassNotFoundException {
		String className = "com.snimay.app.vo.Field";
		String classPath = JavaFile.class.getClassLoader().getResource("").getPath();
		System.out.println("yfyfyfyfyfyfy"+className);
		//System.out.println("yfyfyfyfyfyfy");
		MyClassloader cl = new MyClassloader(classPath,  
                new String[] {className});  
		//MyClassloader myClassloader = new MyClassloader(path+"/"+"com/snimay/app/vo"+u.id+"/"+clazz.name+".class");
		Class ce = cl.loadClass(className);
		try {
			ce.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
