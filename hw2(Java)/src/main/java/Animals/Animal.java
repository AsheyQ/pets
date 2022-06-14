package Animals;
import Food.*;

abstract public class Animal {

    private String name;
    private int weight, hungerLevel = 5;

    abstract public String eat(Food food);
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHungerLevel() {
        return hungerLevel;
    }
    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

}
