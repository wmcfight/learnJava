package callback;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by mwei on 15-8-21.
 */
public class CallbackSample {

    public static void main(String[] args) {

        guavaListenFuture();
        springListenFuture();

    }

    private static void springListenFuture() {
        ConcurrentTaskExecutor executorService = new ConcurrentTaskExecutor();

        org.springframework.util.concurrent.ListenableFuture<String> future = executorService.submitListenable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Spring test";
            }
        });


        future.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onSuccess(String o) {
                System.out.println("Test1 " + o + " " + System.currentTimeMillis());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        future.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onSuccess(String o) {
                System.out.println("Test2 " + o + " " + System.currentTimeMillis());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
    private static void guavaListenFuture() {
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());


        final ListenableFuture<String> future = listeningExecutorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Guava Test";
            }
        });


        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String o) {
                System.out.println("Test1 " + o + System.currentTimeMillis());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String o) {
                System.out.println("Test2 " + o + System.currentTimeMillis());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
