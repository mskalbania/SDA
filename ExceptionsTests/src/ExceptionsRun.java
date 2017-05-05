import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsRun {

    public static void main(String[] args) {

//        System.out.println(divideBYL(1,0));
//        System.out.println(divideEAFP(1,0));
        System.out.println(getIntEAFP());

    }

    private static int getIntEAFP() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integer: ");
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, again!");
                sc.next();
            }
        }
    }

    private static int divideBYL(int x, int y) {

        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
