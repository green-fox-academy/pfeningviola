import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
    Scanner scannerInt = new Scanner(System.in);
    System.out.println("Give me a whole number!");
    int divisor = scannerInt.nextInt();
    divide(divisor);
  }

  public static void divide(int number) {
    double result;
    try {
      result = 10 / number;
      System.out.println("The result is: " + result);

    } catch (ArithmeticException arEx) {
      System.out.println("fail");
    }
  }
}
