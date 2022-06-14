
import java.util.Scanner;

public class Calculator {

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double dif(double a, double b) {
        return a - b;
    }

    public static double mult(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("divided by 0!");
        }
        return a / b;
    }

    public static double calculate(double firstNum, double secondNum, String operator) {

        switch (operator) {
            case "+":
                return sum(firstNum, secondNum);
            case "-":
                return dif(firstNum, secondNum);
            case "*":
                return mult(firstNum, secondNum);
            case "/":
                return div(firstNum, secondNum);
        }
        return 0;
    }

    public static void main(String[] args){

        double a, b;
        String operator;
        Scanner in = new Scanner(System.in);
        System.out.print("First number : ");
        a = in.nextDouble();
        System.out.print("Operator [+ - * /] : ");
        operator = in.next();
        System.out.print("Second number : ");
        b = in.nextDouble();

        System.out.println("Result = " + calculate(a, b, operator));

    }
}
