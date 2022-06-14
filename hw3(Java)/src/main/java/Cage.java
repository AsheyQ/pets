import Animals.Animal;
import Interfaces.Type;

import java.util.HashSet;
import java.util.Objects;

public class Cage<T extends Animal> {

    private Type type;
    private HashSet<T> cell = new HashSet<T>();

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Cage(Type type) {
        this.setType(type);
    }

    public void add(T item) {
        if (type.check(type, item.getType())) {
            cell.add(item);
            System.out.println("Added : " + item.getClass());
        } else {
            System.out.println("Wrong animal size!");
        }
    }

    public void remove(T item) {
        cell.remove(item);
    }

    public Boolean contains(String name) {
        for (T obj : cell) {
            if (Objects.equals(obj.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public void throwError() {
        System.out.println("Not found");
    }

    public void find(String name) {
        if (!contains(name)) {
            throwError();
        }
        getObj(name);
    }

    public T getObj(String name) {
        for (T obj : cell) {
            if (Objects.equals(obj.getName(), name)) {
                System.out.println("Result = " + obj);
                return obj;
            }
        }
        return null; //этот null никогда не вернется, проверка в методе find(сдейлайте вид что этого нет, пожалуйста)
    }
}
