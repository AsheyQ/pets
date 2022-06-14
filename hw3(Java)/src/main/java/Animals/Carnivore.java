package Animals;

import Food.Food;
import Interfaces.*;

abstract public class Carnivore extends Animal {
    @Override
    public void eat(Food food) {
        if (!food.isMeat()) {
            try {
                throw new WrongFoodException("Wrong type food");
            } catch (WrongFoodException e) {
                e.printStackTrace();
            }
        }
        int a = this.getHungerLevel();
        a += 5;
        setHungerLevel(a);
    }
}
