package com.aiguigu.testlom;

//懒汉式
public class Lazy {
	
	public static Lazy instanr;
	
	public Lazy(){
		
	}
	public static Lazy getInstanr() {
		
		if(instanr==null) {
			
			instanr = new Lazy();
		}
		return  instanr;
	}

}
