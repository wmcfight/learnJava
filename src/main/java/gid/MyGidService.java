package gid;

/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Descriptions of the class MyGidService.java's implementation：TODO described
 * the implementation of class
 * 
 * @author wmc 2014年4月16日 下午4:46:26
 */
public class MyGidService {
	private AtomicLong curversion = new AtomicLong(0);
	private int maxversion = 0;
	private String url, user, password;
	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection connection = null;
	private static MyGidService uniqueHandler = null;
	private static int INC = 100000;
	private static Object lock = new Object();
	private static AtomicBoolean reconnect = new AtomicBoolean(true);
	private static ScheduledExecutorService sample = null;

	private void checkConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			reconnect();
		}
	}

	private void updateVersionByMem() {
		maxversion += INC;
	}

	private void updateVersion() {
		synchronized (curversion) {
			if (reconnect.get()) {
				try {

					checkConnection();
					Statement statement = connection.createStatement();
					ResultSet res = statement
							.executeQuery("select id from curversion limit 1");
					if (res.next()) {
						maxversion = res.getInt(1) + INC;

					}
				} catch (Exception e) {
					updateVersionByMem();
					reconnect();
					reconnect.set(false);
					// e.printStackTrace();
					System.out.println("Cannot connect mysql-----------------");
					// System.exit(-1);

				}
			}else{
				updateVersionByMem();
			}
			System.out.println("Update version is -------------------"
					+ maxversion);
		}
		
	}

	public List<Long> getVersion(int num) {
		synchronized (curversion) {
			long cur = curversion.get();
			if (cur + num >= maxversion) {
				// System.out.println("Begin to update !!!!!!!!!");
				updateVersion();
				// System.out.println("Begin to insert !!!!!!!!!");
				insertVersion();
			}

			ArrayList<Long> dataArrayList = new ArrayList<Long>();
			for (int i = 1; i <= num; i++) {
				dataArrayList.add(cur + i);
			}
			if (curversion.addAndGet(num) % 100000 == 0) {
				// System.out.println("Now use version is " + curversion.get());
			}
			return dataArrayList;
		}

	}

	private void insertVersion() {
		if (reconnect.get()) {
			try {

				checkConnection();
				Statement statement = connection.createStatement();
				statement.execute(new String("update curversion set id = "
						+ maxversion + ";"));
			
			} catch (Exception e) {
				reconnect();
			}
		}
		
		System.out.println("Insert version is *******************"
				+ maxversion);
	}

	private void init() {
		reconnect();
		if (maxversion == 0) {
			updateVersion();
			insertVersion();
			if (maxversion == 0) {
				System.out.println("Cannot connect mysql db, exit!!!");
				System.exit(-1);
			}
		}

	}

	private void reconnect() {
		if(reconnect.get()){
			if (connection != null) {
				connection = null;
			}
			try {
				Class.forName(driver);
				try {
					connection = DriverManager.getConnection(url, user, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	private MyGidService(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.password = pass;
		init();
		ScheduledExecutorService sample = Executors.newScheduledThreadPool(1,
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable runnable) {
						// TODO Auto-generated method stub
						Thread thread = new Thread(runnable, runnable
								.toString());
						thread.setDaemon(true);
						return thread;
					}
				});
		sample.scheduleAtFixedRate(new FlagRunnable(), 60, 60, TimeUnit.SECONDS);
	}

	public synchronized static void initailize(String url, String user,
			String pass) {
		if (uniqueHandler == null) {
			uniqueHandler = new MyGidService(url, user, pass);
		}
	}

	public static MyGidService getInstance(String url, String user, String pass) {
		if (uniqueHandler == null) {
			initailize(url, user, pass);
		}
		return uniqueHandler;
	}

	static class FlagRunnable implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			reconnect.set(true);
			System.out.println("Set connect flag to true ------------------");
		}

	}
	
	
}
