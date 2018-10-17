import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);

        //HelloUser
        System.out.println("Please enter your name: ");
        String userName = scannerString.nextLine();
        System.out.println("Hello, " + userName + "!");

        //MileToKmConverter
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please enter how far do you live (in km): ");
        int distanceKm = scannerInt.nextInt();
        double distanceMiles = distanceKm * 0.62;
        System.out.println(distanceMiles + " miles");

        //AnimalsAndLegs
        System.out.println("How many chickens do you have?");
        int chicken = scannerInt.nextInt();
        System.out.println("How many pigs do you have?");
        int pig = scannerInt.nextInt();
        int leg = (chicken * 2) + (pig * 4);
        System.out.println("Your animals have " + leg + " legs.");

        //AvarageOfInput
        System.out.println("Please enter your first number: ");
        int number1 = scannerInt.nextInt();
        System.out.println("Please enter your second number: ");
        int number2 = scannerInt.nextInt();
        System.out.println("Please enter your third number: ");
        int number3 = scannerInt.nextInt();
        System.out.println("Please enter your fourth number: ");
        int number4 = scannerInt.nextInt();
        System.out.println("Please enter your fifth number: ");
        int number5 = scannerInt.nextInt();
        int sum = number1 + number2 + number3 + number4 + number5;
        double avarage = sum / 5.;
        System.out.println("Sum: " + sum + ", Avarage: " + avarage);



    }
    }
