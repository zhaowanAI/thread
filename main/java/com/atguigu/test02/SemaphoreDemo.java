package com.atguigu.test02;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//Semaphore :一个计数信号量。从概念上讲，信号量维护了一个许可集。(相当于一个信号灯)
//acquire() 从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断
//release() 释放一个许可，将其返回给信号量
public class SemaphoreDemo {
	
	public static void main(String[] args) {
		Semaphore sd = new Semaphore(2);
		for (int i = 1; i <=5; i++) {
			new Thread(()->{
				try {
					sd.acquire();
					System.out.println(Thread.currentThread().getName()+"\t 号车子占用了该车位");
					TimeUnit.SECONDS.sleep(new Random().nextInt(3));
					System.out.println(Thread.currentThread().getName()+"\t 号车子离开了该车位");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					sd.release();
				}
			},String.valueOf(i)).start();
		}
	}

}
