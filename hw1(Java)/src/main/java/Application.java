import model.Kotik;

public class Application {
    public static void main(String[] args) {

        Kotik cat1 = new Kotik(20, 45, "Leo", "MEW");
        Kotik cat2 = new Kotik();
        cat2.setKotik(40, 21, "Masha", "MeeewMew");
        cat1.liveAnotherDay();
        System.out.println(cat1.getMeow().equals(cat2.getMeow()));
        System.out.println("Count of cats here = " + Kotik.getCount());
    }

}
