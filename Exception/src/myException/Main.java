package myException;

/**
 * обработка исключения
 */
public class Main {
    public static void main(String[] args) {
        TestException testException = new TestException();
        try {
            testException.getException(-3);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getNumber());
        } finally {
            System.out.println("закрытие ресурса");
        }
    }
}
