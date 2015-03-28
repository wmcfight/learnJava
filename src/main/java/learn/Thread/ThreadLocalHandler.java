/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.util.Random;

/**
 * Descriptions of the class ThreadLocalHandler.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月14日 下午5:49:41
 */
public class ThreadLocalHandler implements Runnable{
	private final ThreadLocal<LocalWorker> workerLocal;
	
	
	public ThreadLocalHandler(){
		workerLocal = new ThreadLocal<LocalWorker>();
	}
	
	private LocalWorker getLocalWorker(){
		LocalWorker worker = workerLocal.get();
		if(worker == null){
			worker = new LocalWorker();
			workerLocal.set(worker);
		}
		
		return worker;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		LocalWorker worker = getLocalWorker();
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

	
	public static void main(String[] args) {
		ThreadLocalHandler handler = new ThreadLocalHandler();
		Thread handler1 = new Thread(handler,"Worker 1");
		Thread handler2 = new Thread(handler,"Worker 2");
		handler1.start();
		handler2.start();
	}
}

class LocalWorker{
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "Worker name "+name + " salary "+salary +"\n";
	}
	private int salary;
	private String name;
}
