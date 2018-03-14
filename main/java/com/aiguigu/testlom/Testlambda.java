package com.aiguigu.testlom;


interface Foo{
	
	//public void say();
	public int add(int a,int b) ;
	
	default int div(int a,int b ) {
		return a*b;
	};
	static int test(int x,int y) {
		return x/y;
	}
}


public class Testlambda {
	
	public static void main(String[] args) {
		
		/*
		 //原始的写法
		 * Foo foo = new Foo() {
			
			public void say() {
				System.out.println("welcome...NBA!");
			}
		};
		foo.say();
		//简写
		foo = ()->{System.out.println("welcome...hubei!");};
		foo.say();*/
	Foo	foo = (a,b) -> { return a+b;};
		
	System.out.println("add--->"+foo.add(4, 8));
	
	System.out.println("div--->"+foo.div(5, 6));
	
	//静态方法直接类名调用方法
	System.out.println("test--->"+Foo.test(10, 2));
	
	}

}
