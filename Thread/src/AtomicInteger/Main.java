package AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by root on 28.12.16.
 */
public class Main {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int notAtomic;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            new MyThread().start();
        }

        Thread.sleep(4_000);

        System.out.println("AtomicInteger: " + atomicInteger.get());
        System.out.println("int: " + notAtomic);
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
            ++notAtomic;
        }
    }
}

