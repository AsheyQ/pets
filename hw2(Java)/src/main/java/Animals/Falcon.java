package Animals;
import Interfaces.*;

public class Falcon extends Carnivore implements Fly, Voice {

    public Falcon(String name, int weight) {
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
            return "CRRR Watch your head!";
        }
    }

    public String fly() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Flying falcon!";
        }
    }
}

