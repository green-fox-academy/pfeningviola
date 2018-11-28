public class Refactorio {
  public static void main(String[] args) {
    int number = 5;
    System.out.println(refactorio(number));
  }

  public static int refactorio (int number) {
    if (number == 0) {
      return 1;
    } else {
      return refactorio(number - 1) * number;
    }
  }
}
