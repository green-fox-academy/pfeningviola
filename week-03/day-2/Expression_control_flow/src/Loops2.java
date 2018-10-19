import java.util.Scanner;
public class Loops2 {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);

        //DrawTriangle
        System.out.println("Please enter a number: ");
        int a = scannerInt.nextInt();
        String stars = "*";
        for(int i = 0; i < a; i++){
            System.out.println(stars);
            stars = stars + "*";
        }

        //DrawDiagonal
        System.out.println("Please enter a number: ");
        int b =scannerInt.nextInt();
        String square = "%";
        for(int j = 0; j < b; j++) {
            for (int k = 0; k < b; k++) {
                if((k == 0) || (k == b-1) || (k == j) || (j == 0) || (j == b-1)) {
                    System.out.print(square);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }







    }
}
