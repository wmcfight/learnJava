import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * <p> @(#)MyCompletionService.java, 2014-1-7. </p>
 * 
 * Copyright 2014 RenRen, Inc. All rights reserved.
 */

/**
 * 
 * @author wmc
 * 
 */
public class MyCompletionService {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCompletionService myCompletionService = new MyCompletionService();
		myCompletionService.count1();
		myCompletionService.count2();
	}

	public void count1() throws InterruptedException, ExecutionException {
		ExecutorService eService = Executors.newCachedThreadPool();
		
		BlockingQueue<Future<Integer>> bQueue = new LinkedBlockingDeque<Future<Integer>>();
		
		for(int i = 0 ;i!=10;++i){
			Future<Integer> future = eService.submit(getTask());
			bQueue.add(future);
		}
		
		int sum = 0;
		int qSize = bQueue.size();
		for(int i=0;i!=qSize;++i){
			sum += bQueue.take().get();
		}
		
		System.out.println("sum is "+sum);
		eService.shutdown();
	}
	
	public void count2() throws InterruptedException, ExecutionException{
		ExecutorService eService = Executors.newCachedThreadPool();
		CompletionService<Integer> eCompletionService = new ExecutorCompletionService<Integer>(eService);
		for (int i=0;i!=10;++i) {
			eCompletionService.submit(getTask());
		}
		
		int sum = 0;
		for(int i=0;i!=10;++i){
			sum += eCompletionService.take().get();
		}
		
		System.out.println("sum is "+sum);
		eService.shutdown();
	}
	
	public Callable<Integer> getTask(){
		final Random random = new Random();
		Callable<Integer> task = new Callable<Integer>() {
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
					int i = random.nextInt(100);
					int j = random.nextInt(100);
					int sum = i*j;
					 System.out.print(sum+"\t"); 
				return sum;
			}
			
		};
		return task;
	}
	
	
	
}
