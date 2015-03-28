/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Descriptions of the class ExampleThreadFactory.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月13日 下午4:21:24
 */
public class ExampleThreadFactory implements ThreadFactory{
	
	private static final AtomicLong poolNumber = new AtomicLong(1);
	private final ThreadGroup threadGroup;
	private String namePrefix;
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(threadGroup,r,namePrefix+threadNumber.getAndDecrement(),0);
		return thread;
	}
	
	public ExampleThreadFactory(){
		SecurityManager securityManager = System.getSecurityManager();
		threadGroup = (securityManager != null ) ? securityManager.getThreadGroup():
				Thread.currentThread().getThreadGroup();
		namePrefix = "pool-"+poolNumber.getAndDecrement() + "-thread-";
	}

	
}
