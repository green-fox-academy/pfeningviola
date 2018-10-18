import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {

        //OddEven
        int a = 17;

        if (a % 2 == 0){
            System.out.println("The number is even.");
        } else{
            System.out.println("The number is odd.");
        }

        //OneTwoALot
        int b = 5;

        if (b <= 0) {
            System.out.println("Not enough");
        }else if (b == 1) {
            System.out.println("One");
        }else if (b == 2) {
            System.out.println("Two");
        }else{
            System.out.println("A lot");
        }

        //PrintBigger
        Scanner scannerDouble = new Scanner(System.in);

        System.out.println("Enter a number: ");
        double number1 = scannerDouble.nextDouble();

        System.out.println("Enter one more number: ");
        double number2 = scannerDouble.nextDouble();

        if (number1 > number2){
            System.out.println("The first number is bigger: " + number1);
        }else if(number1 == number2){
            System.out.println("The two numbers are equivalent.");
        }else{
            System.out.println("The second number is bigger:" + number2);
        }

        //Party Indicator
        Scanner scannerInt = new Scanner(System.in);

        System.out.println("How many girls come to the party?");
        int girls = scannerInt.nextInt();

        System.out.println("How many boys come to the party?");
        int boys = scannerInt.nextInt();

        if(girls == 0) {
            System.out.println("Sausage party");
        }
        else if((girls == boys) && ((girls+boys) >= 20)){
            System.out.println("The party is excellent!");
        }else if((girls != boys) && ((girls+boys)>=20)){
            System.out.println("Quite cool party!");
        }else if((girls + boys) < 20){
            System.out.println("Average party...");
        }

    }

}
