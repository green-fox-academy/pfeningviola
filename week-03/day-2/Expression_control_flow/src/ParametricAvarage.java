import java.util.Scanner;

public class ParametricAvarage {
    public static void main(String[] args) {
        int sum = 0;
        int howManyNumber = 10;
        Scanner scannerInt = new Scanner(System.in);

        for (int i = 0; i < howManyNumber; i++) {
            System.out.println("Enter a number: ");
            int number = scannerInt.nextInt();
            sum = sum + number;
            }
        double avarage = sum / howManyNumber;
        System.out.println("Sum: " + sum + ", Avarage:" + avarage);
    }
}
