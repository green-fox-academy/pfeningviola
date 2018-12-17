public class CowsAndBulls {
  private String numberToGuess;
  private int guessCounter;
  private boolean finished;

  public CowsAndBulls() {
    this.numberToGuess = createTheNumber();
    this.guessCounter = 0;
    this.finished = false;
  }

  public String createTheNumber() {
    String number = "";
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (int i = 0; i < 4; i++) {
      int index = (int)(Math.random() * 10);
      number += String.valueOf(numbers[index]);
    }
    return number;
  }

  public String guess(int guessedNumber) {
    guessCounter++;
    int numberOfCows = 0;
    int numberOfBulls = 0;
    String guess = String.valueOf(guessedNumber);

    if (numberToGuess.equals(guess)) {
      finished = true;
      return "Congratulations! You have guessed the number!";
    } else {
      for (int i = 0; i < 4; i++) {
        String digit = String.valueOf(guess.charAt(i));
        if (numberToGuess.contains(digit)) {
          if (guess.charAt(i) == numberToGuess.charAt(i)) {
            numberOfBulls++;
          } else {
            numberOfCows++;
          }
        }
      }
      return String.format("Result of your %d guess: %d bulls and %d cows",
          guessCounter,
          numberOfBulls,
          numberOfCows);
    }
  }
}
