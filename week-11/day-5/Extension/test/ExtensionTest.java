import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExtensionTest {

  Extension extension = new Extension();

  @Test
  public void testAdd_2and3is5() {
    assertEquals(5, extension.add(2, 3));
  }

  @Test
  public void testAdd_1and4is5() {
    assertEquals(5, extension.add(1, 4));
  }

  @Test
  public void testAdd_2and4is6() {
    int a = 2;
    int b = 4;
    int expectedResult = 6;

    int result = extension.add(a, b);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testAdd_WithNegativeNumbers() {
    int a = -2;
    int b = -4;
    int a2 = -2;
    int b2 = 4;
    int expectedResult = -6;
    int expectedResult2 = 2;

    int result = extension.add(a, b);
    int result2 = extension.add(a2, b2);

    assertEquals(expectedResult, result);
    assertEquals(expectedResult2, result2);
  }

  @Test
  public void testMaxOfThree_first() {
    assertEquals(5, extension.maxOfThree(5, 4, 3));
  }

  @Test
  public void testMaxOfThree_third() {
    assertEquals(5, extension.maxOfThree(3, 4, 5));
  }

  @Test
  public void testMaxOfThree_second() {
    int a = 2;
    int b = 5;
    int c = 4;
    int expectedResult = 5;

    int result = extension.maxOfThree(a, b, c);
    assertEquals(expectedResult, result);
  }

  @Test
  public void testMaxOfThreeWithNegativeNumbers() {
    int a = -5;
    int b = -2;
    int c = -4;
    int expectedResult = -2;

    int result = extension.maxOfThree(a, b, c);
    assertEquals(expectedResult, result);
  }

  @Test
  public void testMedian_four() {
    assertEquals(5, extension.median(Arrays.asList(7,5,3,5)));
  }

  @Test
  public void testMedian_five() {
    assertEquals(3, extension.median(Arrays.asList(1,2,3,4,5)));
  }

  @Test
  public void testMedianWithUnorderedList() {
    List<Integer> numbers = new ArrayList(Arrays.asList(7, 1, 8, 5));
    int expectedResult = 6;

    int result = extension.median(numbers);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testMedianWithNull() {
    List<Integer> numbers = null;
    int expectedResult = 0;

    int result = extension.median(numbers);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testIsVowel_a() {
    assertTrue(extension.isVowel('a'));
  }

  @Test
  public void testIsVowel_u() {
    assertTrue(extension.isVowel('u'));
  }

  @Test
  public void testTranslate_bemutatkozik() {
    assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
  }

  @Test
  public void testTranslate_lagopus() {
    assertEquals("lavagovopuvus", extension.translate("lagopus"));
  }

  @Test
  public void testTranslate_koala() {
    String word = "koala";
    String expectedResult = "kovoavalava";

    String result = extension.translate(word);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testTranslateWithNull() {
    String word = null;
    String expectedResult = null;

    String result = extension.translate(word);

    assertEquals(expectedResult, result);
  }
}
