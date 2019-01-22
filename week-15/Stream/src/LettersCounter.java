import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LettersCounter {
  public static void main(String[] args) {
    String word = "almafa";
    ArrayList<Character> letters = makeListfromCharacters(word);
    System.out.println(letters.stream()
        .collect(Collectors.groupingBy(p -> p,
        Collectors.counting())));


    Map<String, Long> frequency = Arrays.stream(word.split(""))
        .collect(Collectors.groupingBy(p -> p,
            Collectors.counting()));
    System.out.println(frequency);

    Map<Character, Long> frequency2 = letters.stream()
        .collect(Collectors.groupingBy(p -> p,
            Collectors.counting()));
    System.out.println(frequency2);
  }

  public static ArrayList<Character> makeListfromCharacters(String word) {
    ArrayList<Character> letters = new ArrayList<>();
    for (char letter : word.toCharArray()){
      letters.add(letter);
    }
    return letters;
  }
}
