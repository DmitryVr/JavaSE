package myException;

/**
 * класс где возможно исключение
 */
public class TestException {
    public void getException(int number) throws MyException {
        if(number < 1)
            throw new MyException("Число не может быть меньше 1", number);
        else
            System.out.println("Число равно: " + number);
    }
}
