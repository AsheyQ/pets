import Animals.*;
import Food.*;
import Interfaces.Type;

public class Zoo {
    public static void main(String[] args) {

        Duck duck1 = new Duck("Donald", 25, "2 Wings", Type.SMALL);
        Duck duck2 = new Duck("Zag", 25, "2 Wings", Type.SMALL);
        Fish fish1 = new Fish("Flaunder", 5, "2 Fins", Type.SMALL);
        Crocodile crocodile1 = new Crocodile("Crocky", 70, Type.LARGE);
        Fish fish2 = new Fish("Nemo", 5, "2 Fins", Type.MEDIUM);
        Crocodile crocodile2 = new Crocodile("Garry", 70, Type.LARGE);
        Panda panda = new Panda("Po", 100, Type.SUPERLARGE);
        Lion lion = new Lion("Simba", 80, Type.SUPERLARGE);
        Falcon falcon = new Falcon("Heavy", 45, Type.MEDIUM);

        Meat meat = new Meat();
        Grass grass = new Grass();
        Worker worker = new Worker();

        worker.feed(duck1, grass);
        worker.feed(lion, grass);

        Cage<Herbivore> herbCage = new Cage(Type.LARGE);
        Cage<Carnivore> carnCage = new Cage(Type.LARGE);

        herbCage.add(duck1);
        herbCage.add(duck2);
        herbCage.add(panda);

        carnCage.add(falcon);
        carnCage.add(crocodile1);
        carnCage.add(crocodile2);
        carnCage.add(lion);

        herbCage.find("Donald");
        herbCage.find("Simba");
    }
}