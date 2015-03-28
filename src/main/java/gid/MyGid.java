/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package gid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Descriptions of the class MyGid.java's implementation：TODO described the
 * implementation of class
 * 
 * @author wmc 2014年4月16日 下午3:36:25
 */
public class MyGid extends Thread {
	private String url, user, password;
	private static String driver = "com.mysql.jdbc.Driver";
	

	public MyGid(String url, String user, String password,String name)
			throws ClassNotFoundException {
		super(name);
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Connection getConnect() throws SQLException {
		Connection connection = DriverManager
				.getConnection(url, user, password);
		return connection;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			ArrayList<Long> dataSet = (ArrayList<Long>) MyGidService.getInstance(url, user, password).getVersion(1);
			System.out.println("Thread "+this.getName() + " get version "+dataSet.get(0) );
		}

	}

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://10.3.18.39:3306/test";
		String user = "root";
		String password = "123456";
		for (int i = 0; i < 100; i++) {
			MyGid handlerGid = new MyGid(url, user, password,new String("test "+i));
			handlerGid.start();
		}

//		ScheduledExecutorService sample = Executors.newScheduledThreadPool(1,
//				new ThreadFactory() {
//					@Override
//					public Thread newThread(Runnable runnable) {
//						// TODO Auto-generated method stub
//						Thread thread = new Thread(runnable, runnable
//								.toString());
//						thread.setDaemon(true);
//						return thread;
//					}
//				});

		//sample.scheduleAtFixedRate(new StopRunnable(), 10, 10, TimeUnit.SECONDS);
	}

	static class StopRunnable implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.exit(-1);
		}

	}

}
