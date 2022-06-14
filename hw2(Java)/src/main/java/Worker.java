import Animals.*;
import Food.*;

public class Worker {
    public void feed(Animal animal, Food food) {
        System.out.println(animal.eat(food));
    }

    public <T extends Animal> void getVoice(T item) {

        if (item.getClass() == Duck.class) {
            System.out.println(((Duck) item).voice());
        }
        if (item.getClass() == Falcon.class) {
            System.out.println(((Falcon) item).voice());
        }
        if (item.getClass() == Lion.class) {
            System.out.println(((Lion) item).voice());
        }
        if (item.getClass() == Panda.class) {
            System.out.println(((Panda) item).voice());
        }
        if (item.getClass() == Crocodile.class) {
            System.out.println(((Crocodile) item).voice());
        }
    }
}
