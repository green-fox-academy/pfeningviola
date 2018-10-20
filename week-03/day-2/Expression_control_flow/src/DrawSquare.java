import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int rows = scannerInt.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if ((j == 0) || (j == rows - 1) || (i == 0) || (i == rows - 1)) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
