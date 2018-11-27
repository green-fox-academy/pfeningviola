public class NumberAdder {

  public static void main(String[] args) {
    System.out.println(addNumber(10));
  }

  public static int addNumber(int limit) {
    if (limit == 1) {
      return 1;
    } else {
      return addNumber(limit - 1) + limit;
    }
  }
}
