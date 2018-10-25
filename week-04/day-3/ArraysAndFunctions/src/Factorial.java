import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please, enter a number: ");
        int number = scannerInt.nextInt();

        System.out.println("The factorial of this number is " + factorio(number));
    }

    public static int factorio (int input) {
        int factor = 1;
        for (int i = 0; i < input; i++) {
            factor = factor * (i + 1);
        }
        return factor;
    }
}
