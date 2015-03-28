/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.concurrent.Semaphore;

/**
 * Descriptions of the class MyReadWriteLock.java's implementation：TODO
 * described the implementation of class
 * 
 * @author wmc 2014年3月18日 下午3:01:25
 */
public class MyReadWriteLock {
	private final boolean writeFirst;
	private Semaphore writingSemaphore;
	private Semaphore readingSemaphore;
	private Semaphore waitWritingSemaphore;
	private Semaphore waitReadingSemaphore;

	public MyReadWriteLock(boolean writeFirst) {
		this.writeFirst = writeFirst;
		this.writingSemaphore = new Semaphore(0);
		this.readingSemaphore = new Semaphore(0);
		this.waitWritingSemaphore = new Semaphore(0);
		this.waitReadingSemaphore = new Semaphore(0);
	}

	public  void readLock() {
		waitReadingSemaphore.release();
		try {
			while (writingSemaphore.availablePermits() > 0
					|| (writeFirst && waitWritingSemaphore.availablePermits() > 0)) {
//				System.out.println("Waiting for read, writing num is "+writingSemaphore.availablePermits() +
//						" wait for write num is "+waitWritingSemaphore.availablePermits());
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				waitReadingSemaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		readingSemaphore.release();

	}

	public  void writeLock() {
		waitWritingSemaphore.release();
		try {
			while (readingSemaphore.availablePermits() > 0
					|| (!writeFirst && waitReadingSemaphore.availablePermits() > 0)) {
//				System.out.println("Waiting for write,reading num is "+readingSemaphore.availablePermits() +
//						" wait for read num is "+waitReadingSemaphore.availablePermits());
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				waitWritingSemaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		writingSemaphore.release();
	}

	public  void readUnLock() {
		try {
			readingSemaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//notifyAll();
	}

	public    void writeUnLock() {
		try {
			writingSemaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//notifyAll();
	}

}
