package Animals;

import Interfaces.*;

public class Lion extends Carnivore implements Run, Voice {
    public Lion(String name, int weight, Type type) {
        this.setName(name);
        this.setWeight(weight);
        this.setType(type);
    }

    public String voice() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "RRR KING OF HILL!";
        }
    }

    public String run() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Running lion!";
        }
    }
}
