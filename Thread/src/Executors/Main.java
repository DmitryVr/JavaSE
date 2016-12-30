package Executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * контролирует количество создаваемых потоков (пул потоков)
 * потоки переиспользуются по несколько раз
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newCachedThreadPool(); // 60сек. если за это время новый поток не использует, то поток умирает

        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyRunnable());
//            System.out.println(executorService.submit(new MyCallable()).get());
        }
        executorService.shutdown();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(1);
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "2";
    }
}