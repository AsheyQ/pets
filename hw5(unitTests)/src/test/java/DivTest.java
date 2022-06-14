
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {

    @DataProvider
    @Description("Positive tests")
    public Object [][] testDivPositive (){
        return new Object[][]{
                {4, 2, 2},
                {1, 1, 1},
                {10, 4, 2.5},
                {120.8, 4, 30.2},
                {1e9, 3, 1e9 / 3}
        };
    }
    @DataProvider
    @Description("Negative tests")
    public Object [][] testDivNegative (){
        return new Object[][]{
                {1, 1, 0},
                {1024, 128, 7},
                {Double.MAX_VALUE, 2, Double.MAX_VALUE}
        };
    }
    @DataProvider
    @Description("Boundary tests")
    public Object [][] testDivBounds (){
        return new Object[][]{
                {1, -1, -1},
                {0, Double.MAX_VALUE, 0},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1},
                {1e9, 2e9, 0.5},
        };
    }



    @Test(dataProvider = "testDivPositive")
    public void testDivPositive(double a, double b, double c){
        Assert.assertEquals(c, Calculator.div(a, b), "bad positive test");
    }

    @Test(dataProvider = "testDivNegative")
    public void testDivNegative(double a, double b, double c){
        Assert.assertFalse(c == Calculator.div(a, b), "bad negative test");
    }

    @Test(dataProvider = "testDivBounds")
    public void testDivBounds(double a, double b, double c){
        Assert.assertEquals(c, Calculator.div(a, b), "bad boudary test");
    }

    @Test
    @Description("Random tests")
    public void randomTestDiv() {
        for (int i = 0; i < 1000; i++) {
            double a = Math.random() * (1e9 + 1e9) - 1e9;
            double b = Math.random() * (1e9 + 1e9) - 1e9;
            Assert.assertEquals(a / b, Calculator.div(a, b), "bad RANDOM test");
        }
    }
}