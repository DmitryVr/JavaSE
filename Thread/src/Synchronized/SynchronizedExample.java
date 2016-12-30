package Synchronized;

public class SynchronizedExample {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.setX(10);

        Thread thread1 = new Thread(new TestThreadSunchronized(resource));
        Thread thread2 = new Thread(new TestThreadSunchronized(resource));
        thread1.setName("Поток " + 1);
        thread2.setName("Поток " + 2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Результат: " + resource.getX());
    }
}

class Resource {
    private int x;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    // синхронизированный метод, один поток выполняет, остальные ждут
    public synchronized void increment() {
        //synchronized (this) { // можно синхронизировать блок, this - т.к. синхронизация происходит на объекте, то указывается этот объект
            System.out.println(Thread.currentThread().getName() + " начал инкрементировать x");
            int x = this.x;
            Thread.yield(); // это для демонстрации без синхронизации, для увеличения шанса изменения двумя потоками
            x += 10;
            this.x = x;
            System.out.println(Thread.currentThread().getName() + " закончил инкрементировать x");
        //}

    }
}

class TestThreadSunchronized implements Runnable {
    private Resource resource;

    TestThreadSunchronized(Resource resource){
        this.resource = resource;
    }

    public void run(){
//        synchronized (resource) { // можно синхронизировать так
            resource.increment();
//        }
    }
}