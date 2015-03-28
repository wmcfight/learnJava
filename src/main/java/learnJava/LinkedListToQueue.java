/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.LinkedList;

/**
 * Descriptions of the class LinkedListToQueue.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月26日 下午4:30:25
 */
public class LinkedListToQueue<T> {
	private LinkedList<T> data = new LinkedList<T>();
	
	public T front(){
		return empty() ? null : data.getFirst();
	}
	
	public int size(){
		return data.size();
	}
	
	public void push(T item){
		data.addLast(item);
	}
	
	public void pop(){
		if(!empty()){
			data.removeFirst();
		}
	}
	
	public boolean empty(){
		return data.size() == 0;
	}
	
	public static void main(String[] args) {
		LinkedListToQueue<Integer> data = new LinkedListToQueue<Integer>();
		data.push(1);
		data.push(2);
		data.push(3);
		
		while(!data.empty()){
			System.out.println(data.front());
			data.pop();
		}
	}
}
