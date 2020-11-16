package com.snimay.test;

public class FileClassLoader2{
 
    public String toString()  {
    	try {
			try {
				Class c= Class.forName("com.snimay.test.DemoObj");
				String s=c.newInstance().toString();
				c=null;
			 
				return s;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "";
	}	
   
}
