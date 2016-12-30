package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * void lock(): ожидает, пока не будет получена блокировка
 *
 * boolean tryLock(): пытается получить блокировку,
 * если блокировка получена, то возвращает true.
 * Если блокировка не получена, то возвращает false.
 * В отличие от метода lock() не ожидает
 * получения блокировки, если она недоступна
 *
 * void unlock(): снимает блокировку
 *
 * Condition newCondition(): возвращает объект Condition,
 * который связан с текущей блокировкой
 */
public class Main {
    public static void main(String[] args) {
        CommonResource commonResource= new CommonResource();
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Поток " + i);
            t.start();
        }
    }
}

class CommonResource {
    int x = 0;
}

class CountThread implements Runnable {
    CommonResource res;
    ReentrantLock locker;

    CountThread(CommonResource res, ReentrantLock lock) {
        this.res = res;
        this.locker = lock;
    }

    public void run() {
        try {
            locker.lock(); // устанавливаем блокировку
            res.x = 1;
            for (int i = 1; i < 3; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            locker.unlock(); // снимаем блокировку
        }
    }
}







