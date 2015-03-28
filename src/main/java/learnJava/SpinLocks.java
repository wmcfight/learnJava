/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Descriptions of the class SpinLocks.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月29日 下午8:12:49
 */
public class SpinLocks {

}

class SpinLock {
	private AtomicReference<Thread> owner = new AtomicReference<Thread>();
	
	public void lock(){
		Thread curThread = Thread.currentThread();
		while(owner.compareAndSet(null, curThread)){
		}
	}
	
	public void unlock(){
		Thread curThread = Thread.currentThread();
		owner.compareAndSet(curThread, null);
	}
}

class TicketLock{
	private AtomicInteger serviceNum = new AtomicInteger();
	private AtomicInteger ticketNum = new AtomicInteger();
	
	public int lock(){
		int myTicketNum = ticketNum.getAndIncrement();
		while(serviceNum.get() != myTicketNum){
			
		}
		return myTicketNum;
	}
	
	public void unlock(int myTicket){
		int nextTicket = myTicket +1;
		serviceNum.compareAndSet(myTicket, nextTicket);
	}
	
}

