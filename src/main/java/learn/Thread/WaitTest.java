/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.nio.channels.SocketChannel;

/**
 * Descriptions of the class WaitTest.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月16日 上午10:57:42
 */
public class WaitTest implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {           //must to do
			System.out.println("Begint to run!!!!!");
			this.notify();
			
			System.out.println("I'm finish!!!!!!!!");
		}
		
	}
	
	
	public static void main(String[] args) {
		WaitTest handlerTest = new WaitTest();
		Thread mythread = new Thread(handlerTest);
		mythread.start();
		
		System.out.println("Beign to notify!!");
		synchronized (mythread) {   //must to do
			try {
				mythread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Finish!!!");
	}
}
