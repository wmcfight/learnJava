/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package fileStream;

import java.util.Scanner;

/**
 * Descriptions of the class ScreenStream.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月11日 下午11:35:36
 */
public class ScreenStream {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input the data");
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextInt());
	}
}
