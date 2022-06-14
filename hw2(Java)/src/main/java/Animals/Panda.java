package Animals;
import Interfaces.*;

public class Panda extends Herbivore implements Run, Voice {

    public Panda(String name, int weight) {
        this.setName(name);
        this.setWeight(weight);
    }

    public String voice() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Screaming panda!";
        }
    }

    public String run() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Running panda!";
        }
    }
}
