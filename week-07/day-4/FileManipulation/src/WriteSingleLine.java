import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteSingleLine {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("Viola");
    try {
      Path filePath = Paths.get("src/file-my.txt");
      Files.write(filePath, names);
    } catch (IOException e) {
      System.out.println("Unable to write file: file-my.txt");
    }
  }
}
