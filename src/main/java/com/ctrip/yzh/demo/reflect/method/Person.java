package com.ctrip.yzh.demo.reflect.method;

public class Person
{
	private String name;	
	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	private int age;
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}

}
