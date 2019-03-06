import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
  static Anagram anagram;

  @BeforeClass
  public static void before () {
    anagram = new Anagram();
  }

  @Test
  public void testIfLengthsIsEqual () {
    String word1 = "abc";
    String word2 = "bca";
    assertTrue(anagram.checkSize(word1, word2));
  }

  @Test
  public void testIfLengthsIsNotEqual () {
    String word1 = "abc";
    String word2 = "bcad";
    assertFalse(anagram.isAnagram(word1, word2));
  }

  @Test
  public void testIfTwoWordsAanagram () {
    String word1 = "baba";
    String word2 = "abba";
    assertTrue(anagram.isAnagram(word1, word2));
  }

  @Test
  public void testIfWordsAreNotAnagram () {
    String word1 = "babb";
    String word2 = "abba";
    assertFalse(anagram.isAnagram(word1, word2));
  }

  @Test
  public void testWithNull () {
    String word1 = null;
    String word2 = "bca";
    assertFalse(anagram.checkSize(word1, word2));
  }

  @Test
  public void testWithTwoEmptyStrings () {
    String word1 = "";
    String word2 = "";
    assertFalse(anagram.checkSize(word1, word2));
  }
}