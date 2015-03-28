/**
 * <p> @(#)MyCountDownLatch.java, 2014-1-7. </p>
 * 
 * Copyright 2014 RenRen, Inc. All rights reserved.
 */
package learnJava;

import java.util.concurrent.CountDownLatch;


/**
 *
 * @author wmc
 *
 */
public class MyCountDownLatch {
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(10);
		
		
		for (int i=0;i!=10;++i) {
			new Thread(new Worker(i, startSignal, doneSignal)).start();
		}
		System.out.println("Begin to start");
		startSignal.countDown();
		System.out.println("Begin to run");
		doneSignal.await();
		System.out.println("Finish working");
	}
	
	
}

class Worker implements Runnable{
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	private final int id ;
	public Worker(int id, CountDownLatch startSignal, CountDownLatch doneSignal){
		this.id = id;
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.startSignal.await();
			dowork();
			
			doneSignal.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void dowork(){
		System.out.println(id + " begin to work");
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id + " finish working");
	}
	
}
