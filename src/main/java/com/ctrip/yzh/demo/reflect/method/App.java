package com.ctrip.yzh.demo.reflect.method;

import java.lang.reflect.Method;

public class App
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("Method反射解析：");
		DemoEntity dEntity=new DemoEntity();
		System.out.println("通用方式(公共方法)："+dEntity.add(1, 2));
		Method addMethod=DemoEntity.class.getMethod("add", int.class,int.class);
		System.out.println("反射方式(公共方法)："+addMethod.invoke(dEntity, 1,4));
		
		Method subMethod=DemoEntity.class.getDeclaredMethod("subtract",int.class,int.class);
		subMethod.setAccessible(true); // 暴力反射
		System.out.println("反射方式(私有方法)："+subMethod.invoke(dEntity, 1,5));
		
		Person person=new Person("Jack", 15);
		Method showMethod=DemoEntity.class.getMethod("show",Person.class);
		System.out.println("反射方式(参数为自定义对象)："+showMethod.invoke(dEntity, person));
		
		Method staticMethod=DemoEntity.class.getMethod("convertToString", int.class);
		System.out.println("反射方式(静态方式)："+staticMethod.invoke(null, 100));
		
		String[] strs=new String[]{"hello","world"};
		Method mainMethod=Class.forName("com.ctrip.yzh.demo.reflect.method.TestArg").getMethod("main", String[].class);
		//System.out.println("反射方式(调用Main方法)："+mainMethod.invoke(null, new Object[]{strs}));  // 此种方式效率低
		System.out.println("反射方式(调用Main方法)："+mainMethod.invoke(null, (Object)strs));
	}
}
