/**
 * автомобиль
 */
public class Car implements Comparable<Car> {
    private String name;
    private int year;

    public Car(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // сортировка по имени
    @Override
    public int compareTo(Car car) {
        Integer year1 = new Integer(this.getYear());
        Integer year2 = new Integer(car.getYear());
        return year1.compareTo(year2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        return name != null ? name.equals(car.name) : car.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + year;
        return result;
    }
}