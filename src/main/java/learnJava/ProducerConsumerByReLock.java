/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Descriptions of the class ProducerConsumerByReLock.java's implementation：TODO
 * described the implementation of class
 * 
 * @author wmc 2014年4月28日 下午4:49:56
 */
class Depot {
	private int size;
	private int capacity;

	private Lock lock;
	private Condition leftCondition;
	private Condition totalCondition;

	public Depot(int capacity) {
		this.capacity = capacity;
		this.lock = new ReentrantLock();
		this.leftCondition = lock.newCondition();
		this.totalCondition = lock.newCondition();
	}

	public void consumer(int len) {
		lock.lock();
		int left = len;
		
		try {
			while(left > 0){
				
				while (size <= 0) {
					this.leftCondition.await();
				}
				int dec = size<left ? size : left;
				left -= dec;
				size -= dec;

				System.out.printf("%s consumer %d ,left %d, size %d\n", Thread
						.currentThread().getName(), dec, left,size);
				this.totalCondition.signal();
			}
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void producer(int len) {
		lock.lock();
		int left = len;
		try {
			while(left > 0){
				while (size >= capacity) {
					this.totalCondition.await();
				}
				int inc = (size+left)>=capacity ? left : capacity - size;
				size += inc;
				left -= inc;
				System.out.printf("%s produce %d ,left %d, size %d\n", Thread
						.currentThread().getName(), inc, left,size);
				this.leftCondition.signal();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class ReProducer {
	private Depot depot;

	public ReProducer(Depot depot) {
		this.depot = depot;
	}

	public void produce(final int len) {
		new Thread() {
			public void run() {
				depot.producer(len);
			}
		}.start();
	}
}

class ReConsumer {
	private Depot depot;

	public ReConsumer(Depot depot) {
		this.depot = depot;
	}

	public void consume(final int len) {
		new Thread() {
			public void run() {
				depot.consumer(len);
			}
		}.start();
	}
}

public class ProducerConsumerByReLock {
	public static void main(String[] args) {
		Depot mDepot = new Depot(100);
		ReProducer mPro = new ReProducer(mDepot);
		ReConsumer mCon = new ReConsumer(mDepot);
		mPro.produce(100);
		mPro.produce(120);
		mCon.consume(90);
		mCon.consume(150);
		mPro.produce(110);
	}
}
