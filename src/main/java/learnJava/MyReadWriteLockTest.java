package learnJava;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class MyReadWriteLockTest extends Thread{
	MyReadWriteLock lock;
	private int threadId;
	public MyReadWriteLockTest(MyReadWriteLock lock,int threadNum){
		this.lock = lock;
		this.threadId = threadNum;
	}
	
	public void doRead() throws InterruptedException {
		lock.readLock();
		System.out.println("Thread "+threadId + " do read!");
	    Thread.sleep(Math.abs((new Random().nextInt())%1000));
		lock.readUnLock();
		System.out.println("Thread "+threadId + " done read!");
	}
	
	public void doWrite() throws InterruptedException{
		lock.writeLock();
		System.out.println("Thread "+threadId+ " do write!");
		Thread.sleep(Math.abs((new Random().nextInt())%5000));
		lock.writeUnLock();
		System.out.println("Thread "+threadId+ " done write!");
	}  
	
	@Override
	public void run(){
		Random random = new Random();
		int data = random.nextInt();
		if(data % 2 == 0){
			try {
				doRead();
				Thread.sleep(5000);
				doWrite();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			
			try {
				doWrite();
				Thread.sleep(1000);
				doRead();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	
    public static void main(String[] args) {
    	ExecutorService list = Executors.newCachedThreadPool();
    	MyReadWriteLock lock = new MyReadWriteLock(true);
    	for (int i = 0; i < 10; i++) {
			list.submit(new MyReadWriteLockTest(lock, i));
		}
    	list.shutdown();
	}
    


}
