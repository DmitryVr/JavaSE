package GenericsApp4;

/**
 * Метод дженерик
 */
public class GenericsApp4 {
    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.method("String", 777);
    }
}

class GenericMethod {
    public  <Q, W> void method(Q type1, W type2) {
        System.out.println(type1);
        System.out.println(type2);
    }
}