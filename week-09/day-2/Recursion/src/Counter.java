public class Counter {

  public static void main(String[] args) {
    counterDown(10);
    System.out.println("-----------");
    counterUp(10);
  }

  public static void counterDown(int limit) {
    System.out.println(limit);
    if (limit > 0) {
      counterDown(limit - 1);
    }
  }

  public static void counterUp(int limit) {
    if (limit > 0) {
      counterUp(limit - 1);
    }
    System.out.println(limit);
  }
}
