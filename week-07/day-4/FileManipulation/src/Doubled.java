import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Doubled {
  public static void main(String[] args) {
    String fileName = "duplicated-chars.txt";
    decryptFile(fileName);
  }

  public static void decryptFile(String file) {
    ArrayList<String> fileContent = new ArrayList<>();
    ArrayList<String> decryptedContent = new ArrayList<>();

    try {
      Path filePath = Paths.get("src/" + file);
      fileContent = (ArrayList<String>) Files.readAllLines(filePath);
      System.out.println(fileContent.size());
    } catch (IOException e) {
      System.out.println("Something went wrong with the file");
    }

    for (int i = 0; i < fileContent.size(); i++) {
      StringBuilder toDelete = new StringBuilder(fileContent.get(i));

      for (int j = 0; j < toDelete.length() ; j++) {
        toDelete.deleteCharAt(j);
      }
      decryptedContent.add(toDelete.toString());
    }
    for (int i = 0; i < decryptedContent.size(); i++) {
      System.out.println(decryptedContent.get(i));
    }
  }
}
