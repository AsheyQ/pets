
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DifTest {

    @DataProvider
    @Description("Positive tests")
    public Object [][] testDifPositive (){
        return new Object[][]{
                {5, 3, 2},
                {1, 1, 0},
                {-10, +25, -35},
                {-256, 256, -512},
                {-1e9, 1e9, -2e9}
        };
    }
    @DataProvider
    @Description("Negative tests")
    public Object [][] testDifNegative (){
        return new Object[][]{
                {1, 1, 1},
                {0, 0, 5},
                {-512, 12, 524},
                {Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE}
        };
    }
    @DataProvider
    @Description("Boundary tests")
    public Object [][] testDifBounds (){
        return new Object[][]{
                {0, 0, 0},
                {-1, -1, 0},
                {-1e9, -1e9, 0},
                {Double.MAX_VALUE, 1, Double.MAX_VALUE - 1},
                {Double.MAX_VALUE, Double.MAX_VALUE, 0}

        };
    }



    @Test(dataProvider = "testDifPositive")
    public void testDifPositive(double a, double b, double c){
        Assert.assertEquals(c, Calculator.dif(a, b), "bad positive test");
    }

    @Test(dataProvider = "testDifNegative")
    public void testDifNegative(double a, double b, double c){
        Assert.assertFalse(c == Calculator.dif(a, b), "bad negative test");
    }

    @Test(dataProvider = "testDifBounds")
    public void testDifBounds(double a, double b, double c){
        Assert.assertEquals(c, Calculator.dif(a, b), "bad boudary test");
    }

    @Test
    @Description("Random tests")
    public void randomTestDif() {
        for (int i = 0; i < 1000; i++) {
            double a = Math.random() * (1e9 + 1e9) - 1e9;
            double b = Math.random() * (1e9 + 1e9) - 1e9;
            Assert.assertEquals(a - b, Calculator.dif(a, b), "bad RANDOM test");
        }
    }
}