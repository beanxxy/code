package com.snimay.test;

public class Psd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String str	=	"2q3ERE3/path/fdfdfsdf";
		System.out.println(str.indexOf("/pat"));
		System.out.println(str.toLowerCase());
		*/
		Object o = new Object();
		System.out.println(Psd.class.getClassLoader().hashCode());
		System.out.println(App2.class.getClassLoader());
		
		Object o1 = o;
		System.out.println(o1.hashCode());
	}

}
