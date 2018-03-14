package com.atguigu.test02;

import java.util.concurrent.CountDownLatch;

//CountDownLatch 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
//void countDown() 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。 

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cd = new CountDownLatch(5);
		
		for (int i = 1; i <=5; i++) {
			
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 姓");
				
				cd.countDown();
			},TestEnum.getR(i).getRm()).start();
		}
		cd.await();
		System.out.println(Thread.currentThread().getName()+"\t 统一");
	}

}
