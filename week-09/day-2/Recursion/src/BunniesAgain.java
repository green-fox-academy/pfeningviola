public class BunniesAgain {
  public static void main(String[] args) {
    writeOutBunniesEars(10);
    System.out.println();
    System.out.println(countBunnieEars(10));
  }

  public static void writeOutBunniesEars(int numberOfBunnies){
    if (numberOfBunnies > 0) {
      writeOutBunniesEars(numberOfBunnies - 1);
      if(numberOfBunnies % 2 == 0) {
        System.out.print(3 + " ");
      } else {
        System.out.print(2 + " ");
      }
    }
  }

  public static int countBunnieEars(int numberOfBunnies) {
    if (numberOfBunnies == 1) {
      return 2;
    } else {
      if (numberOfBunnies % 2 == 0) {
        return countBunnieEars(numberOfBunnies - 1) + 3;
      } else {
        return countBunnieEars(numberOfBunnies - 1) + 2;
      }
    }
  }
}
