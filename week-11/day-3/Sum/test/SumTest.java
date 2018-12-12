import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SumTest {
  private static Sum summery;

  @BeforeClass
  public static void init() {
    summery = new Sum();
  }

  @Test
  public void testSumTheNumbersWithMultipleElements() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(3, 7, 9, 2, 21));
    int expectedResult = 42;

    int result = summery.sumTheNumbers(numbers);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testSumTheNumbersWithOneElement() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2));
    int expectedResult = 2;

    int result = summery.sumTheNumbers(numbers);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testSumTheNumbersWithEmpty() {
    ArrayList<Integer> numbers = new ArrayList<>();
    int expectedResult = 0;

    int result = summery.sumTheNumbers(numbers);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testSumTheNumbersWithNull() {
    ArrayList<Integer> numbers = null;
    int expectedResult = 0;

    int result = summery.sumTheNumbers(numbers);

    assertEquals(expectedResult, result);
  }
}
