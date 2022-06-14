package Animals;
import Interfaces.*;

public class Duck extends Herbivore implements Swim, Fly, Voice, Run {

    private String wings;

    public String getWings() {
        return wings;
    }
    public void setWings(String wings) {
        this.wings = wings;
    }
    public Duck(String name, int weight, String wings) {
        this.setName(name);
        this.setWeight(weight);
        this.setWings(wings);
    }

    public String swim() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Swimming duck!";
        }
    }

    public String fly() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Flying duck!";
        }
    }

    public String voice() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Screaming duck!";
        }
    }

    public String run() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Running duck!";
        }
    }
}
