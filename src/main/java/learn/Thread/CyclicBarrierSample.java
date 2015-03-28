/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Descriptions of the class CyclicBarrierSample.java's implementation：TODO
 * described the implementation of class
 * 
 * @author wmc 2014年4月30日 下午3:36:23
 */
public class CyclicBarrierSample {
	private static int barrierSize = 5;
	private volatile static CyclicBarrier barrier;
	private static CountDownLatch latchSingal;
	private static CyclicBarrier runbarrier;
	private static CyclicBarrierThread[] dataBarrierThreads = new CyclicBarrierThread[barrierSize];
	private static ReentrantLock lock;
	private static Object olock;
	private static volatile boolean redoflag = false;
	
	
	public static void init() {
		
		synchronized (olock) {
			
		}
		lock = new ReentrantLock();
		barrier = new CyclicBarrier(barrierSize, new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("-------------------------------");
			}
		});
		for (int i = 0; i < barrierSize; i++) {
			dataBarrierThreads[i] = new CyclicBarrierThread();
			dataBarrierThreads[i].start();
		}
	}

	public  static void redo() {
		
		for (int i = 0; i < barrierSize; i++) {
			if (dataBarrierThreads[i] == null
					|| !dataBarrierThreads[i].isAlive()) {
				dataBarrierThreads[i] = null;
				dataBarrierThreads[i] = new CyclicBarrierThread();
				dataBarrierThreads[i].start();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException,
			BrokenBarrierException {
		init();
		while (true) {
			Thread.sleep(Math.abs(new Random().nextInt() % 5000) + 5000);
			int id = Math.abs(new Random().nextInt() % 5);
			System.out.println("Begin to interrupt thread id " + id);
			dataBarrierThreads[id].interrupt();
	}
	}

	static class CyclicBarrierThread extends Thread {
		public void run() {
			try {
				while (true) {
					if (redoflag) {
						System.out.println("Thread " + getId()
								+ " find broker barrier!");
						Thread.sleep(Math.abs(new Random().nextInt() % 1000) + 1000);
						lock.lock();
						//System.out.println(redoflag == true ? "Thread " + getId() +" yes" : "Thread " + getId() +" no");
						
						if (redoflag) {
							redoflag = false;
							redo();
						} 
						lock.unlock();
						
					} else {
						System.out.println("Thread " + getId()
								+ " begin to wait, number is "
								+ barrier.getParties());
						barrier.await();
						// latchSingal.countDown();
						Thread.sleep(Math.abs(new Random().nextInt() % 1000) + 1000);
					}

					// System.out.println("Thread " + getId() +
					// " wait finish!");
				}
			} catch (InterruptedException e) {
				redoflag = true;
			} catch (BrokenBarrierException e) {
				redoflag = true;
			}

		}
	}
}
