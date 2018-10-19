import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);

        int number = 10;
        for (int i = 0; i < 100; i++) {
            System.out.println("Try to guess my number! Enter a number: ");
            int guess = scannerInt.nextInt();
            if (guess < number) {
                System.out.println("The stored number is higher");
            } else if (guess > number) {
                System.out.println("The stored number is lower");
            } else {
                System.out.println("You found the number: " + number);
                i = 99;
            }

        }
    }
}
