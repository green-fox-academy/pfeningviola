import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int rows = scannerInt.nextInt();
        int space = (rows - 1);

        for (int i = 0; i < (rows / 2); i++) {

            for (int j = 0; j <= rows; j++) {
                if ((j <= (space / 2)) || (j > (rows - (space / 2)))){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
             }
             space -= 2;
            System.out.println();
        }
        space = 0;
        for (int i =(rows / 2); i < rows; i++){
            for (int j = 0; j <= rows; j++) {
                if ((j <= space / 2) || (j > (rows - (space / 2)))){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            space += 2;
            System.out.println();
        }
    }
}
