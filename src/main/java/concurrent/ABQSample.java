/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package concurrent;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Descriptions of the class ABQSample.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月4日 下午2:12:40
 */
public class ABQSample {
	private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(100);
	private volatile int cur = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Executor services;
	
	public ABQSample(){
		services =  Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			//services.ex(new SyncSample());
			services.execute(new SyncSample());
		}
	}
	public void addData(ArrayList<Integer> data){
		queue.addAll(data);
		
	}
	
	public void getData(){
		
	}
	
	public static void main(String[] args) {
		ABQSample handler = new ABQSample();
		
	}

	class SyncSample implements Runnable{

		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				final ReentrantLock lock = ABQSample.this.lock;
				try{
					lock.lock();
					System.out.println("Thread "+Thread.currentThread().getName() + " get value "+cur);
					cur++;
					try {
						Thread.sleep(Math.abs(new Random().nextInt() % 1000) + 100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}finally{
					lock.unlock();
				}
			}

			
		}

	}


}


