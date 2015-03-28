/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.lang.management.ThreadInfo;
import java.util.Random;

/**
 * Descriptions of the class ThreadLocalSameMethodBySync.java's implementation：TODO described the implementation of class
 * Implement the same function by synchronized comparing to threadlocal
 * @author wmc 2014年5月14日 下午6:02:43
 */
public class ThreadLocalSameMethodBySync implements Runnable{
	private LocalWorker worker;
	
	public ThreadLocalSameMethodBySync(){
		worker = new LocalWorker();
	}

	@Override
	public void run() {
		synchronized (worker) {
			// TODO Auto-generated method stub
			worker.setName(Thread.currentThread().getName());
			int salary = Math.abs(new Random().nextInt() % 1000 + 1000);
			worker.setSalary(salary);
			System.out.print("Thread "+ Thread.currentThread().getName()+" Salary" + salary + " " + worker.toString());
			salary = Math.abs(new Random().nextInt() % 1000 + 1000);
			worker.setSalary(salary);
			System.out.print("Thread "+ Thread.currentThread().getName()+" Salary" + salary + " " + worker.toString());
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("Thread "+ Thread.currentThread().getName()+" Salary" + salary + " " + worker.toString());
		}
		
	}
	
	public static void main(String[] args) {
		ThreadLocalSameMethodBySync handler = new ThreadLocalSameMethodBySync();
		Thread handler1 = new Thread(handler,"Worker 1");
		Thread handler2 = new Thread(handler,"Worker 2");
		handler1.start();
		handler2.start();
	}
	
	
}
