/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Descriptions of the class FastFail.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月26日 上午11:20:51
 */
public class FastFail {
	private static List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		new OneThread().start();
		new TwoThread().start();
	}
	
	private static class OneThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i = 0;
			System.out.println("Begin one thread");
			while(i<6){
				
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
		}  
		
	}
	
	private static class TwoThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i = 10;
			System.out.println("Begin two thread");
			while(i<16){
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
		} 
		
	}
	private static void printAll(){
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(" "+ iterator.next());
		}
	}
	
}
