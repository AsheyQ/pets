package Animals;
import Food.Food;

abstract public class Herbivore extends Animal {
    @Override
    public String eat(Food food) {
        if (!food.isMeat()) {
            int a = this.getHungerLevel();
            a += 5;
            setHungerLevel(a);
            return "Eating...";
        }
        return "Wrong type food";
    }
}
