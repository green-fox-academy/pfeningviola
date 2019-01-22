import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStartsWith {
  public static void main(String[] args) {
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
    String letter = "n";

    System.out.println(findNamesStartingWithGivenLetter(cities, letter));
  }

  public static List<String> findNamesStartingWithGivenLetter(List<String> names, String startLetter) {
    return names.stream()
        .map(word -> word.toUpperCase())
        .filter(word -> word.startsWith(startLetter.toUpperCase()))
        .collect(Collectors.toList());
  }
}
