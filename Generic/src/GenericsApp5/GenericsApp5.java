package GenericsApp5;

/**
 * Конструктор дженерик
 */
public class GenericsApp5 {
    public static void main(String[] args) {
        Operation operation1 = new Operation(new GetValue(12));
        System.out.println(operation1.getX());
    }
}

class Operation {
    private double x;

    <T extends GetValue> Operation(T x) {
        this.x = x.getX();
    }

    public double getX() {
        return x;
    }
}

class GetValue {
    private double x;

    public GetValue(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }
}