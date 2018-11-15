import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
  public static void main(String[] args) {
    String fileName = "copyfile.txt";
    String fileToCopy = "flowers.txt";
    System.out.println("The copy was successful: " + copyFile(fileName, fileToCopy));
  }

  public static boolean copyFile (String fileName, String fileToCopy) {
    List<String> contentToCopy = new ArrayList<>();
    try {
      Path fileToCopyPath = Paths.get("src/" + fileToCopy);
      Path fileNamePath = Paths.get("src/" + fileName);
      contentToCopy = Files.readAllLines(fileToCopyPath);
      Files.write(fileNamePath, contentToCopy, StandardOpenOption.APPEND);
      return true;
    } catch (IOException e) {
      return false;
    }
  }
}
