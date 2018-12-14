public class Fibonacci {

  public int countFibonacciNumber(int index) {
    if (index < 0) {
      return 0;
    }
    if (index == 0) {
      return 0;
    } else if( index == 1) {
      return 1;
    } else {
      return countFibonacciNumber(index - 1) + countFibonacciNumber(index - 2);
    }
  }
}
