import java.util.Arrays;

public class Anagram {

  public boolean isAnagram(String text1, String text2) {
    char[] sortedLetters1 = sortCharArray(text1);
    char[] sortedLetters2 = sortCharArray(text2);

    return Arrays.equals(sortedLetters1, sortedLetters2);
  }

  public char[] sortCharArray(String text) {
    char[] letters = createCharArray(text);
    for (int i = 0; i < letters.length - 1; i++) {
      for (int j = i + 1; j < letters.length; j++) {
        if (letters[i] > letters[j]) {
          char toSwap = letters[j];
          letters[j] = letters[i];
          letters[i] = toSwap;
        }
      }
    }
    return letters;
  }

  public char[] createCharArray(String text) {
    return text.toLowerCase().toCharArray();
  }
}
