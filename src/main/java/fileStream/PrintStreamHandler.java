/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package fileStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;

/**
 * Descriptions of the class PrintStreamHandler.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月12日 下午12:18:25
 */
public class PrintStreamHandler {
	private static String filename = "./file/testfile.txt";
	public static void main(String[] args) {
		testWrite();
		testRead();
	}
	
	private static void testRead(){
		try {
			DataInputStream inputStream = new DataInputStream(new FileInputStream(filename));
			while(inputStream.available() > 0){
				System.out.println(inputStream.readLine());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static void testWrite(){
		try {
			PrintStream stream = new PrintStream(filename);
			
			stream.println("just test 1");
			stream.print("test 2");
			stream.append("   test 3");
			stream.flush();
			stream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
