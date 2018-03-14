package com.atguigu.test02;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

//ConcurrentModificationException===>java高并发修改异常
//解决方法:写时复制 CopyOnWriteArrayList CopyOnWriteArraySet ConcurrentHashMap 
public class CopyOnWriteArrayListDemo {
	
	public static void main(String[] args) {
		//ArrayList<String> list = new ArrayList<>();
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		
	for (int i = 1; i <=30; i++) {
			
		new Thread(()->{
			list.add(UUID.randomUUID().toString().substring(1, 5));
			System.out.println(list);
		},String.valueOf(i)).start();
		}
	}

}
