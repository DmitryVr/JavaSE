package Phaser;

import java.util.concurrent.Phaser;

/**
 * разделение выполнения программы на фазы
 * нельзя выполнить следующую фазу, пока все потоки не выполнили предыдущую
 */
public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }
}

class Washer extends Thread {
    Phaser phaser;

    public Washer(Phaser phaser) {
        this.phaser = phaser;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.getName() + " washing the car");
            phaser.arriveAndAwaitAdvance();
        }
    }
}