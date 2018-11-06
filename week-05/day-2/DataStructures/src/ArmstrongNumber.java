import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Please, enter your number: ");
        int number = scannerInt.nextInt();
        checkingArmstrongNumber(number);
    }

    public static void checkingArmstrongNumber (int num) {
        int checkArmstrong = 0;
        int powerRaising = 1;

        String numberString = String.valueOf(num);
        char[] digitArray = numberString.toCharArray();
        int numberLength = digitArray.length;

        for (int i = 0; i < numberLength; i++) {

            for (int j = 0; j < numberLength; j++) {
                powerRaising = powerRaising * Character.getNumericValue(digitArray[i]);
            }
            checkArmstrong = checkArmstrong + powerRaising;
            powerRaising = 1;
        }

        if (checkArmstrong == num) {
            System.out.println("The number " + num + " is an Armstrong Number.");;
        } else {
            System.out.println("The number " + num + " is NOT an Armstrong Number.");
        }
    }
}
