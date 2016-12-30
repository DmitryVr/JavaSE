import java.util.*;

public class Main {
    private static List<Car> cars = new ArrayList<>();
    private static Set<Car> treeCars = new TreeSet<>(new CarNameComparator());

    public static void main(String[] args) {
        Car car1 = new Car("BMW", 1999);
        Car car2 = new Car("Nissan", 2017);
        Car car3 = new Car("Ford", 2001);
        Car car4 = new Car("Opel", 2003);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        Collections.sort(cars); // сортировка по-умолчанию, задана в классе Car

        print(cars);

        Collections.sort(cars, new CarNameComparator()); // сортировка по году

        print(cars);

        // коллекция с автоматической сортировкой
        treeCars.add(car1);
        treeCars.add(car2);
        treeCars.add(car3);
        treeCars.add(car4);

        print(treeCars);
    }

    public static void print(Collection collection) {
        Iterator<Car> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println(car.getName() + " " + car.getYear());
        }

        System.out.println();
    }
}
