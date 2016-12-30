package Volatile;

/**
 * volatile - переменная которая может быть использована между несколькими потоками,
 * она не кэшируется, при изменении ее значения, новое значения видят другие потоки
 */
public class Main {
    volatile static int i = 0;

    public static void main(String[] args) {
        new ThreadRead().start();
        new ThreadWrite().start();
    }

    static class ThreadWrite extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadRead extends Thread {
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                if (localVar != i) { // без volatile сюда никогда не настанет, будет висеть на while
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}
