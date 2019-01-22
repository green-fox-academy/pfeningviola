import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringUppercase {
  public static void main(String[] args) {
    String word = "AlmaFa";
    System.out.println(findUppercaseLetters(word));
  }

  public static List<Character> findUppercaseLetters(String word) {
    ArrayList<Character> letters = makeListfromCharacters(word.toCharArray());

    List<Character> upperCaseLetters = letters.stream()
        .filter(Character::isUpperCase)
        .collect(Collectors.toList());
    return upperCaseLetters;
  }

  public static ArrayList<Character> makeListfromCharacters(char[] word) {
    ArrayList<Character> letters = new ArrayList<>();
    for (char letter : word){
      letters.add(letter);
    }
    return letters;
  }
}

