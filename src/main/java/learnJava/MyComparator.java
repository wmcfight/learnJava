package learnJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * <p> @(#)MyArrayList.java, 2014-3-20. </p>
 * 
 * Copyright 2014 RenRen, Inc. All rights reserved.
 */

/**
 *
 * @author wmc
 *
 */
public class MyComparator {
	public static void main(String[] args) {
		ArrayList<CompareBean> dataArrayList = new ArrayList<CompareBean>();
		for(int i=0;i<5;i++){
			dataArrayList.add(new CompareBean(i, "test1"));
		}
		for(int i=15;i>10;i--){
			dataArrayList.add(new CompareBean(i, "test2"));
		}
		
		Collections.sort(dataArrayList, new SimpleComparator());
		
		for(int i=0;i<dataArrayList.size();i++){
			System.out.println(dataArrayList.get(i).toString());
		}
	}
}

class CompareBean{
	int age;
	String name;
	public CompareBean(int age, String name) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.name = name;
	}
	
	public String toString(){
		StringBuffer temp = new StringBuffer();
		temp.append("Name is ").append(name).append(" age is ").append(age);
		return temp.toString();
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
}

class SimpleComparator implements Comparator{

	@Override
	public  int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof CompareBean && o2 instanceof CompareBean){
			return ((CompareBean) o1).getAge() > ((CompareBean) o2).getAge()  ? 1 : -1;
		}
		return 0;
	}
	
}
