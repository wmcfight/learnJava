package learnJava;


import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

import sun.misc.Unsafe;


@SuppressWarnings("restriction")
public class MyCounter{
 
	private static Counter handler;
	public MyCounter(Counter handler){
		this.handler = handler;
	}
	
	public void newRun(String name){
		RunThread handler = new RunThread(name);
		handler.start();
	}
	
	class RunThread extends Thread{
		public  RunThread(String name) {
			super(name);
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				handler.increment();
				System.out.println("Thread "+Thread.currentThread().getName() + " get data "+ handler.getCounter());
			}
		}
	}
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Counter handlerCounter = new SynchronizedCounter();
		MyCounter handler = new MyCounter(handlerCounter);
		for(int i=0;i<10;i++){
			handler.newRun(String.valueOf(i));
		}
	}
	
	
}

class SynchronizedCounter implements Counter{  //Based on synchronized method
	private long counter = 0;

	@Override
	public synchronized void increment() {
		// TODO Auto-generated method stub
		counter++;
	}

	@Override
	public synchronized long getCounter() {
		// TODO Auto-generated method stub
		return counter;
	}
	
}
class ReenLockCounter implements Counter{  //Based on ReenLock method
	private long counter = 0;
	private ReentrantLock lock = new ReentrantLock();
	@Override
	public void increment() {
		// TODO Auto-generated method stub
		lock.lock();
		counter++;
		lock.unlock();
		
	}

	@Override
	public long getCounter() {
		return counter;
	}
	
}
class AtomicCounter implements Counter{   //Based on AtomicLong method
	private AtomicLong counter = new AtomicLong(0);
	@Override
	public void increment() {
		// TODO Auto-generated method stub
		counter.incrementAndGet();
	}

	@Override
	public long getCounter() {
		return counter.get();
	}
	
}
class CASCounterBaseByUnSafe implements learnJava.Counter{  //Base on CAS method from Unsafe class

	@SuppressWarnings("restriction")
	private static Unsafe unsafe;
	private long offset;
	private volatile long counter = 0;
	@SuppressWarnings("restriction")
	public CASCounterBaseByUnSafe() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{ 
		 Field f = Unsafe.class.getDeclaredField("theUnsafe");
		 f.setAccessible(true);
		 unsafe = (Unsafe) f.get(Unsafe.class); 
		 offset = unsafe.objectFieldOffset(CASCounterBaseByUnSafe.class.getDeclaredField("counter"));
	}
	@SuppressWarnings("restriction")
	public void increment(){
		long before = counter;
		while(!unsafe.compareAndSwapLong(this, offset, before, before+1)){
			counter = before;
			System.out.println("Yes!!!");
		}
	}
	
	public long getCounter(){
		return counter;
	}
	
}
