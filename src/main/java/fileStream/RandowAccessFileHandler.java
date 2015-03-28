/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package fileStream;

import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Descriptions of the class RandowAccessFileHandler.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月12日 下午6:49:36
 */
public class RandowAccessFileHandler {
	
	private String filename;
	private RandomAccessFile randomAccessFile;
	public RandowAccessFileHandler(String filename) throws FileNotFoundException{
		
		this.filename = filename;
		randomAccessFile = new RandomAccessFile(filename, "rw");
	}
	
	public RandomAccessFile getHandler(){
		return randomAccessFile;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		RandowAccessFileHandler handler = new RandowAccessFileHandler("./file/RandomAccessFile");
		RandomWriter writer = new RandomWriter(handler.getHandler());
		RandomReader reader = new RandomReader(handler.getHandler());
		writer.start();
		reader.start();
	}

}

class RandomWriter extends Thread{
	private RandomAccessFile accessFile;
	public RandomWriter(RandomAccessFile handler){
		accessFile = handler;
	}
	
	private String getRandow(int length) {
		StringBuilder sbBuilder = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char temp = (char) ('a' + Math.abs((new Random().nextInt()%26)));
			sbBuilder.append(temp);
		}

		return sbBuilder.toString();
	}
	
	public void run(){
		int i = 0;
		try {
			while (true) {
				String content = getRandow(Math
						.abs(new Random().nextInt() % 100 + 100));
				accessFile.write(content.getBytes());
				//accessFile.flush();
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


class RandomReader extends Thread{
	private RandomAccessFile accessFile;
	public RandomReader(RandomAccessFile handler) throws FileNotFoundException{
		accessFile = new RandomAccessFile("./file/RandomAccessFile", "rw");
		//accessFile = handler;
	}
	
	public void run(){
		StringBuffer sBuffer = new StringBuffer();
		int i = 0;
		int sum = 0;
		while (true) {
			byte[] buffer = new byte[8192];
			int total = 0;
			try {
				while (true) {
					//if(accessFile.ready()){
					//if(accessFile.readBoolean())
						int len = accessFile.read(buffer);
						//System.out.println("Size is "+len);
						if(len < 0){
							Thread.sleep(1000);
							continue;
						}
						sBuffer.append(new String(buffer));
						
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
				//}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
		}
	}
}
