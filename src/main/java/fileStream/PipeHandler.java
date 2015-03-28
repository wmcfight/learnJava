/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package fileStream;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;

/**
 * Descriptions of the class PipeHandler.java's implementation：TODO described
 * the implementation of class
 * Continut read/write by PipedWriter,PipedReader
 * 
 * @author wmc 2014年5月12日 下午5:00:06
 */
public class PipeHandler {
	public static void main(String[] args) throws IOException {
		PipeReader pipedReader = new PipeReader();
		PipeWriter pipedWriter = new PipeWriter();
		pipedReader.getReader().connect(pipedWriter.getWriter());
		pipedWriter.start();
		pipedReader.start();

	}
}

class PipeReader extends Thread {
	private PipedReader reader = new PipedReader();

	public PipedReader getReader() {
		return reader;
	}

	public void run() {
		StringBuffer sBuffer = new StringBuffer();
		int i = 0;
		int sum = 0;
		
		while (true) {
			
			int total = 0;
			char[] buffer = new char[1024];
			try {
				while (true) {
					int len = reader.read(buffer);
					total += len;
					sBuffer.append(buffer);
					sum += total;
					//System.out.printf("Get %d message size is %d,sum is %d \n",i,len,sum);
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				try {
					reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}finally{
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}

class PipeWriter extends Thread {
	public void run() {
		int i = 0;
		try {
			//while (true) {
				String content = getRandow(Math
						.abs(new Random().nextInt() % 100 + 100));
				writer.write(content.toCharArray());
				writer.flush();
				System.out.printf(
						"Send %d message,size is %d ,content is %s\n", i++,
						content.length(), content);
				Thread.sleep(1000);
			//}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block

		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private String getRandow(int length) {
		StringBuilder sbBuilder = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char temp = (char) ('a' + Math.abs((new Random()).nextInt() % 26));
			sbBuilder.append(temp);
		}

		return sbBuilder.toString();
	}

	private PipedWriter writer = new PipedWriter();

	public PipedWriter getWriter() {
		return writer;
	}

}