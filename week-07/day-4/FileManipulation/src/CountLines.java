import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountLines {
  public static void main(String[] args) {
    String fileName = "my-file.txt";
    countLinesInFile(fileName);
  }

  public static void countLinesInFile(String file) {
    Path filePath = Paths.get("src/" + file);
    List<String> lines = new ArrayList<>();
    int linesNumber = 0;
    try {
      lines = Files.readAllLines(filePath);
      for (int i = 0; i < lines.size(); i++) {
        linesNumber++;
      }
      System.out.println("Number of lines in the file: " + linesNumber);
    } catch (IOException e) {
      System.out.println("0");
    }
  }
}
