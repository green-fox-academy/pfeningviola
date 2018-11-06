import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Would you like to play? Give me the minimum number, that I can think of (it should be a positive whole number): ");
        int minRange = scannerInt.nextInt();
        System.out.println("Give me the maximum number, that I can think of: ");
        int maxRange = scannerInt.nextInt();
        System.out.println("How many lives would you like to have?");
        int livesNumber = scannerInt.nextInt();

        int numberToGuess = (int)(minRange + (Math.random() * (maxRange + 1)));
        System.out.println(numberToGuess);
        System.out.println("I have the number between " + minRange + " and " + maxRange + ". You have " + livesNumber + " lives.");
        for (int i = 0; i < livesNumber; i++) {
            int guess = scannerInt.nextInt();
            if (guess == numberToGuess) {
                System.out.println("Congratulations. You won!");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! You have " + (livesNumber - 1 - i) + " lives left.");
            } else {
                System.out.println("Too high! You have " + (livesNumber - 1 - i) + " lives left.");
            }
        }
        System.out.println("GAME OVER");
    }
}
