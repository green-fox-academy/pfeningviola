import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReversedOrder {
  public static void main(String[] args) {
    String fileName = "reversed-order.txt";
    decryptReversedOrder(fileName);
  }

  public static void decryptReversedOrder(String file) {
    ArrayList<String> fileContent = new ArrayList<>();
    ArrayList<String> orderedText = new ArrayList<>();

    try {
      fileContent = (ArrayList<String>) Files.readAllLines(Paths.get("src/" + file));
    } catch (IOException e) {
      System.out.println("Something went wrong with the file.");
    }

    for (int i = 0; i < fileContent.size(); i++) {
      orderedText.add(fileContent.get(fileContent.size() - i - 1));
    }
    for (String line : orderedText) {
      System.out.println(line);
    }
  }
}
