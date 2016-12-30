package GenericsApp1;

/**
 * Класс дженерик
 */
public class GenericsApp1 {
    public static void main(String[] args) {
        Bank<Integer> bank1 = new Bank(new Integer[] { 1, 2, 4, 5, 6 });
        Bank<String> bank2 = new Bank(new String[] {"13433", "342454", "21432"});

        bank1.forAll();
        bank2.forAll();
    }
}

class Bank<T> {
    private T[] clients;
//    static T staticT; // нельзя использовать статические переменные универсальных параметров
//    private T typeT = new T(); // нельзя создавать экземпляры универсальных классов таким образом

    public Bank(T[] clients) {
        this.clients = clients;
    }

    public void forAll() {
        for (T client : clients) {
            System.out.println(client);
        }
    }
}