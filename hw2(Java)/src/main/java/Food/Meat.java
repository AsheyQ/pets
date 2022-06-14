package Food;

public class Meat extends Food {
    @Override
    public Boolean isMeat() {
        return true;
    }
    public String name() {
        return "Мясо";
    }
}
