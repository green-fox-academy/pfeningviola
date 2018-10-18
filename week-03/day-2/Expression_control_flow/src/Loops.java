import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        //IWontCheatOnTheExams
        for(int i=0; i < 100; i++){
            System.out.println("I won't cheat on the exam!");
        }

        //PrintEven
        for(int f=0; f <= 500; f += 2){
            System.out.println(f);
        }

        //MultiplicationTable
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int x = scannerInt.nextInt();

        for(int y = 1; y <= 10; y++){
            System.out.println(y + " * " + x + " = "+ (y*x));
        }


    }
}
