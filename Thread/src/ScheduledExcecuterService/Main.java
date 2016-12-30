package ScheduledExcecuterService;

import java.util.concurrent.*;

/**
 * типо таймера
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.schedule(new MyThread(), 3, TimeUnit.SECONDS); // вызвать через 3 секунды
        ses.shutdown();
        System.out.println("oooppppppp");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("time!");
    }
}