public class SumDigit {

  public static void main(String[] args) {
    System.out.println(sumOfDigits(1367));
  }

  public static int sumOfDigits(int number) {
    if (number / 10 == 0) {
      return (number % 10);
    } else {
      return sumOfDigits(number / 10) + (number % 10);
    }
  }
}
