package com.atguigu.test02;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//CyclicBarrier 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 
// int await() 在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。 
public class CyclicBarrierDemo {
	
	private static final Integer NUBMER = 7;
	
	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(NUBMER,()->{System.out.println("集齐七颗龙珠！召唤神龙......");});
		
		for (int i = 1; i <=NUBMER; i++) {
			
			int count = i;
			
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t收集到第==》"+count+"龙珠");
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}

}
