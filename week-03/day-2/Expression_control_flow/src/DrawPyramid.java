import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int rows = scannerInt.nextInt();

        for (int i = 0; i < rows; i++) {
            int space = (rows - i - 1);
            for (int j = 0; j < (rows * 2 - 1); j++) {
                if ((j < space) || (j > 2 * i + space)){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}


