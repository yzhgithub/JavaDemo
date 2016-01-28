package com.ctrip.yzh.demo.reflect.constructor;

import java.lang.reflect.Constructor;

public class App
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		
    	Constructor<String> constructor=String.class.getConstructor(byte[].class);
    	String str=(String)constructor.newInstance(new byte[]{34,35,36});
    	System.out.println(str);
    	
    	Constructor<?> constructor2=String.class.getConstructor(StringBuffer.class);
    	String str2=(String)constructor2.newInstance(new StringBuffer("Hello"));
    	System.out.println(str2);
	}

}
