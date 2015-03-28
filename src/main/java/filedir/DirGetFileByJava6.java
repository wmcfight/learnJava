/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package filedir;

import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Descriptions of the class DirGetFileByJava6.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月23日 下午6:06:04
 * @param <T>
 */
//用java 6的方式监控文件夹
public class DirGetFileByJava6 implements Runnable{
	private String dirname;
	private File dir;
	
	public DirGetFileByJava6(String dirname){
		this.dirname = dirname;
		dir = new File(dirname);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Set<File> cSet = new HashSet<File>();
		Set<File> nSet = new HashSet<File>();
		
		while(true){
			for(File file: dir.listFiles()){
				if(!cSet.contains(file)){
					System.out.println("New file is "+file.getAbsolutePath());
				}else{
					cSet.remove(file);
				}
				
				nSet.add(file);
			}
			
			for(File fileItem : (File[])cSet.toArray(new File[0])){
				System.out.println("Delete file is "+fileItem.getAbsolutePath());
			}
			
			cSet = nSet;
			nSet = new HashSet<File>();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public static <T> void swapHashSet(Set<T> a, Set<T> b){
		System.out.println("Before a size is "+a.size() + " b size is "+b.size());
		Set<T> temp = new HashSet<T>();
		temp = a;
		a = b;
		b = temp;
		System.out.println("Before a size is "+a.size() + " b size is "+b.size());
		
	}
	
	public static void swapInt(int a,int b){
		Reference<Integer> handler = new WeakReference<Integer>(a);
		Reference<Integer> handler1 = new WeakReference<Integer>(b);
		a = handler1.get();
		b = handler.get();
		System.out.println("a is "+a+" b is "+b);
	}
	
	public static void main(String[] args) {
//		DirGetFileByJava6 handler = new DirGetFileByJava6("./file");
//		new Thread(handler).start();
		
		int a = 1, b =2;
		System.out.println("a is "+a+" b is "+b);
		a = b;
		System.out.println("a is "+a+" b is "+b);
		b = 3;
		System.out.println("a is "+a+" b is "+b);
		DirGetFileByJava6.swapInt(a, b);
		System.out.println("a is "+a+" b is "+b);
//		
	   
		//A handler1 = new A(handler1);
//		A a = new A() ;
//		A b = new A();
//		a.add(1);
//		System.out.println("a size is "+a.size()+ " b size is "+b.size());
//		a.swap(b);
//	//	DirGetFileByJava6.swapHashSet(a, b);
//		System.out.println("a size is "+a.size()+ " b size is "+b.size());
		
	}
	
	static class A implements Set{
		private Set<Integer> innerSet;
		public A(){
			this.innerSet = new HashSet<Integer>();
		}
		
		public void swap(Set o){
			if(o instanceof A){
				Set tempSet = ((A)o).innerSet;
				((A)o).innerSet = this.innerSet;
				this.innerSet = tempSet;
			}
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return this.innerSet.size();
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray(Object[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add(Object e) {
			// TODO Auto-generated method stub
			return this.innerSet.add((Integer) e);
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
	}
		
}
