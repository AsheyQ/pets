package Animals;
import Interfaces.*;

public class Crocodile extends Carnivore implements Run, Swim, Voice {

    public Crocodile(String name, int weight) {
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
            return "EAT AND DESTROY RRRR!";
        }
    }

    public String run() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Running crocodile!";
        }
    }

    public String swim() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Swimming crocodile!";
        }
    }
}
