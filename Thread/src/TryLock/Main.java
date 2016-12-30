package TryLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * boolean tryLock(): пытается получить блокировку,
 * если блокировка получена, то возвращает true.
 * Если блокировка не получена, то возвращает false.
 * В отличие от метода lock() не ожидает
 * получения блокировки, если она недоступна
 */
public class Main {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку

        Thread thread1 = new Thread(new Thread1(locker));
        Thread thread2 = new Thread(new Thread2(locker));
        thread1.setName("Поток " + 1);
        thread2.setName("Поток " + 2);
        thread1.start();
        thread2.start();
    }
}

class Thread1 implements Runnable {
    ReentrantLock locker;

    Thread1(ReentrantLock lock) {
        this.locker = lock;
    }

    @Override
    public void run() {
        locker.lock();
        System.out.println(Thread.currentThread().getName() + " start");
        try {
            Thread.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " stop");
        locker.unlock();
    }
}

class Thread2 implements Runnable {
    ReentrantLock locker;

    Thread2(ReentrantLock lock) {
        this.locker = lock;
    }

    @Override
    public void run() {
        while (true) {
            if (locker.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " stop");
                locker.unlock();
                break;
            }
            else {
                System.out.println(Thread.currentThread().getName() + " waiting...");
            }
        }
    }
}