package model;

public class Kotik {

    private int hunger = 5;
    private int cute, weight;
    private String name, meow;
    private static int count = 0;

    public Kotik(int cute, int weight, String name, String meow) {
        count++;
        this.cute = cute;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
    }

    public void setKotik(int cute, int weight, String name, String meow) {
        this.cute = cute;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
    }

    public Kotik() {
        count++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCute(int cute) {
        this.cute = cute;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHunger() {
        return hunger;
    }

    public int getCute() {
        return cute;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getMeow() {
        return meow;
    }

    public static int getCount() {
        return count;
    }

    public Boolean eat(int v) {
        hunger += v;
        System.out.print("...Yummy... my hunger level now = " + hunger + "\n");
        return true;
    }

    public Boolean eat(int v, String s) {
        hunger += v;
        System.out.print("...Yummy... my hunger level now = " + hunger + "\n");
        return true;
    }

    public void eat() {
        eat(1, "fish");
    }

    public Boolean play() {
        if (hunger > 0) {
            return true;
        }
        return false;
    }

    public Boolean speak() {
        if (hunger > 0) {
            return true;
        }
        return false;
    }

    public Boolean catchMouse() {
        if (hunger > 0) {
            return true;
        }
        return false;
    }

    public Boolean woolDrop() {
        if (hunger > 0) {
            return true;
        }
        return false;
    }

    public void liveAnotherDay() {
        for (int i = 1; i < 25; i++) {
            System.out.print("-------Hour = " + i + " -------\n");
            double m = 5;
            m = Math.random() * m + 1;
            int n = (int) m;
            switch (n) {
                case (1):
                    if (play()) {
                        hunger--;
                        System.out.print("...WuhUuu... my hunger level now = " + hunger + "\n");
                    } else {
                        System.out.print("I`m hungry! my hunger level now = " + hunger + "\n");
                        eat(1);
                    }
                    break;
                case (2):
                    eat();
                    break;
                case (3):
                    if (speak()) {
                        hunger--;
                        System.out.print(meow + " my hunger level now = " + hunger + "\n");
                    } else {
                        System.out.print("I`m hungry! my hunger level now = " + hunger + "\n");
                        eat(1);
                    }
                    break;
                case (4):
                    if (catchMouse()) {
                        hunger--;
                        System.out.print("...Rrrrr!... my hunger level now = " + hunger + "\n");
                    } else {
                        System.out.print("I`m hungry! my hunger level now = " + hunger + "\n");
                        eat(1);
                    }
                    break;
                case (5):
                    if (woolDrop()) {
                        hunger--;
                        System.out.print("...Whoops... my hunger level now = " + hunger + "\n");
                    } else {
                        System.out.print("I`m hungry! my hunger level now = " + hunger + "\n");
                        eat(1);
                    }
                    break;
            }
            System.out.print("------------------------\n");
        }
    }
}
