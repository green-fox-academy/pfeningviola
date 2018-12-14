import java.util.HashMap;

public class CountLetters {

  public HashMap<Character, Integer> countLettersInString(String text) {
    if (text == null) {
      return  new HashMap<Character, Integer>();
    }

    HashMap<Character, Integer> letters = new HashMap<>();
    for (int i = 0; i < text.length(); i++) {
      if (!letters.containsKey(text.charAt(i))) {
        letters.put(text.charAt(i), 1);
      } else {
        letters.put(text.charAt(i), letters.get(text.charAt(i)) + 1);
      }
    }
    return letters;
  }
}
