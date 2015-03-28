/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

/**
 * Descriptions of the class ListUsingMutex.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月9日 下午10:48:39
 */
public class ListUsingMutex {
	static class Node{
		Node next;
		Object item;
		Mutex lock = new Mutex();
		Node(Object x,Node n){
			item = x;
			next = n;
		}
	}
	
	protected Node head;
	
	protected synchronized Node getHead(){
		return head;
	}
	
	public synchronized void add(Object x){
		if(x == null) return ;
		head = new Node(x, head);
	} 
	
	public boolean search(Object x) {
		Node pNode = getHead();
		
		if(pNode == null || x == null) return false;
		
		try {
			pNode.lock.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(;;){ 
			Node nextP = null;
			boolean find = false;
			try {
				find = x.equals(pNode.item);
				if(!find){
					nextP = pNode.next;
					if(nextP != null){
						try {
							nextP.lock.acquire();
						} catch (Exception e) {
							// TODO: handle exception
						}
						
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{ 
				pNode.lock.release();
			}
			
			if(find){
				return true;
			}else if(nextP == null){
				return false;
			}else{
				pNode = nextP;
			}
		}
		//return false;
	} 

	public static void main(String[] args) {
		final ListUsingMutex handler = new ListUsingMutex();
		handler.add(1);
		handler.add(2);
		handler.add(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0;j<10;j++){
						boolean find = handler.search(j);
						System.out.println("Result " + j+ (find?" find ":"no find"));
					}
					
				}
			});
		}
	}
}
