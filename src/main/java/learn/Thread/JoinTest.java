/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;


/**
 * Descriptions of the class JoinTest.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月16日 下午1:15:41
 */
public class JoinTest {
	
	
	static class ThreadA extends Thread{
		public ThreadA(String name){
			super(name);
		}
		
		public void run() {
			for(int i=1;i<10;i++){
				System.out.println("Thread "+this.getName() + " read "+i);
			}
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadA handler = new ThreadA("test1");
		System.out.println("Main thread start");
		handler.start();
		handler.join();
		System.out.println("Sun thread stop!");
		System.out.println("Main thread stop!");
	}
}
