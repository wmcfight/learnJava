package learnJava;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

/**
 * <p> @(#)LogWriter.java, 2013-11-5. </p>
 * 
 * Copyright 2013 RenRen, Inc. All rights reserved.
 */

/**
 * 
 * @author wmc
 * 
 */
public class LogWriter {
	private final BlockingQueue<String> queue = null;
	private final LoggerThread loggerThread = null;
	private final PrintWriter writer = null;
	
	private boolean isShutdown;
	private int reservations;

	private class LoggerThread extends Thread {
		public void run() {
			try {
				while(true){
					try {
						synchronized (LogWriter.this) {
							if (isShutdown && reservations ==0) {
								break;
							}
						}
						String msg = queue.take();
						synchronized (LogWriter.this) {
							reservations--;
						}
						writer.println(msg);
					} catch (InterruptedException e) {
						// TODO: handle exception
						
					}
				}
			} finally {
				writer.close();
			}
		}
	}
}
