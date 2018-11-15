import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
  public static void main(String[] args) {
    Path filePath = Paths.get("src/my-file.txt");
    try {
      List<String> flowers = Files.readAllLines(filePath);
      for (String i : flowers) {
        System.out.println(i);
      }
    } catch (IOException e) {
      System.out.println("Unable to read file: my-file.txt");
    }
  }
}
