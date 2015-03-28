/**
 * <p> @(#)QueueFuture.java, 2013-10-30. </p>
 * 
 * Copyright 2013 RenRen, Inc. All rights reserved.
 */
package learnJava;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 
 * @author wmc
 * @param <V>
 * 
 */

public class Renderer<V> {
	private ExecutorService executor;
	private ArrayList<Integer> data = new ArrayList<Integer>();

	void renderPage() {
		CompletionService<V> completionService = new ExecutorCompletionService<V>(
				executor);
		for (Integer item : data) {
			completionService.submit(new Callable<V>() {

				@Override
				public V call() throws Exception {
					// TODO Auto-generated method stub
					V dataV = null;
					return dataV;
				}
			});
		}

		try {
			Future<V> data = completionService.take();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test() {

	}
}