import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (!s.equals("exit")) {
            s = scanner.nextLine();
            System.out.println("Вы ввели: " + s);
        }
    }
}
