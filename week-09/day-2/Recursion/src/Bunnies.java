public class Bunnies {

  public static void main(String[] args) {
    System.out.println(countBunniesEars(60));
  }

  public static int countBunniesEars (int numberOfBunnies) {
    if(numberOfBunnies == 1) {
      return 2;
    } else {
      return countBunniesEars(numberOfBunnies - 1) + 2;
    }
  }
}
