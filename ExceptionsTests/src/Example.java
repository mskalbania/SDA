import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            System.out.println((double) Math.round(divide() * 100) / 100);
        } catch (ArithmeticException e) {
            String Message = e.toString().replace("java.lang.ArithmeticException","Error");
            System.out.println(Message);
        }
    }

    private static double divide() {
        double x;
        double y;
        try {
            x = getDouble();
            y = getDouble();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new ArithmeticException("Not suitable input!");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempting to divide by 0!");
        }
    }

    private static double getDouble() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Again.");
            }
        }
    }
}
