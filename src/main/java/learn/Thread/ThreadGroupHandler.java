/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Descriptions of the class ThreadGroupHandler.java's implementation：TODO
 * described the implementation of class
 * 
 * @author wmc 2014年5月13日 下午4:52:05
 */
public class ThreadGroupHandler extends Thread {
	private final ThreadGroup group;

	private int maxThreadNum = 10;
	private final AtomicInteger threadNum = new AtomicInteger(0);
	private final ReentrantLock lock;
	private final Condition full;
	private final BlockingQueue<Thread> listQueue;
	private Map<WatchKey, Path> keys = new ConcurrentHashMap<WatchKey, Path>();
	private static WatchService watcher = null;
	private static String namePrefix;

	public ThreadGroupHandler(int maxThreadNum) {
		this.maxThreadNum = maxThreadNum;
		SecurityManager securityManager = System.getSecurityManager();

		group = (securityManager != null) ? securityManager.getThreadGroup()
				: Thread.currentThread().getThreadGroup();

		namePrefix = "Thread-";

		lock = new ReentrantLock();
		full = lock.newCondition();

		if (this.maxThreadNum <= 0) {
			this.maxThreadNum = 10;
		}
		listQueue = new LinkedBlockingQueue<Thread>();
		
		Small handlerSmall = new Small();
		handlerSmall.start();

	}

	public void startThread(WorkRunnable r) {
		try {
			lock.lock();
//			if(threadNum.get() >= maxThreadNum){
//				 //System.out.println("Thread "+ r.getName() + " Cannot get handler,begin to wait!!!");
//			}
			if (threadNum.get() >= maxThreadNum) {
				full.await();
			} 
			
			
			threadNum.getAndIncrement();
			System.out.println("Begin to start thread " + r.getName()+" *****************************************");
			Thread local = new Thread(group, r, r.getName(), 0);
			listQueue.add(local);
			local.start();
			
			//group.interrupt();

			
		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			lock.unlock();
		}
	}
	
	class  Small extends Thread{
		public void run(){
			while(true){
				if(Math.abs(new Random().nextInt() % 10) <= 2){
					Thread curThread = listQueue.poll();
					
					if(curThread != null){
						//while(curThread.isAlive()){
							curThread.interrupt();
							System.out.println("Begin to interrupt thread "
									+ curThread.getName()+" *************************************");
						//}
						
						
					}else{
						System.out.println("It's null***********************************");
					}
					
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
		
		
	}

	public void update() {
		try {
			lock.lock();
			if (threadNum.get() < maxThreadNum) {
				full.signalAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void run() {
		Thread[] list = new Thread[maxThreadNum];

		while (true) {
			try {
				//if (Math.abs(new Random().nextInt() % 5) <= 2) {

					try {
						lock.lock();
						//System.out.println(listQueue.size()+" dddddd");
//						if (group.activeCount() >= maxThreadNum) {
//							group.enumerate(list);
//							int num = Math.abs(new Random().nextInt()
//									% list.length);
//							
//							while (!list[num+2].interrupted()) {
//								list[num].interrupt();
//								System.out.println("Begin to interrupt thread "
//										+ list[num+2].getName()+" *************************************");
//							}
//							
//						}
						threadNum.set(listQueue.size());
						update();

					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						lock.unlock();
					}

				//}
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ThreadGroupHandler handler = new ThreadGroupHandler(10);
		handler.start();
		for (int i = 0; i < 100; i++) {
			handler.startThread(new WorkRunnable(String.valueOf(i)));
		}
		
		

	}
}

class WorkRunnable implements Runnable {
	private String name;
	private int i;

	public WorkRunnable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void run() {
		try {
			while(true){
				//System.out.println("Thread " + name + " produce " + i++);
				Thread.currentThread().sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();
		}
		
		
	}
}
