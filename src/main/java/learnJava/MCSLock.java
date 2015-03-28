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
 * Descriptions of the class MCSLock.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月29日 下午8:59:19
 */
class MCSQNode{
	public volatile boolean locked = false;
	public MCSQNode next = null;
}
public class MCSLock implements Lock{
	AtomicReference<MCSQNode> tail;
	ThreadLocal<MCSQNode> myNode;
	
	public MCSLock(){
		tail = new AtomicReference<MCSQNode>();
		myNode = new ThreadLocal<MCSQNode>(){
			protected MCSQNode initialValue() {
				return new MCSQNode();
			}
		};
	}
	
	@Override
	public void lock() {
		// TODO Auto-generated method stub
		MCSQNode node = myNode.get();
		MCSQNode pre = tail.getAndSet(node);
		if(pre != null){
			node.locked = true;
			pre.next = node;
			while(node.locked){
				
			}
		}
	}
	
	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		MCSQNode node = myNode.get();
		if(node.next == null){
			if(tail.compareAndSet(node, null))
				return;
			while(node.next == null){
				
			}
		}
		node.next.locked = false;
		node.next = null;
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

	

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
		MCSLock handler = new MCSLock();
		MCSRunThread thread1 = new MCSRunThread("1", handler);
		MCSRunThread thread2 = new MCSRunThread("2", handler);
		MCSRunThread thread3 = new MCSRunThread("3", handler);
		MCSRunThread thread4 = new MCSRunThread("4", handler);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}

class MCSRunThread extends Thread{
	private MCSLock lock;
	private static int num = 0;
	public MCSRunThread(String name,MCSLock lock){
		super(name);
		this.lock = lock;
	}
	public void run(){
		while(true){
			//System.out.println("Thread "+getName()+ "begin to  get lock");
			this.lock.lock();
			System.out.println("MCS Thread "+getName()+ " get lock, "+ " number is "+num);
			num = num + 1;
			//System.out.println("Thread "+getName()+ "begin to   unlock");
			this.lock.unlock();
			//System.out.println("Thread "+getName()+ " unlock");
			try {
				Thread.sleep((Math.abs(new Random().nextInt()%1000)+100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
