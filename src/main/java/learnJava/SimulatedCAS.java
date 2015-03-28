/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Descriptions of the class SimulatedCAS.java's implementation：TODO described
 * the implementation of class
 * 
 * @author wmc 2014年1月12日 下午6:28:24
 */
public class SimulatedCAS {
	private int value;
	
	public synchronized int get() {
		return value;
	}
	
	public synchronized int compareAndSwap(int expectedValue,int newValue){
		int oldValue = value;
		if(oldValue == expectedValue){
			value = newValue;
		}
		return oldValue;
	}
	
	public synchronized boolean compareAndSet(int expectedValue,int newValue){
		return expectedValue  == compareAndSwap(expectedValue, newValue) ? true : false;
	}
	
	public AtomicLongArray list = new AtomicLongArray(10);
}
