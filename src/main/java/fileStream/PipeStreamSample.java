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
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Descriptions of the class PipeStreamSample.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月30日 下午6:49:46
 */
public class PipeStreamSample {
	public static void main(String[] args) throws IOException {
		PipedInputStream pis = new PipedInputStream();
		ConsumerStream consumerStream = new ConsumerStream(pis);
		ProducerStream producerStream = new ProducerStream(pis);
		new Thread(consumerStream).start();
		new Thread(producerStream).start();
	}
}

class ProducerStream implements Runnable{
	private DataInputStream inputStream;
	public ProducerStream(PipedInputStream stream){
		inputStream = new DataInputStream(stream);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				while (true) {
					if (inputStream.available() > 1) {
						int size = inputStream.readInt();
						byte[] data = new byte[size];
						//System.out.println("pos is "+dataPos + " size is "+size);
						int count = inputStream.read(data, 0, size);
						System.out.println("Get Result is "+new String(data,"UTF-8"));
					}else{
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					inputStream.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}

class ConsumerStream implements Runnable{
	private DataOutputStream outputStream;
	public ConsumerStream(PipedInputStream stream) throws IOException{
		outputStream = new DataOutputStream(new PipedOutputStream(stream));
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
}
