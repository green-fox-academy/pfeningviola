import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReversedLines {
  public static void main(String[] args) {
    String fileName = "reversed-lines.txt";
    decryptReversedFile(fileName);
  }

  public static void decryptReversedFile(String file){
    ArrayList<String> fileContent = new ArrayList<>();

    try {
      fileContent = (ArrayList<String>) Files.readAllLines(Paths.get("src/" + file));
    } catch (IOException e) {
      System.out.println("Something went wrong with the file.");
    }

    for (int i = 0; i < fileContent.size(); i++) {
      StringBuilder rowToReverse = new StringBuilder(fileContent.get(i));
      rowToReverse.reverse();
      fileContent.set(i, rowToReverse.toString());
    }
    for (String line : fileContent) {
      System.out.println(line);
    }
  }
}
