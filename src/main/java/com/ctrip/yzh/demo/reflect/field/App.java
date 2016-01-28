package com.ctrip.yzh.demo.reflect.field;

import java.lang.reflect.Field;

public class App
{
	public static void main(String[] args) throws Exception{
		
		ReflectPoint rPoint=new ReflectPoint(1, 2);
		
		Field fieldX=rPoint.getClass().getField("x");  // pulbic字段
		System.out.println(fieldX.get(rPoint));
		
		Field fieldY=rPoint.getClass().getDeclaredField("y"); // private字段
		fieldY.setAccessible(true); // 暴力反射
		System.out.println(fieldY.get(rPoint));
		
		replaceWord(rPoint);
		System.out.println(rPoint);
	}
	
	/**
	 * 替换字符串
	 * @param object
	 * @throws Exception
	 */
	private static void replaceWord(Object object) throws Exception{
		Field[] fields=object.getClass().getFields();
		for(Field field:fields){
			if(field.getType()==String.class){
				String newWord="hello kitty";
				field.set(object, newWord);
			}
		}
	}
}
