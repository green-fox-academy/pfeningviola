import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
  private static Anagram myAnagram;

  @BeforeClass
  public static void initAnagram() {
    myAnagram = new Anagram();
  }

  @Test
  public void testIsAnagramWithCaseInsensivitate() {
    String text1 = "GREEnfox";
    String text2 = "xOnFErEg";

    boolean result = myAnagram.isAnagram(text1, text2);

    assertTrue(result);
  }

  @Test
  public void testIsAnagramWithLowerCaseLettersWithTrue() {
    String text1 = "greenfox";
    String text2 = "xonfereg";

    boolean result = myAnagram.isAnagram(text1, text2);

    assertTrue(result);
  }

  @Test
  public void testIsAnagramWithDifferentStringInput() {
    String text1 = "greenfox";
    String text2 = "xonf";

    boolean result = myAnagram.isAnagram(text1, text2);

    assertFalse(result);
  }

  @Test
  public void testIsAnagramWithEmpty() {
    String text1 = "";
    String text2 = "";

    boolean result = myAnagram.isAnagram(text1, text2);

    assertTrue(result);
  }

  @Test
  public void testIsAnagramWithNull() {
    String text1 = null;
    String text2 = null;

    boolean result = myAnagram.isAnagram(text1, text2);

    assertFalse(result);
  }


  @Test
  public void testSortCharArrayWithMixedAndLowerCaseLetters() {
    String myText = "HeLLo";
    String myText2 = "greenfox";
    char[] expectedResult = {'e', 'h', 'l', 'l', 'o'};
    char[] expectedResult2 = {'e', 'e', 'f', 'g', 'n', 'o', 'r', 'x'};

    char[] result = myAnagram.sortCharArray(myText);
    char[] result2 = myAnagram.sortCharArray(myText2);

    assertArrayEquals(expectedResult, result);
    assertArrayEquals(expectedResult2, result2);
  }

  @Test
  public void testSortCharArrayWithEmpty() {
    String myText = "";
    char[] expectedResult = {};

    char[] result = myAnagram.createCharArray(myText);

    assertArrayEquals(expectedResult, result);
  }

  @Test
  public void testSortCharArrayWithNull() {
    String myText = null;
    char[] expectedResult = null;

    char[] result = myAnagram.createCharArray(myText);

    assertArrayEquals(expectedResult, result);
  }

  @Test
  public void testCreateCharArrayWithMixedAndLowerCaseLetters() {
    String myText = "HELLo";
    String myText2 = "greenfox";
    char[] expectedResult = {'h','e', 'l', 'l', 'o'};
    char[] expectedResult2 = {'g', 'r', 'e', 'e', 'n', 'f', 'o', 'x'};

    char[] result = myAnagram.createCharArray(myText);
    char[] result2 = myAnagram.createCharArray(myText2);

    assertArrayEquals(expectedResult, result);
    assertArrayEquals(expectedResult2, result2);
  }

  @Test
  public void testCreateCharArrayWithEmpty() {
    String myText = "";
    char[] expectedResult = {};

    char[] result = myAnagram.createCharArray(myText);

    assertArrayEquals(expectedResult, result);
  }

  @Test
  public void testCreateCharArrayWithNull() {
    String myText = null;
    char[] expectedResult = null;

    char[] result = myAnagram.createCharArray(myText);

    assertArrayEquals(expectedResult, result);
  }
}
