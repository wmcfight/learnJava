/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package fileStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Descriptions of the class FileOutStream.java's implementation：TODO described
 * the implementation of class
 * 
 * @author wmc 2014年4月22日 下午10:16:03
 */
public class FileOutStream implements Runnable {
	private DataOutputStream outputStream;

	public FileOutStream(String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		}
		outputStream = new DataOutputStream(new FileOutputStream(file));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			while (true) {
				System.out.println("Send data up to "+i);
				String temp = String.valueOf("Input data " + i);
				outputStream.writeInt(temp.getBytes("UTF-8").length);
				outputStream.write(temp.getBytes("UTF-8"));
				outputStream.flush();
				i++;
				Thread.sleep(100);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				outputStream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		FileOutStream handler = new FileOutStream("testFileStream");
		new Thread(handler).start();
	}
	

}
