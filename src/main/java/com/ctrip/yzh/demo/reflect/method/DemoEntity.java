package com.ctrip.yzh.demo.reflect.method;


public class DemoEntity
{
	/**
	 * 加
	 * @param x
	 * @param y
	 * @return
	 */
	public int add(int x,int y){
		return x+y;
	}
	
	/**
	 * 减
	 * @param x
	 * @param y
	 * @return
	 */
	@SuppressWarnings("unused")
	private int subtract(int x,int y){
		return x-y;
	}
	
	/**
	 * 显示
	 * @param person
	 * @return
	 */
	public String show(Person person){
		return "Name："+person.getName()+" Age："+person.getAge();
	}
	
	/**
	 * 转换
	 * @param z
	 * @return
	 */
	public static String convertToString(int z){
		return ""+z;
	}

}
