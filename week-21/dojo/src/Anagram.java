import java.util.Arrays;

public class Anagram {
  public boolean checkSize(String word1, String word2) {
    if ((word1 == null) || (word2 == null)) {
      return false;
    }
    else if (word1.length() == 0 && word2.length() == 0) {
      return false;
    }
    else {
      return word1.length() == word2.length();
    }
  }

  public boolean isAnagram(String word1, String word2) {
    if (!checkSize(word1, word2)) {
      return false;
    } else {
      char[] array1 = word1.toCharArray();
      char[] array2 = word2.toCharArray();
      Arrays.sort(array1);
      Arrays.sort(array2);
      for (int i = 0; i < array1.length; i++) {
        if (array1[i] != array2[i]) {
          return false;
        }
      }
      return true;
    }
  }
}