package GenericsApp6;

/**
 * Интерфейс дженерик
 */
public class GenericsApp6 {
    public static void main(String[] args) {
        RealItem item = new RealItem();
        System.out.println(item.get().getId());
        System.out.println(item.get().getName());
    }
}

interface Item<T extends Model> {
    T get();
}

class RealItem implements Item<Man> {
    @Override
    public Man get() {
        Man model = new Man();
        model.setId(1);
        model.setName("Batman");
        return model;
    }
}

abstract class Model {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Man extends Model {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}