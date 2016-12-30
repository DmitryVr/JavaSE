package ForkJoinFramework;

/**
 * Created by root on 29.12.16.
 */
public class Main {
    // сколько ядер
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println(numOfThreads);
    }
}
