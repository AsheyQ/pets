import Animals.*;
import Food.*;

public class Zoo {
    public static void main(String[] args) {

        Duck duck = new Duck("Donald", 25, "2 Wings");
        Fish fish1 = new Fish("Flaunder", 5, "2 Fins");
        Crocodile crocodile1 = new Crocodile("Crocky", 70);
        Fish fish2 = new Fish("Nemo", 5, "2 Fins");
        Crocodile crocodile2 = new Crocodile("Garry", 70);
        Panda panda = new Panda("Po", 100);
        Lion lion = new Lion("Simba", 80);
        Falcon falcon = new Falcon("Heavy", 45);

        Meat meat = new Meat();
        Grass grass = new Grass();
        Worker worker = new Worker();

        worker.getVoice(duck);
        worker.getVoice(crocodile1);
        worker.getVoice(fish1);
        worker.feed(crocodile1, meat);
        worker.feed(panda, grass);
        worker.feed(lion, grass);
        worker.feed(duck, meat);

        Pond pond = new Pond();
        pond.putVal(fish1);
        pond.putVal(fish2);
        pond.putVal(crocodile1);
        pond.putVal(crocodile2);

        pond.swim();

    }
}