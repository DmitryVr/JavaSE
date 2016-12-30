package WaitNotify;

/**
 * wait(): освобождает монитор и переводит вызывающий поток
 * в состояние ожидания до тех пор,
 * пока другой поток не вызовет метод notify()
 *
 * notify(): продолжает работу потока,
 * у которого ранее был вызван метод wait()
 *
 * notifyAll(): возобновляет работу всех потоков,
 * у которых ранее был вызван метод wait()
 *
 * эти методы вызываются только из
 * синхронизированного контекста - синхронизированного блока или метода
 */
public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

// класс магазин, хранящий произведенные товары
class Store {
    private int product = 0;

    public synchronized void get() {
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}

// класс производитель
class Producer implements Runnable {
    Store store;

    Producer(Store store) {
        this.store=store;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

// класс потребитель
class Consumer implements Runnable {
    Store store;

    Consumer(Store store) {
        this.store=store;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
