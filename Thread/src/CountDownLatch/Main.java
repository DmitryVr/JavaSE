package CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * похож на join
 */
public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        System.out.println("Before await");
        try {
            countDownLatch.await(); // как закончите работу, позвоните
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all job done");
    }
}

class Work extends Thread {
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done work");
        countDownLatch.countDown();
    }
}