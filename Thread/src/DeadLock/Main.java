package DeadLock;

/**
 * DeadLock
 *
 * минимум 2 потока и 2 ресурса, которые лочат друг друга
 */
public class Main {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.resourceA = resourceA;
        thread2.resourceB = resourceB;

        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread {
    ResourceA resourceA;

    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}


class Thread2 extends Thread {
    ResourceB resourceB;

    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA {
    ResourceB resourceB;

    public synchronized int getI() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resourceB.returnI();
    }

    public synchronized int returnI() {
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;

    public synchronized int getI() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resourceA.returnI();
    }

    public synchronized int returnI() {
        return 2;
    }
}