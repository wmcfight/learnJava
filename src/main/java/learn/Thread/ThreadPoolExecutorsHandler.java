/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Descriptions of the class ThreadPoolExecutorsHandler.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月14日 下午6:33:35
 */
public class ThreadPoolExecutorsHandler {
	private ThreadPoolExecutor threadPoolExecutor;
	private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(3);
	
	public ThreadPoolExecutorsHandler(){
		threadPoolExecutor = new ThreadPoolExecutor(3, 20, 100, TimeUnit.MILLISECONDS, queue){
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				// TODO Auto-generated method stub
				super.beforeExecute(t, r);
				System.out.printf("Task  %s will execute!!\n",r.toString());
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				// TODO Auto-generated method stub
				super.afterExecute(r, t);
				System.out.printf("Task  %s is executed!!\n",r.toString());
			}

			@Override
			protected void terminated() {
				// TODO Auto-generated method stub
				super.terminated();
				System.out.println("Executors terminated!!!");
			}

			
		};
		threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
				System.out.printf("Task %s has been jecected!\n",r.toString());
			}
		});
		
		//threadPoolExecutor.
	}
	
	public void shutdown(){
//		try {
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (int i = 0; i < array.length; i++) {
//			
//		}
		
		System.out.println("Begin to shutdown  executor!!!!!!!!!!!!");
		threadPoolExecutor.shutdown();
//		try {
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void join(){
		while(!threadPoolExecutor.isTerminated()){
			
		}
	}
	private void addRunnable(Runnable a){
		threadPoolExecutor.execute(a);
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutorsHandler handler = new ThreadPoolExecutorsHandler();
		
		for(int i=0;i<20;i++){
			handler.addRunnable(new ThreadPoolRunnableTestHandler(String.valueOf(i)));
		}
		
		System.out.println("Begin to sleep main!!!");
		handler.shutdown();
		handler.join();
		
		//Thread.currentThread().join();
		System.out.println("Finish!!!!");
	}
}

class ThreadPoolRunnableTestHandler implements Runnable{
	private final String name;
	
	public  ThreadPoolRunnableTestHandler(String i) {
		this.name = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
       	 System.out.println("Thread "+name+ " started!!");
       	 try {
       		System.out.println("Thread "+name+ " begin to sleep!!");
				Thread.currentThread().sleep(Math.abs(new Random().nextInt() % 2000 + 2000));
				//Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	System.out.println("Thread "+name+ " begin to shutdown!!");
            System.out.println(String.format("Thread %s finished", name));   
	}
	
	public String toString(){
		return name;
	}
} 
