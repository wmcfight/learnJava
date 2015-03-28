/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Descriptions of the class ZkQueue.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月26日 下午6:29:42
 */
public class ZkQueue {
	private BlockingQueue<InsertBean> dataQueue = new ArrayBlockingQueue<InsertBean>(1000000);
	private static int poolSize = 20;
	private ExecutorService executor = Executors.newFixedThreadPool(poolSize);
	
	public void start(){
		for(int i=0;i<poolSize;i++){
			executor.execute(new InsertDb());
		}
	}
	
	class InsertDb implements Runnable{

		@Override
		public void run() {
			while (true) {
				System.out.println("1111");
				
			}
			// TODO Auto-generated method stub
			
//			while(dataQueue.size() > 0){
//				
//				try {
//					InsertBean temp = dataQueue.take();
//					//insert operation
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
		} 
		
	}
	
	public static void main(String[] args) {
//		ZkQueue zkQueue = new ZkQueue();
//		zkQueue.start();
		ArrayList<Integer> data1 = new ArrayList<Integer>();
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		data1.add(1);
		data1.add(2);
		data1.add(3);
		for(Integer item: data1){
			System.out.println(item);
		}
		//System.arraycopy(data1, 0, data2, 0, data1.size());
		//Collections.copy(data1, data2);
		data2 = data1;
		for(Integer item: data2){
			System.out.println(item);
		}
		
		//System.arraycopy(src, srcPos, dest, destPos, length);

	}
}
