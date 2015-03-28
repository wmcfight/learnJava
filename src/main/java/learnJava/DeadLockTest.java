package learnJava;

/**
 * Created by wmc on 2014/7/2.
 */
public class DeadLockTest {
    private Object add = new Object();
    private Object desc = new Object();
    public DeadLockTest() {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    public void doAdd() {
        synchronized (add) {
            synchronized (desc) {
                System.out.println("Add data successfully!");
                try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }

    public void doDesc() {
        synchronized (desc) {
            synchronized (add) {
                System.out.println("Desc data successfully!");
                try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }

    class Thread1 implements Runnable {

        @Override
        public void run() {
        	while (true) {
        		 doAdd();
			}
           
        }
    }

    class Thread2 implements Runnable {

        @Override
        public void run() {
        	while (true) {
       		  doDesc();
			}
        }
    }

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();

    }



}

