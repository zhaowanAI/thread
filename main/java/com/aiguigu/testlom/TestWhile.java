package com.aiguigu.testlom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SuanFa{
	private int count = 0;
	private Lock lk = new ReentrantLock();
	private Condition condition = lk.newCondition();
	
	public void add() {
		
		lk.lock();
		
		try {
			//判断
			while(count!=0) {
				
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//执行
			++count;
			System.out.println(Thread.currentThread().getName()+"------>"+count);
			//通知
			condition.signalAll();
		} finally {
			
			lk.unlock();
		}
		
	}
	
	public void jian() {
		
		lk.lock();
		
		try {
			//判断
			while(count==0) {
				
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//执行
			--count;
			System.out.println(Thread.currentThread().getName()+"------>"+count);
			//通知
			condition.signalAll();
		} finally {
			
			lk.unlock();
		}
		
	}
	
	
/*	public synchronized void jia() {
		//判断
		while(count!=0) {
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//执行
		++count;
		//通知
		this.notifyAll();
		System.out.println(count);
	}
	public synchronized void jian() {
			//判断
		while(count==0) {
			try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//执行
			--count;
			//通知
			this.notifyAll();
		System.out.println(count);
	}*/
	
}

public class TestWhile {
	
	public static void main(String[] args) {
		
		SuanFa sf = new SuanFa();
		
		
		new Thread(()->{for (int i = 1; i < 10; i++) {
			try {
				sf.jian();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}},"aa").start();
		new Thread(()->{for (int i = 1; i < 10; i++) {
			try {
				sf.add();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}},"bb").start();
		new Thread(()->{for (int i = 1; i < 10; i++) {
			try {
				sf.jian();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}},"cc").start();
		new Thread(()->{for (int i = 1; i < 10; i++) {
			try {
				sf.add();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}},"dd").start();
		
	
		
		/*new Thread( () -> {for (int i = 1; i < 10; i++) {sf.jian();}},"bb") .start();
		
		new Thread( () -> {for (int i = 1; i < 10; i++) {sf.jia();}},"cc") .start();
		
		new Thread( () -> {for (int i = 1; i < 10; i++) {sf.jian();}},"dd") .start();*/
		
			
		
		
		/*new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=15; i++) {
					
					sf.jia();
				}
				
			}
		},"aa").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=15; i++) {
									
						sf.jian();
				}
				
			}
		},"bb").start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=15; i++) {
					
					sf.jia();
				}
				
			}
		},"cc").start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=15; i++) {
					
					sf.jian();
				}
				
			}
		},"dd").start();*/
		
		
	}
	

}
