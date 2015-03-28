/**
 * <p> @(#)BlockQueue.java, 2013-12-9. </p>
 * 
 * Copyright 2013 RenRen, Inc. All rights reserved.
 */
package learnJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 
 * @author wmc
 * 
 */
public class BlockQueue {

	private static BlockingQueue<String> dQueue = new ArrayBlockingQueue<String>(
			10000000);

	private static ConsumeThread consumeThread;

	private static ConcurrentLinkedQueue<Thread> listRunnables = new ConcurrentLinkedQueue<Thread>();
	private static AtomicLong dsize = new AtomicLong(0);
	private static AtomicInteger csize= new AtomicInteger(1);

	private static ExecutorService executorService = Executors
			.newCachedThreadPool();

	public void start() {
		getNewThread();

		// if (executorService instanceof ThreadPoolExecutor) {
		// ((ThreadPoolExecutor) executorService).setCorePoolSize(100);
		// // for (int i = 0; i != 10; ++i) {
		// // executorService.execute(new ConsumeThread());
		// // }
		// getNewThread();
		// } else {
		// throw new AssertionError("Add");
		// }
	}

	private void getNewThread() {
		System.out.println("Berfoe new  size is " + listRunnables.size());
		for (int i = 0; i != csize.get(); ++i) {
			Thread tRunnable = new ConsumeThread();
			listRunnables.add(tRunnable);
			tRunnable.start();
			// executorService.execute(tRunnable);
		}

		System.out.println("After new size is " + listRunnables.size());
	}

	private void stopNewThread() {
		
		synchronized (listRunnables) {
			if (listRunnables.size() >= 10) {
				System.out.println("Berfoe stop size is " + listRunnables.size());
				for (int i = 0; i != 5; i++) {
					Thread tRunnable = listRunnables.poll();
					tRunnable.interrupt();
				}
				System.gc();
				System.out.println("After stop size is " + listRunnables.size());
			}
			
		}
		
	}

	public void insert(List<String> key) {
		synchronized (dQueue) {
			if (dQueue.size() >= 100000*csize.get()) {
				getNewThread();
				csize.incrementAndGet();
			} else {
				if (dQueue.size() < 10000) {
					stopNewThread();
					csize.set(1);
				}
			}
			dQueue.addAll(key);
			dsize.addAndGet(key.size());
		}
	}

	private class ConsumeThread extends Thread {

		public void run() {
			AtomicLong sum = new AtomicLong(1);

			while (true) {
				try {
					String dString = dQueue.take();
					if (sum.incrementAndGet() % 100 == 0) {
						synchronized (dQueue) {
							System.out.println(Thread.currentThread()
									+ " data is " + dString
									+ " dQueue left size is " + dQueue.size());
						}
					}
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		BlockQueue dQueue = new BlockQueue();
		dQueue.start();
		int i = 1;
		List<String> lStrings = new ArrayList<String>();
		while (true) {
			if (i % 1000 == 0) {
				dQueue.insert(lStrings);
				lStrings.clear();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			lStrings.add(String.valueOf(i));
			i++;
		}
	}
}
