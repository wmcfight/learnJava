/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Descriptions of the class ThreadLocalDemoForDate.java's implementation：TODO
 * described the implementation of class
 * 
 * @author wmc 2014年5月14日 下午11:20:37
 */
public class ThreadLocalDemoForDate extends Thread {
	private DateDemo demo;

	public ThreadLocalDemoForDate(DateDemo demo) {
		this.demo = demo;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			demo.test2();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DateDemo demo = new DateDemo();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			ThreadLocalDemoForDate hanlder = new ThreadLocalDemoForDate(demo);
			hanlder.start();
			hanlder.join();
		}

		System.out.println("Use time is "
				+ (System.currentTimeMillis() - begin));

	}
}

class DateDemo {
	public void test1() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(format.format(new Date()));
	}

	private final static DateFormat FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");

	public void test2() {
		System.out.println(FORMAT.format(new Date()));
	}

	private static ThreadLocal<DateFormat> local = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			// TODO Auto-generated method stub
			return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}

	};

	public void test3() {
		System.out.println(local.get().format(new Date()));
	}
}
