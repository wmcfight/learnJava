/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * Descriptions of the class MyMap.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月31日 下午3:42:55
 */
public class MyMap {
	private TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
	
	public void init(){ 
		treeMap.put("1", 1);
		treeMap.put("2", 2);
		treeMap.put("3", 3);
		
		Iterator iterator = treeMap.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry)iterator.next();
			System.out.println("key is "+entry.getKey() + " value is "+entry.getValue());
			

		}
	}
	
	public static void main(String[] args) {
		MyMap handlerMap = new MyMap();
		handlerMap.init();
	}
}

