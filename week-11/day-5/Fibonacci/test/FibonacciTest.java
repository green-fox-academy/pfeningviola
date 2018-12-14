import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
  private static Fibonacci fibonacci;

  @BeforeClass
  public static void init() {
    fibonacci = new Fibonacci();
  }

  @Test
  public void countFibonacciNumberWith0With1WithBiggerNumber() {
    int index1 = 0;
    int index2 = 1;
    int index3 = 20;
    int expectedResult1 = 0;
    int expectedResult2 = 1;
    int expectedResult3 = 6765;

    int result1 = fibonacci.countFibonacciNumber(index1);
    int result2 = fibonacci.countFibonacciNumber(index2);
    int result3 = fibonacci.countFibonacciNumber(index3);

    assertEquals(expectedResult1, result1);
    assertEquals(expectedResult2, result2);
    assertEquals(expectedResult3, result3);
  }

  @Test
  public void countFibonacciNumberWithNegativeNumber() {
    int index = -3;
    int expectedResult = 0;

    int result = fibonacci.countFibonacciNumber(index);

    assertEquals(expectedResult, result);
  }
}
