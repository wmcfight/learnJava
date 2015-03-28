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
 * Descriptions of the class BoundedBuffer.java's implementation：TODO described the implementation of class
 * @author wmc 2014年1月11日 下午3:13:12
 */
public class BoundedBuffer<E> {
	private final Semaphore aItems, aSpaces;
	
	private final E[] items;
	
	@SuppressWarnings("unused")
	private int pPosition,tPosition = 0;
	
	public BoundedBuffer(int capacity){
		aItems = new Semaphore(0);
		aSpaces = new Semaphore(capacity);
		items = (E[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		System.out.println("A items is "+aItems.availablePermits());
		return aItems.availablePermits() == 0 ? true:false;
	}
	
	public boolean isFull() {
		System.out.println("A space is "+aSpaces.availablePermits());
		return aSpaces.availablePermits() == 0?true:false;
	}
	
	public void put(E x) throws InterruptedException{
		aSpaces.acquire();
		doInsert(x);
		aItems.release();
	}
	
	public E take() throws InterruptedException{
		aItems.acquire();
		E item = doExtract();
		aSpaces.release();
		return item;
	}
	
	private synchronized void doInsert(E x){
		int i = pPosition;
		items[i] = x;
		pPosition = (++i == items.length ) ? 0 : i;
	}
	
	private synchronized E doExtract(){
		int i= tPosition;
		E xE = items[i];
		items[i] = null;
		tPosition = (++i == items.length )?0:i;
		return xE;
	}
	
}
