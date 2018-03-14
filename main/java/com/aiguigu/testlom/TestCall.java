package com.aiguigu.testlom;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//Callable{call()}与Runanle{run()}的不同之处:1，Callable有返回值，2，Callable可抛异常；3,各自实现类实现的方法不同
//Callable  返回结果并且可能抛出异常的任务。实现者定义了一个不带任何参数的叫做 call 的方法。 

class MyCall implements Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		
		System.out.println("welcome------>callable");
		
		return 12000;
	}
	
}

public class TestCall{
	
	public static void main(String[] args) throws Exception {
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCall());
		
		new Thread(futureTask,"hadeng----》线程").start();
		
		System.out.println(Thread.currentThread().getName()+"-------->main线程");
		
		Integer result = futureTask.get();

		System.out.println(result);
	   
	}
}