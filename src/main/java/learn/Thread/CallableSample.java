/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Descriptions of the class CallableSample.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月5日 下午2:24:03
 */

class CallableItem implements Callable{

	@Override
	public Integer call() throws Exception {
		return Math.abs(new Random().nextInt()%1000) + 1000;
	}
	
}
public class CallableSample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService services = Executors.newFixedThreadPool(1);
		CallableItem item = new CallableItem();
		Future f1 = services.submit(item);
		
		System.out.println(f1.get());
		
		services.shutdown();
	}
}
