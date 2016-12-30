package Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await: поток ожидает, пока не будет выполнено некоторое условие
 * и пока другой поток не вызовет методы signal/signalAll.
 * Во многом аналогичен методу wait класса Object
 *
 * signal: продолжает работу потока, у которого ранее был вызван метод await().
 * Применение аналогично использованию методу notify класса Object
 *
 * signalAll: возобновляет работу всех потоков, у которых ранее был
 * вызван метод await(), аналогичен методу notifyAll() класса Object
 */
public class Main {
    public static void main(String[] args) {
        Money money = new Money();
        MoneyMinus moneyMinus = new MoneyMinus(money);
        MoneyPlus moneyPlus = new MoneyPlus(money);

        moneyMinus.start();
        moneyPlus.start();
    }
}

class Money {
    private int money;
    private Lock lock;
    private Condition condition;

    public Money() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void put() {
        lock.lock();
        System.out.println("Положить деньги. Начало операции. Денег: " + money);
        money += 10;
        condition.signal();
        System.out.println("Положить деньги. Конец операции. Денег: " + money);
        lock.unlock();
    }

    public void get() {
        try {
            lock.lock();
            System.out.println("Снять деньги. Начало операции. Денег: " + money);
            if (money < 10) {
                condition.await();
            }
            money -= 10;
            System.out.println("Снять деньги. Конец операции. Денег: " + money);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class MoneyPlus extends Thread {
    Money money;

    public MoneyPlus(Money money) {
        this.money = money;
    }

    @Override
    public void run() {
        money.put();
    }
}

class MoneyMinus extends Thread {
    Money money;

    public MoneyMinus(Money money) {
        this.money = money;
    }

    @Override
    public void run() {
        money.get();
    }
}



