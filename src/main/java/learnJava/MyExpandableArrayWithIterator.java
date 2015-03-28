/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Descriptions of the class MyExpandableArrayWithIterator.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月19日 下午5:50:37
 */
public class MyExpandableArrayWithIterator extends MyExpandableArray{

	protected int version = 0;
	public MyExpandableArrayWithIterator(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public synchronized void add(Object x) {
		// TODO Auto-generated method stub
		super.add(x);
		++version;
	}
	@Override
	public synchronized void removeLast() throws NoSuchElementException {
		// TODO Auto-generated method stub
		super.removeLast();
		++version;
	}
	
	public synchronized Iterator iterator(){
		//return EA
		return new EAIterator();
	}
	
	protected class EAIterator implements Iterator{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		
	}

}
