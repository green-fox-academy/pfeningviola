import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteMultipleLines {
  public static void main(String[] args) {
    String filePath = "src/lines.txt";
    String word = "apple";
    int number = 5;
    writeLines (filePath, word, number);
  }

  public static void writeLines (String filePath, String word, int number) {
    ArrayList<String> fileContent = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      fileContent.add(i, word);
    }
    try {
      Path path = Paths.get(filePath);
      Files.write(path, fileContent);
    } catch (IOException e) {

    }
  }
}
