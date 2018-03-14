package com.aiguigu.testlom;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Ticket{
	private int count = 30;
	//可重复锁
	private Lock lk = new ReentrantLock();
	
	public void sale() {
		
		lk.lock();
		
		try {
			if (count > 0) {
				System.out.println("这是"+Thread.currentThread().getName()+"卖的"+(count--)+"张票");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lk.unlock();
		}

	}
}

public class TestMai {

	public static void main(String[] args) {
		
		Ticket tic = new Ticket();
		
		new Thread(() -> {for (int i = 1; i < 40; i++) {tic.sale();}},"AA").start();
		new Thread(() -> {for (int i = 1; i < 40; i++) {tic.sale();}},"BB").start();
		new Thread(() -> {for (int i = 1; i < 40; i++) {tic.sale();}},"CC").start();
		
	}
	
	/*class MyRunnable implements Runnable{
		
		private int count = 30;

		@Override
		public void run() {
			while(count>0) {
				 test1() ;
			}
			
		}
		public  synchronized void  test1() {
			if(count>0) {
				count--;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余：" + count);
			}
		}
	}*/
}
