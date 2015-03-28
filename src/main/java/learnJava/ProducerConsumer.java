/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Descriptions of the class ProducerConsumer.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月17日 下午4:22:49
 */
public class ProducerConsumer {
	private long capacity = 0;
	private AtomicLong size = new AtomicLong(0);
	private static ProducerConsumer handler = null;
	private ProducerConsumer(long capacity){
		this.capacity = capacity;
	}
	
	public synchronized static void initialize(int capacity){
		if(handler == null){
			handler = new ProducerConsumer(capacity);
		}
	} 
	
	public static  ProducerConsumer getInstance(int capacity){ 
		if(handler == null){
			initialize(capacity);
		}
		return handler;
	}
	
	public  void producer(int data, String item){
		synchronized (size) {
			int left = data;
			while(left > 0){
				while(size.get() >= capacity){
					try {
						System.out.println("Thread "+item + " producer begin to wait,data is "+data+" size is " +size.get());
						size.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						size.notifyAll();
						break;
					}
				}
				int inc = (int) (size.get() + data >= capacity ? data : capacity-size.get());
				left -= inc;
				size.addAndGet(inc);
				System.out.println("Thread "+item + " produder "+data+" items, sum is up to "+size.get());
				size.notifyAll();
			}
			
		}
	}
	
	public  void consumer(int data,String item){
		synchronized (size) {
			int left = data;
			while(left > 0){
				while(size.get() <= 0){
					try {
						System.out.println("Thread "+item + " consumer begin to wait,data is "+data+" size is " +size.get());
						size.wait();       //must make clear, the wait object
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						size.notifyAll();
						break;
					}
				}
				int dec = (int) (size.get() >= data ? size.get(): data);
				size.addAndGet(-dec);
				left -= dec;
				System.out.println("Thread "+item + " consumer "+data+" items, sum is up to "+size.get());
				size.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		ProducerConsumer handler = ProducerConsumer.getInstance(100);
		for (int i = 0; i < 1; i++) {
			new Thread(new Consumer(String.valueOf("consumer"+i), handler)).start();
		}
		for (int i = 0; i < 10; i++) {
			new Thread(new Producer(String.valueOf("producer"+i), handler)).start();
		}
		
//		test handler = new test();
//		StringBuffer a = new StringBuffer();
//		handler.A(a);
		
	}
}
class SchedulerTimer{
	private AtomicBoolean flag = new AtomicBoolean(true);
	
	public void start(int delay){
		ScheduledExecutorService sample =  Executors.newScheduledThreadPool(1, new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setDaemon(true);
				return thread;
			}
		});
		sample.scheduleAtFixedRate(new StopRunnable(), delay, 10, TimeUnit.SECONDS);
	}
	
	public boolean getFlag(){
		return flag.get();
	}
	class StopRunnable implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			flag.set(false);
		}
		
	}
}
class Producer implements Runnable{
	private ProducerConsumer handler;
	private String name;
	private SchedulerTimer timer;
	public Producer(String name,ProducerConsumer handler){
		this.handler = handler;
		this.name = name;
		timer = new SchedulerTimer();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.start(30);
		while(timer.getFlag()){
			handler.producer((new Random()).nextInt(100), name);
		}
	}
	
}

class Consumer implements Runnable{
	private ProducerConsumer handler;
	private String name;
	private SchedulerTimer timer;
	public Consumer(String name,ProducerConsumer handler){
		this.handler = handler;
		this.name = name;
		timer = new SchedulerTimer();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.start(60);
		while(timer.getFlag()){
			handler.consumer((new Random()).nextInt(100), name);
		}
	}
	
}

class test{
	public void A(StringBuffer a){
		a.append("testA");
		System.out.println(" In function A before B is "+a.toString());
		B(a);
		System.out.println(" In function A after B is "+a.toString());
	}
	
	public void B(StringBuffer a){
		a.append("testB");
		System.out.println(" In function A before B is "+a.toString());
	}
}
