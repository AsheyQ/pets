package Food;

public class Grass extends Food {
    @Override
    public Boolean isMeat() {
        return false;
    }
    public String name() {
        return "Овощи";
    }
}
