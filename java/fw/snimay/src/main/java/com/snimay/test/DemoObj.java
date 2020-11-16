package com.snimay.test;
public class DemoObj {
	static int i=0;
    @Override
    public String toString() {
    	i++;
        return "I am DemoObj"+i;
    }
}