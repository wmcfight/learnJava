/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Descriptions of the class CLHLock.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月29日 下午7:59:59
 */

class QNode{
	public volatile boolean locked = false;
}
public class CLHLock implements Lock{

	AtomicReference<QNode> tail ;
	ThreadLocal<QNode> myPred;
	ThreadLocal<QNode> myNode;
	
	public CLHLock(){
		tail = new AtomicReference<QNode>(new QNode());
		myPred = new ThreadLocal<QNode>(){
			protected QNode initialValue() {
				return null;
			}
		};
		
		myNode = new ThreadLocal<QNode>(){
			protected QNode initialValue() {
				return new QNode();
			}
		};
	}
	
	@Override
	public void lock() {
		// TODO Auto-generated method stub
		QNode node = myNode.get();

		node.locked = true;
		QNode pre = tail.getAndSet(node);
		myPred.set(pre);  
		while(pre.locked){
			
		}
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		QNode node = myNode.get();
		node.locked = false;
		myNode.set(myPred.get());  
		//myNode.set(myPred.get());
		//myPred.set(myNode.get());
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		CLHLock handler = new CLHLock();
		RunThread thread1 = new RunThread("1", handler);
		RunThread thread2 = new RunThread("2", handler);
		RunThread thread3 = new RunThread("3", handler);
		RunThread thread4 = new RunThread("4", handler);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

class RunThread extends Thread{
	private CLHLock lock;
	private static int num = 0;
	public RunThread(String name,CLHLock lock){
		super(name);
		this.lock = lock;
	}
	public void run(){
		while(true){
		//	System.out.println("Thread "+getName()+ "begin to  get lock");
			this.lock.lock();
			System.out.println("CLH Thread "+getName()+ " get lock, "+ " number is "+num);
			num = num + 1;
	//		System.out.println("Thread "+getName()+ "begin to   unlock");
			this.lock.unlock();
		//	System.out.println("Thread "+getName()+ " unlock");
			try {
				Thread.sleep((Math.abs(new Random().nextInt()%1000)+100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
