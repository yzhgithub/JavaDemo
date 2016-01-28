package com.ctrip.yzh.demo.reflect.field;

public class ReflectPoint
{
	public int x;
	@SuppressWarnings("unused")
	private int y;
	public String str="hello world";
	
	public ReflectPoint(int x,int y){
		super();
		this.x=x;
		this.y=y;
	}
	
	public String toString(){
		return "hello world has changed to："+str;
	}

}
