
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {

    @DataProvider
    @Description("Positive tests")
    public Object [][] testSumPositive (){
        return new Object[][]{
                {2, 2, 4},
                {1, 1, 2},
                {-10, -25, -35},
                {256, 256, 512},
                {1e9, 1e9, 2e9}
        };
    }
    @DataProvider
    @Description("Negative tests")
    public Object [][] testSumNegative (){
        return new Object[][]{
                {2, 2, 3},
                {1, 1, 1},
                {-5, -2, 7},
                {Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}
        };
    }
    @DataProvider
    @Description("Boundary tests")
    public Object [][] testSumBounds (){
        return new Object[][]{
                {0, 0, 0},
                {-1, 1, 0},
                {-1e9, 1e9, 0},
                {Double.MAX_VALUE, -1, Double.MAX_VALUE - 1},
                {Double.MAX_VALUE, -Double.MAX_VALUE, 0}

        };
    }



    @Test(dataProvider = "testSumPositive")
    public void testSumPositive(double a, double b, double c){
        Assert.assertEquals(c, Calculator.sum(a, b), "bad positive test");
    }

    @Test(dataProvider = "testSumNegative")
    public void testSumNegative(double a, double b, double c){
        Assert.assertFalse(c == Calculator.sum(a, b), "bad negative test");
    }

    @Test(dataProvider = "testSumBounds")
    public void testSumBounds(double a, double b, double c){
        Assert.assertEquals(c, Calculator.sum(a, b), "bad boudary test");
    }

    @Test
    @Description("Random tests")
    public void randomTestSum() {
        for (int i = 0; i < 1000; i++) {
            double a = Math.random() * (1e9 + 1e9) - 1e9;
            double b = Math.random() * (1e9 + 1e9) - 1e9;
            Assert.assertEquals(a + b, Calculator.sum(a, b), "bad RANDOM test");
        }
    }
}