/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;


/**
 * Descriptions of the class OneShotLatch.java's implementation：TODO described the implementation of class
 * @author wmc 2014年1月12日 下午5:35:28
 * @param <Sync>
 */
public class OneShotLatch {


	private final Sync sync = new Sync();
	
	public void  signal() {
		sync.releaseShared(0);
	}
	
	public void await() throws InterruptedException  {
		sync.acquireSharedInterruptibly(0);
	}
	
	
	private class Sync extends AbstractQueuedSynchronizer{
		protected int tryAcquiredShared(int ignored){
			return getState() == 1 ? 1 : -1;
		}
		
		protected boolean tryReleaseShared(int ignored) {
			setState(1);
			return true;
		}
	 }
	
	
}
