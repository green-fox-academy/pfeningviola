import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterListToString {
  public static void main(String[] args) {
    List<CharSequence> letters = Arrays.asList("b", "a", "s", "l", "o", "h");
    String joinedCharacters = letters.stream()
        .collect(Collectors.joining(""));
    System.out.println(joinedCharacters);

    CharSequence joinedCaharcters2 = letters.stream()
        .reduce((word, letter) -> word + "" + letter).get();
    System.out.println(joinedCaharcters2);
  }
}
