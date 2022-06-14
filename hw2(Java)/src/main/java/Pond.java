import Animals.*;
import java.util.ArrayList;
import java.util.List;

public class Pond<T> {
    private final List<T> list = new ArrayList<>();

    public void putVal(T item) {
        list.add(item);
    }

    public void swim() {
        for (T item : list) {

            if (item.getClass() == Duck.class) {
                System.out.println(((Duck) item).swim());
            }
            if (item.getClass() == Crocodile.class) {
                System.out.println(((Crocodile) item).swim());
            }
            if (item.getClass() == Fish.class) {
                System.out.println(((Fish) item).swim());
            }
        }
    }
}
