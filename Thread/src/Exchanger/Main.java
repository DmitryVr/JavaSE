package Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Класс Exchanger предназначен для обмена
 * данными между потоками
 */
public class Main {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger();
        new Thread(new PutThread(ex)).start();
        new Thread(new GetThread(ex)).start();
    }
}

class PutThread implements Runnable{

    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger ex){

        this.exchanger=ex;
        message = "Hello Java!";
    }
    public void run(){

        try{
            message=exchanger.exchange(message);
            System.out.println("PutThread получил: " + message);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
class GetThread implements Runnable{

    Exchanger<String> exchanger;
    String message;

    GetThread(Exchanger ex){

        this.exchanger=ex;
        message = "Hell to world!";
    }
    public void run(){

        try{
            System.out.println("GetThread sleep 4000");
            Thread.sleep(4000);
            message=exchanger.exchange(message);
            System.out.println("GetThread получил: " + message);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}