/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Descriptions of the class CountLatchSample.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月30日 下午3:10:52
 */
public class CountLatchSample {
	private static CountDownLatch latchSingal;
	private final static int latchSize = 5;
	
	static class SampleThread extends Thread{
		public void run(){
			System.out.println("Thread "+getId() + " echo data !");
			try {
				Thread.sleep(Math.abs(new Random().nextInt()%1000)+100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latchSingal.countDown();
		}
	}
	
	public static void main(String[] args) {
		latchSingal = new CountDownLatch(latchSize);
		for(int i=0;i<latchSize;i++){
			SampleThread thread = new SampleThread();
			thread.start();
		}
		System.out.println("Main thread begin to wait!!");
		try {
			latchSingal.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main thread stop!!!");
	}
}
