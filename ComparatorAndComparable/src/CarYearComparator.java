import java.util.Comparator;

/**
 * сортировка по году выпуска
 */
public class CarYearComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        Integer year1 = new Integer(car1.getYear());
        Integer year2 = new Integer(car2.getYear());
        return year1.compareTo(year2);
    }
}