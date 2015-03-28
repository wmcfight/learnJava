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
 * Descriptions of the class LinkedListToStack.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月26日 下午4:35:05
 */
public class LinkedListToStack<T> {
	private LinkedList<T> data = new LinkedList<T>();
	
	public T top(){
		if(empty()){
			return null;
		}else{
			return data.getLast();
		}
		
	}
	
	public boolean empty(){
		return data.size() == 0;
	}
	
	public void push(T item){
		data.addLast(item);
	}
	
	public int size(){
		return data.size();
	}
	
	public void pop(){
		try {
			data.removeLast();
		} catch (Exception e) {
			System.out.println("It's empty!");
		}
	}
	
	public static void main(String[] args) {
		LinkedListToStack<Integer> data = new LinkedListToStack<Integer>();
		System.out.println(data.top());
		data.pop();
		data.push(1);
		data.push(2);
		data.push(3);
		while(!data.empty()){
			System.out.println(data.top());
			data.pop();
		}
	}
}
