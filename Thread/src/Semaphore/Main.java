package Semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Person person1 = new Person(semaphore);
        Person person2 = new Person(semaphore);
        Person person3 = new Person(semaphore);
        Person person4 = new Person(semaphore);
        Person person5 = new Person(semaphore);
        Person person6 = new Person(semaphore);
        Person person7 = new Person(semaphore);

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();
    }
}

class Person extends Thread {
    private Semaphore table;

    public Person(Semaphore table) {
        this.table = table;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " ожидает столик");
        try {
            table.acquire(); // получить 1 разрешение
            System.out.println(this.getName() + " ест за столиком");
            this.sleep(2000);
            System.out.println(this.getName() + " освободил столик");
            table.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}