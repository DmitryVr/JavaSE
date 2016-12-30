package GenericsApp7;

import java.util.ArrayList;
import java.util.List;

/**
 * <? extends Parent> - возможно передать Parent и любого потомка, в таком методе нельзя добавить новый элемент
 * <? super Child> - возможно передать любого родителя и Child
 */
public class GenericsApp7 {
    public static void main(String[] args) {
        List<Child> list = new ArrayList<>();
        list.add(new Child());

        List<Parent> list2 = new ArrayList<>();
        list2.add(new Parent());

        GenericsApp7 main = new GenericsApp7();
        main.method(list);
        main.methodSuper(list2);
    }

    void method(List<? extends Parent> list) {
        for (Parent parent : list) {
            System.out.println(parent);
        }
    }

    void methodSuper(List<? super Child> list) {
        for (Object o : list) {
            Parent parent = (Parent) o;
            parent.printParent();
        }
    }
}

class Parent {
    public void printParent() {
        System.out.println("Print Parent");
    }
}

class Child extends Parent {}


