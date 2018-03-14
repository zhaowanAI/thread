package com.atguigu.test02;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


//获取多线程的滴四中方式->线程池；(另外三种：1，继承thread类；2，实现runablel接口；3，实现callable接口)
//runablel
//Executors  java线程池的工具类
//ScheduledExecutorService时间轮循片  schedule 方法使用各种延迟创建任务，并返回一个可用于取消或检查执行的任务对象
//Executors Arrays collections
//Arrays 此类包含用来操作数组（比如排序和搜索）的各种方法。此类还包含一个允许将数组作为列表来查看的静态工厂。 


public class TestExecutor {
	
	
	
	public static void main(String[] args){
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> result = null;
		
		try {
			for (int i = 1; i <=10; i++) {
				
				result = service.schedule(()->{
					System.out.print(Thread.currentThread().getName());
					
					return new Random().nextInt(30);
					}, 1, TimeUnit.SECONDS);
					System.out.println("\t result===>"+result.get());
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			service.shutdown();
		}
			
		
	}

	private static void esDemo() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		Future<Integer> resultTask = null;
		
		try {
			for (int i = 1; i <=10; i++) {
				
				resultTask = service.submit(()->{
					System.out.print(Thread.currentThread().getName());
					
					return new Random().nextInt(30);
				});
				System.out.println("\t resultTask===>"+resultTask.get());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			service.shutdown();
		}
	}
	

}
