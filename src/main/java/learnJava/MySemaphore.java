/**
// * <p> @(#)MySemaphore.java, 2014-1-7. </p>
 * 
 * Copyright 2014 RenRen, Inc. All rights reserved.
 */
package learnJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;



/**
 * 
 * @author wmc
 * 
 */
public class MySemaphore extends Thread {
	Semaphore position;
	private int id;

	public MySemaphore(int i, Semaphore s) {
		this.id = i;
		this.position = s;
	}

	public void run() {
		try {
			if (position.availablePermits() > 0) {
				System.out.println(position.availablePermits() + " available");
			} 
			position.acquire();
			System.out.println(this.id + " get service");
			Thread.sleep((long) (Math.random() * 10000));

			System.out.println(this.id + " service over");
			position.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService list = Executors.newCachedThreadPool();
		
		Semaphore position = new Semaphore(2);
		for (int i=0;i!=10;i++) {
			list.submit(new MySemaphore(i+1, position));
		}
	
		list.shutdown();
		position.acquireUninterruptibly(2);
		System.out.println("Finish");
		position.release(2);
		
	}
}
