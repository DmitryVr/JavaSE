package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * получает результат из потока
 */
public class Main {
    public static void main(String[] args) {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        System.out.println("tadaaaaam");
        try {
            System.out.println(futureTask.get()); // ждет, типа join
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int j = 0;
        for (int i = 0; i < 10; i++, j++) {
            Thread.sleep(300);
        }
        return j;
    }
}
