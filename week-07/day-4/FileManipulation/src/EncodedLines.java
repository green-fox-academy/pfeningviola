import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EncodedLines {
  public static void main(String[] args) {
    String fileName = "encoded-lines.txt";
    decryptText(fileName);
  }

  public static void decryptText(String file) {
    ArrayList<String> fileContent = new ArrayList<>();
    ArrayList<String> decryptedText = new ArrayList<>();

    try {
      fileContent = (ArrayList<String>) Files.readAllLines(Paths.get("src/" + file));
    } catch (IOException e){
      System.out.println("Something went wrong with the file.");
    }

    for (int i = 0; i < fileContent.size(); i++) {
      char[] line = fileContent.get(i).toCharArray();

      for (int j = 0; j < line.length; j++) {
        line[j]--;
      }
      decryptedText.add(String.valueOf(line));
    }

    for (String lines : decryptedText) {
      System.out.println(lines);
    }
  }
}
