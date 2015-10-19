package concurrent;

import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwei on 15-10-16.
 */
public class DelayQueueSample {

    private static DelayQueue<DelayTask> queue = new DelayQueue<DelayTask>();

    public static void main(String[] args) {
        DelayTask element1 = new DelayTask(1000l, "1");
        DelayTask element2 = new DelayTask(2000l, "2");
        DelayTask element3 = new DelayTask(3000l, "3");

        queue.add(element1);
        queue.add(element2);
        queue.add(element3);

        try {
            Thread.sleep(1500l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Iterator itr = queue.iterator();
        while (itr.hasNext()) {
            ((DelayTask)itr.next()).run();
        }
    }

    static class DelayTask implements Delayed,Runnable {
        public long                      time     = 0;
        public long                      delay;
        public String name;

        public DelayTask(long delay, String name) {
            this.delay = delay;
            time = System.nanoTime() + TimeUnit.NANOSECONDS.convert(this.delay, TimeUnit.NANOSECONDS);
            this.name = name;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.time < ((DelayTask )o).time ) {
                return -1;
            } else if (this.time > ((DelayTask )o).time) {
                return 1;
            }
            return 0;
        }

        @Override
        public void run() {
            System.out.println("Now task begin to run " + name);
        }
    }
}
