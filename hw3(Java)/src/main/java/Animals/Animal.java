package Animals;

import Food.*;
import Interfaces.*;

import java.util.Objects;

abstract public class Animal {
    private String name;
    private int weight, hungerLevel = 5;
    private Type type;

    abstract public void eat(Food food);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return weight == animal.weight && hungerLevel == animal.hungerLevel && Objects.equals(name, animal.name) && type == animal.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, hungerLevel, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
