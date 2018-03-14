package com.atguigu.test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Copy{
	
	private int count = 1;
	private Lock lk = new ReentrantLock();
	private Condition cd1 = lk.newCondition();
	private Condition cd2 = lk.newCondition();
	private Condition cd3 = lk.newCondition();
	
	
	public void copy5(int nubmer) throws Exception {
		
		lk.lock();
		try {
			//判断
			while(count!=1) {
				
				cd1.await();
			}
			//执行
			for (int i = 1; i <=5; i++) {
				System.out.println(Thread.currentThread().getName()+i+"\t =====>"+nubmer);
			}
			//通知
			count=2;
			cd2.signal();
		} finally {
			lk.unlock();
		}
	}
	public void copy10(int nubmer) throws Exception {
		
		lk.lock();
		try {
			//判断
			while(count!=2) {
				
				cd2.await();
			}
			//执行
			for (int i = 1; i <=10; i++) {
				System.out.println(Thread.currentThread().getName()+i+"\t =====>"+nubmer);
			}
			//通知
			count=3;
			cd3.signal();
		} finally {
			lk.unlock();
		}
	}
	public void copy15(int nubmer) throws Exception {
		
		lk.lock();
		try {
			//判断
			while(count!=3) {
				
				cd3.await();
			}
			//执行
			for (int i = 1; i <=15; i++) {
				System.out.println(Thread.currentThread().getName()+i+"\t=====>"+nubmer);
			}
			//通知
			count=1;
			cd1.signal();
		} finally {
			lk.unlock();
		}
	}
	
	
	
	
}

public class TestCopy {
	
	public static void main(String[] args) {
		
		Copy copy = new Copy();
		
		new	Thread(()->{for (int i = 1; i <=5; i++) {
			
		 try {
			copy.copy5(i);
		} catch (Exception e) {
			e.printStackTrace();
		}  }},"A").start();
		new	Thread(()->{for (int i = 1; i <=5; i++) {
			try {
				copy.copy10(i);
			} catch (Exception e) {
				e.printStackTrace();
			}  }},"B").start();
		new	Thread(()->{for (int i = 1; i <=5; i++) {
			try {
				copy.copy15(i);
			} catch (Exception e) {
				e.printStackTrace();
			}  }},"C").start();
	}
}
