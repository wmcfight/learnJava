/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.io.Serializable;

/**
 * Descriptions of the class learnTransient.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月10日 下午5:38:08
 */
public class learnTransient implements Serializable{
	private int age;
	
	private transient String pwd;
	
	public learnTransient(int age, String pwd){
		this.age = age;
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	
	
	
	
}
