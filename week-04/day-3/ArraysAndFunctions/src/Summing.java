import java.util.Scanner;

public class Summing {

    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please, enter a number: ");
        int countUpTo = scannerInt.nextInt();
        System.out.println("The sum of all numbers until the given number is " + (sum(countUpTo)));
    }

    public static int sum (int number) {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
