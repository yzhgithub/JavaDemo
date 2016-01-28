package com.ctrip.yzh.demo.reflect;

import java.lang.reflect.Constructor;

public class App
{
	public static void main(String[] args){
		
		/**
		 * 【案例1】通过一个对象获取完整的包名和类名
		 */
		System.out.println("【案例1】通过一个对象获取完整的包名和类名");
		Entity entity=new Entity();
		System.out.println(entity.getClass().getName());
		
		/**
		 * 【案例2】实例化Class类对象
		 */
		System.out.println("【案例2】实例化Class类对象");
		Class<?> entity1=null;
		Class<?> entity2=null;
		Class<?> entity3=null;
		try{
			entity1=Class.forName("com.ctrip.yzh.demo.reflect.Entity");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		entity2=new Entity().getClass();
		entity3=Entity.class;
		System.out.println("entity1："+entity1.getName());
		System.out.println("entity2："+entity2.getName());
		System.out.println("entity3："+entity3.getName());
		
		/**
		 * 【案例3】通过Class实例化其他类的对象（无参构造器）
		 */
		System.out.println("【案例3】通过Class实例化其他类的对象（无参构造器）");
		Class<?> demo=null;
		try{
			demo=Class.forName("com.ctrip.yzh.demo.reflect.Person");
		}catch(Exception e){
			e.printStackTrace();
		}
		Person per=null;
		try{
			per=(Person)demo.newInstance();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		per.setName("Rollen");
		per.setAge(20);
		System.out.println(per);
		
		/**
		 * 【案例4】通过Class调用其他类中的构造函数
		 */
		System.out.println("【案例4】通过Class调用其他类中的构造函数");
		Class<?> demo1=null;
		try{
			demo1=Class.forName("com.ctrip.yzh.demo.reflect.Person");
		}catch(Exception e){
			e.printStackTrace();
		}
		Person per1=null;
		Person per2=null;
		Person per3=null;
		Person per4=null;
		Constructor<?> cons[]=demo1.getConstructors();
		try{
			per1=(Person)cons[0].newInstance("Jack");
			per2=(Person)cons[1].newInstance(18);
			per3=(Person)cons[2].newInstance("Tom",20);
			per4=(Person)cons[3].newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(per1);
		System.out.println(per2);
		System.out.println(per3);
		System.out.println(per4);
		
	}

}
