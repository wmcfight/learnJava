/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Descriptions of the class yelidTest.java's implementation：TODO described the
 * implementation of class
 * 
 * @author wmc 2014年4月16日 上午11:27:50
 */
public class yelidTest extends Thread {

	

	public yelidTest(String name) {
		super(name);
	}


	public static void main(String[] args) {
		ThreadA thread1 = new ThreadA("test1");
		ThreadA thread2 = new ThreadA("test2");

		thread1.start();
		thread2.start();
	}


}

class ThreadA extends Thread {
	private static Object lock = new Object();
	public ThreadA(String name) {
		super(name);
	}
	// TODO Auto-generated constructor stub
	
	public   void run(){
		synchronized (lock) {
			for (int i = 1; i < 10; i++) {
				System.out.println("Thread " + this.getName() + " degree "
						+ this.getPriority() + " run " + i);
				if (i % 4 == 0) {
					System.out.println("Thread "+this.getName() +" begin to yield！！！");
					this.yield();
				}
			}
		}
		
	}
}
