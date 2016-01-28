package com.ctrip.yzh.demo;

import java.lang.reflect.Constructor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Constructor<String> constructor=String.class.getConstructor(byte[].class);
    	String str=(String)constructor.newInstance(new byte[]{34,35});
    	System.out.println(str);
    }
}
