import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CountLettersTest {
  private static CountLetters letters;

  @BeforeClass
  public static void init() {
    letters = new CountLetters();
  }

  @Test
  public void countLettersInStringWithSingleLetters() {
    String word = "money";
    Map<Character, Integer> expectedResult = new HashMap<>();
    expectedResult.put('m', 1);
    expectedResult.put('o', 1);
    expectedResult.put('n', 1);
    expectedResult.put('e', 1);
    expectedResult.put('y', 1);

    Map<Character, Integer> result = letters.countLettersInString(word);

    assertEquals(expectedResult, result);
  }

  @Test
  public void countLettersInStringWithMultipleLetters() {
    String word = "apple";
    Map<Character, Integer> expectedResult = new HashMap<>();
    expectedResult.put('a', 1);
    expectedResult.put('p', 2);
    expectedResult.put('l', 1);
    expectedResult.put('e', 1);

    Map<Character, Integer> result = letters.countLettersInString(word);

    assertEquals(expectedResult, result);
  }

  @Test
  public void countLettersInStringWithEmptyStringInput() {
    String word = "";
    Map<Character, Integer> expectedResult = new HashMap<>();

    Map<Character, Integer> result = letters.countLettersInString(word);

    assertEquals(expectedResult, result);
  }

  @Test
  public void countLettersInStringWithNullInput() {
    String word = null;
    Map<Character, Integer> expectedResult = new HashMap<>();

    Map<Character, Integer> result = letters.countLettersInString(word);

    assertEquals(expectedResult, result);
  }
}
