package concurrent;


import org.apache.commons.collections.CollectionUtils;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by mwei on 15-10-16.
 * use PriorityQueue to kill expired item,
 * so each time get size will get the really size
 * we can use both PriorityBlockingQueue
 */
public class CountInWindow {

    static private class Item {
        private long expiredTime;
        private String data;

        public Item (long expiredTime, String data) {
            this.expiredTime = expiredTime;
            this.data = data;
        }

        public long getExpiredTime() {
            return expiredTime;
        }

        public void setExpiredTime(long expiredTime) {
            this.expiredTime = expiredTime;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    /**
     * Adding a main just for testing
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("test started");
        CountInWindow test = new CountInWindow(5000); //5 seconds for testing
        test.debug = true;
        test.insertTimeStamp(new Item(System.currentTimeMillis() + 10000,"1"));
        Thread.sleep(100);//sleep
        test.insertTimeStamp(new Item(System.currentTimeMillis(),"2"));
        Thread.sleep(100);//sleep
        test.insertTimeStamp(new Item(System.currentTimeMillis(),"3"));
        Thread.sleep(100);//sleep
        test.insertTimeStamp(new Item(System.currentTimeMillis(),"4"));
        Thread.sleep(5040);//sleep 5 secs
        test.insertTimeStamp(new Item(System.currentTimeMillis(),"5"));
        Thread.sleep(100);//sleep
        test.insertTimeStamp(new Item(System.currentTimeMillis(),"6"));
        System.out.println(test.getWindowCount()); //Should be 2 not 6.
        System.out.println("test done");

        while (CollectionUtils.isNotEmpty(test.window)) {
            System.out.println(test.window.poll().getData());
        }
    }

    //java.util.PriorityQueue<Item> window;

    PriorityBlockingQueue<Item> window;
    public static final int FIVE_MINS_IN_MS = 300000;
    public final int WINDOW_SIZE;
    public boolean debug = false;

    //Constructor which defaults to 5mins
    public CountInWindow(){
        WINDOW_SIZE = FIVE_MINS_IN_MS;
        new CountInWindow(WINDOW_SIZE);
    }
    //Constructor for any size window
    public CountInWindow(int windowSize){
        WINDOW_SIZE = windowSize;
//        window = new java.util.PriorityQueue<Item>(100, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return o1.getExpiredTime() > o2.getExpiredTime() ? 1 : -1;
//            }
//        });

        window = new PriorityBlockingQueue<Item>(100, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getExpiredTime() > o2.getExpiredTime() ? 1 : -1;
            }
        });
    }
    /**
     * Add a new timestamp to the window's queue
     * @param ts
     */
    public void insertTimeStamp(Item ts){
        window.add(ts);
    }
    /**
     * Clean up items outside the window size and then return the count of times still in the window.
     * @return A count of timestamps still inside the 5 mins window.
     */
    public int getWindowCount(){
        long currTime = System.currentTimeMillis();
        //Clean out old Timestamps
        while((currTime - window.peek().getExpiredTime()) > WINDOW_SIZE){
            long drop = window.remove().getExpiredTime();
            if(debug)System.out.println("dropping item:" + drop);
        }
        return window.size();
    }
}
