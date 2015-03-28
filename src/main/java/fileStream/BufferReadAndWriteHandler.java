/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package fileStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


/**
 * Descriptions of the class BufferReadAndWriteHandler.java's
 * implementation：TODO described the implementation of class
 * 
 * @author wmc 2014年5月12日 下午6:20:55
 */
public class BufferReadAndWriteHandler {
	public static void main(String[] args) {
		String filename = "./file/BufferedReadandWriter";
		try {
			BufferWriter writer = new BufferWriter(filename);
			writer.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			BufferReader reader = new BufferReader(filename);
			reader.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class BufferReader extends Thread {
	private static BufferedReader reader;
	private static String filename;

	public BufferReader(String filename) throws FileNotFoundException {
		this.filename = filename;
		reader = new BufferedReader(new FileReader(new File(filename)));
	}

	public void run() {
		StringBuffer sBuffer = new StringBuffer();
		int i = 0;
		int sum = 0;
		while (true) {
			char[] buffer = new char[1024];
			int total = 0;
			try {
				while (true) {
					if(reader.ready()){
						int len = reader.read(buffer);
						sBuffer.append(buffer);
						
						total += len;
						sum += total;
						if (total >= 1024) {
							break;
						}
						
						String result = sBuffer.toString();
						System.out.printf(
								"Get %d message,size is %d , content is %s\n", i++,
								sum, result);
						sBuffer = new StringBuffer("");
						total = 0;
						sum = 0;
						//finish one time read
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
		}
	}
}

class BufferWriter extends Thread {
	private static BufferedWriter writer;
	private static String filename;

	public BufferWriter(String filename) throws IOException {
		this.filename = filename;
		writer = new BufferedWriter(new FileWriter(new File(filename)));
	}

	private String getRandow(int length) {
		StringBuilder sbBuilder = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char temp = (char) ('a' + Math.abs((new Random()).nextInt() % 26));
			sbBuilder.append(temp);
		}

		return sbBuilder.toString();
	}

	public void run() {
		int i = 0;
		try {
			while (true) {
				String content = getRandow(Math
						.abs(new Random().nextInt() % 100 + 100));
				writer.write(content.toCharArray());
				writer.flush();
				System.out.printf(
						"Send %d message,size is %d ,content is %s\n", i++,
						content.length(), content);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
