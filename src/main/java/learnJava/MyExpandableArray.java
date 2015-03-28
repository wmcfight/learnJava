/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.NoSuchElementException;

/**
 * Descriptions of the class MyExpandableArray.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月19日 下午5:51:29
 */
public class MyExpandableArray {
	protected Object[] data;
	protected int size;
	
	public MyExpandableArray(int capacity){
		data = new Object[capacity];
	}
	
	public int size(){
		return size();
	}
	
	public synchronized Object get(int index) throws NoSuchElementException{
		if(index < 0 || index>=size){
			throw new NoSuchElementException();
		}
		
		return data[index];
	}
	
	public synchronized void add(Object x){
		if(size == data.length){
			Object[] olddataObjects = data;
			data = new Object[3*(size+1)/2];
			System.arraycopy(olddataObjects, 0, data, 0, olddataObjects.length);
		}
		data[size++] = x;
	}
	
	public synchronized void removeLast() throws NoSuchElementException{
		if(size == 0){
			throw new NoSuchElementException();
		}
		
		data[--size] = null;
	}
}
