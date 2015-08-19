package guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wmc on 2015/8/16.
 */
public class RateLimit {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(10.0);


        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task(rateLimiter));
        }
    }

    static class Task implements Runnable {
        private RateLimiter rateLimiter;

        public Task(RateLimiter rateLimiter) {
            this.rateLimiter = rateLimiter;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    rateLimiter.acquire();
                    System.out.println("Thread id "  + Thread.currentThread() + " get request " + System.currentTimeMillis());
                }
            } catch (Exception e) {
                // break
            }
        }
    }
}
