package test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by mingchuw on 16/7/5.
 */
public class TestFuture {

//    private ExecutorService executors =  Executors.newFixedThreadPool(100);
//    private volatile Cache<String, Pair<CountDownLatch, CountDownLatch>> weakMap = CacheBuilder.newBuilder().expireAfterWrite(5000l, TimeUnit.MILLISECONDS).build();
//    private volatile Map<String, ArrayList<ReturnResult>> resultMap = new ConcurrentHashMap<>();
//
//    private List<Future> add(List<Long> data, String uuid) {
//        weakMap.put(uuid, new Pair<>(new CountDownLatch(1), new CountDownLatch(1)));
//        List<Future> result = new ArrayList<>();
//
//        for (Long item : data) {
//            TaskCallable callable = new TaskCallable(item, uuid);
//            executors.execute(callable);
//        }
//
//        return result;
//
//
//    }
//
//    private void batch(String uuid) {
//        Pair<CountDownLatch, CountDownLatch> pair = weakMap.getIfPresent(uuid);
//        if (pair != null) {
//            try {
//                pair.snd.countDown();
//                pair.fst.await(1000l, TimeUnit.MILLISECONDS);
//                List<ReturnResult> results = resultMap.get(uuid);
//                if (CollectionUtils.isNotEmpty(results)) {
//                    results.forEach(item ->
//                    {
//                        System.out.println(item);
//                    });
//                } else {
//                    System.out.println("Empty !!!!!");
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Data
//    @AllArgsConstructor
//    class ReturnResult {
//        private Long data;
//        private String uuid;
//        private Long result;
//    }
//
//    class TaskCallable implements Runnable {
//        private Long data;
//        private String uuid;
//
//        public TaskCallable(Long data, String uuid) {
//            this.data = data;
//            this.uuid = uuid;
//        }
//
//        @Override
//        public void run() {
//            try {
//                Thread.currentThread().sleep(RandomUtils.nextInt(1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Pair<CountDownLatch, CountDownLatch> pair = weakMap.getIfPresent(uuid);
//            if (pair != null) {
//                if (pair.fst.getCount() >= 1) {
//                    try {
//                        System.out.println(Thread.currentThread() + " begin to await!!!");
//                        pair.snd.await(1000l, TimeUnit.MILLISECONDS);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("Now data is true!!!!");
//                    ArrayList<ReturnResult> list = resultMap.getOrDefault(uuid, new ArrayList<>());
//                    list.add(new ReturnResult(data, uuid, 0l));
//                    resultMap.put(uuid, list);
//                    try {
//                        Thread.currentThread().sleep(RandomUtils.nextInt(2000));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    pair.fst.countDown();
//                } else {
//                    System.out.println("Now data is false!!!");
//                    ArrayList<ReturnResult> list = resultMap.getOrDefault(uuid, new ArrayList<>());
//                    list.add(new ReturnResult(data, uuid, 1l));
//                    resultMap.put(uuid, list);
//                }
//            } else {
//                System.out.println("Error!!!");
//            }
//
//
//        }
//    }
//
//    public static void main(String[] args) {
//        TestFuture future = new TestFuture();
//
//        future.add(Arrays.asList(1l, 2l, 3l), "1");
//        future.batch("1");
//    }
}
