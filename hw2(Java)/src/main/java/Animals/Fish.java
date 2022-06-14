package Animals;
import Interfaces.*;

public class Fish extends Herbivore implements Swim {

    private String fins;

    public String getFins() {
        return fins;
    }
    public void setFins(String fins) {
        this.fins = fins;
    }
    public Fish(String name, int weight, String fins) {
        this.setName(name);
        this.setWeight(weight);
        this.setFins(fins);
    }

    public String swim() {
        if (this.getHungerLevel() == 0) {
            return ("I`m hungry! my hunger level now = " + this.getHungerLevel() + "\n");
        } else {
            int a = this.getHungerLevel();
            a--;
            setHungerLevel(a);
            return "Swimming fish!";
        }
    }
}