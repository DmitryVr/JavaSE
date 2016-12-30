/**
 * поверхностное клонирование - клонирует только примитивные типы
 * глубокое клонирование - клонирует объекты
 */
public class Main {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        myObject.i = 10;
        NewObject newObject = new NewObject();
        newObject.j = 20;
        myObject.newObject = newObject;

        // клонировать
        MyObject myObject1 = null;
        try {
            myObject1 = myObject.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(myObject.i);
        System.out.println(myObject.newObject.j);
        System.out.println(myObject1.i);
        System.out.println(myObject1.newObject.j);

        myObject.i = 100;
        myObject.newObject.j = 200;
        myObject1.i = 300;
        myObject1.newObject.j = 400;

        System.out.println("далее видно что это 2 объекта");
        System.out.println(myObject.i);
        System.out.println(myObject.newObject.j);
        System.out.println(myObject1.i);
        System.out.println(myObject1.newObject.j);
    }
}

class MyObject implements Cloneable {
    int i;
    NewObject newObject;

    @Override
    protected MyObject clone() throws CloneNotSupportedException {
        MyObject myObject = (MyObject) super.clone(); // примитивные типы
        myObject.newObject = newObject.clone(); // объект
        return myObject;
    }
}

class NewObject implements Cloneable {
    int j;

    @Override
    protected NewObject clone() throws CloneNotSupportedException {
        return (NewObject) super.clone(); // примитивные типы
    }
}