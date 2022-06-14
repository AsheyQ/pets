
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {

    @DataProvider
    @Description("Positive tests")
    public Object [][] testMultPositive (){
        return new Object[][]{
                {5, 7, 35},
                {1, 1, 1},
                {1, 541, 541},
                {512, 512, 262144},
                {12, 12.5, 150}
        };
    }
    @DataProvider
    @Description("Negative tests")
    public Object [][] testMultNegative (){
        return new Object[][]{
                {1, 1, 0},
                {6, 6, 35},
                {1024, 12, 12289},
                {Double.MAX_VALUE, 0.5, Double.MAX_VALUE}
        };
    }
    @DataProvider
    @Description("Boundary tests")
    public Object [][] testMultBounds (){
        return new Object[][]{
                {0, 0, 0},
                {-1, -1, 1},
                {-1e9, -1e9, 1e18},
                {Double.MAX_VALUE, 1, Double.MAX_VALUE},
                {Double.MAX_VALUE, 0, 0}

        };
    }



    @Test(dataProvider = "testMultPositive")
    public void testMultPositive(double a, double b, double c){
        Assert.assertEquals(c, Calculator.mult(a, b), "bad positive test");
    }

    @Test(dataProvider = "testMultNegative")
    public void testMultNegative(double a, double b, double c){
        Assert.assertFalse(c == Calculator.mult(a, b), "bad negative test");
    }

    @Test(dataProvider = "testMultBounds")
    public void testMultBounds(double a, double b, double c){
        Assert.assertEquals(c, Calculator.mult(a, b), "bad boudary test");
    }

    @Test
    @Description("Random tests")
    public void randomTestMult() {
        for (int i = 0; i < 1000; i++) {
            double a = Math.random() * (1e9 + 1e9) - 1e9;
            double b = Math.random() * (1e9 + 1e9) - 1e9;
            Assert.assertEquals(a * b, Calculator.mult(a, b), "bad RANDOM test");
        }
    }
}