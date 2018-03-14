package com.atguigu.test02;

import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁  排他写 共享读；(一个线程的写入多个线程的读取)
class RwLock{
	private Object obj;
	private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
	
	public void testWr(Object obj) {
		
		rw.writeLock().lock();
		try {
			this.obj = obj;
			System.out.println(Thread.currentThread().getName()+"写====>"+obj);
			
		} finally {
			rw.writeLock().unlock();
		}
	}
	public void testRe() {
		
		rw.readLock().lock();
		try {
			
			System.out.println(Thread.currentThread().getName()+"读线程====>"+obj);
			
		} finally {
			rw.readLock().unlock();
		}
	}
}



public class ReadWriteLockDome {
	public static void main(String[] args) throws InterruptedException {
		
		RwLock rl = new RwLock();
		
		new Thread(()->{rl.testWr("你好java;");},"A").start();
		
		Thread.sleep(100);
		
		for (int j = 1; j <=20; j++) {
			
		new Thread(()->{rl.testRe();},String.valueOf(j)).start();
		}
	}
		
}
