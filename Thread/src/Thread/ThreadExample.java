package Thread;

public class ThreadExample {
    public static void main(String[] args) {

        try {
            Thread.sleep(3000); // усыпить поток main на 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new TestThread().start();
        new TestThread().start();

        new TestThread().start();
        new TestThread().start();

        System.out.println(Thread.currentThread().getName()); // получить имя потока

        TestThread testThread = new TestThread();
        testThread.setName("Поток с приоритетом 10"); // установить имя потока
        testThread.setPriority(Thread.MAX_PRIORITY); // установить приоритет 10
        testThread.start();
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        Thread.yield(); // рекомендация планировщику потоков выполнить другой поток
        System.out.println(Thread.currentThread().getName());
    }
}
