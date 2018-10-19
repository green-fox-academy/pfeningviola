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

        for(int y = 0; y < 10; y++){
            System.out.println((y + 1) + " * " + x + " = "+ ((y+1)*x));
        }

        //CountFromTo
        System.out.println("Please enter a number: ");
        int g1 = scannerInt.nextInt();
        System.out.println("Please enter one more number: ");
        int g2 = scannerInt.nextInt();

        if (g1 >= g2){
            System.out.println("The second number should be bigger");
        }else{
            for(int h=0; h < (g2-g1); h++){
                System.out.println(h+g1);
            }
        }

        //FizzBuzz
        for(int j=0; j < 100; j++){
            if(((j+1) % 3 == 0) && ((j+1) % 5 == 0)){
                System.out.println("FizzBuzz");
            }else if((j+1) % 3 == 0){
                System.out.println("Fizz");
            }else if((j+1) % 5 == 0) {
                System.out.println("Buzz");
            }else{
                System.out.println(j+1);
            }

        }


    }
}
