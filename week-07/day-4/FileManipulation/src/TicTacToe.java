import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TicTacToe {
  public static void main(String[] args) {
    String fileToCheck1 = "draw.txt";
    String fileToCheck2 = "win-x.txt";
    String fileToCheck3 = "win-o.txt";
    System.out.println(checkTheMatch(fileToCheck1));
    System.out.println(checkTheMatch(fileToCheck2));
    System.out.println(checkTheMatch(fileToCheck3));
  }

  public static String checkTheMatch(String fileName) {
    ArrayList<String> result = new ArrayList<>();
    boolean win = true;
    try {
      Path filePath = Paths.get("src/" + fileName);
      result = (ArrayList<String>) Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Something went wrong with the file.");
    }
    for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < result.size(); j++) {
        if (result.get(i).charAt(0) != result.get(i).charAt(j)) {
          win = false;
          break;
        }
      }
      if (win) {
        return String.valueOf(result.get(i).charAt(0));
      }

      win = true;
      for (int h = 0; h < result.size(); h++) {
        if (result.get(0).charAt(i) != result.get(h).charAt(i)) {
          win = false;
          break;
        }
      }
      if (win) {
        return String.valueOf(result.get(0).charAt(i));
      }
    }

    win = true;
    for (int i = 0; i < result.size(); i++) {
      if (result.get(0).charAt(0) != result.get(i).charAt(i)) {
        win = false;
        break;
      }
    }
    if (win) {
      return String.valueOf(result.get(0).charAt(0));
    }

    win = true;
    for (int g = 0; g < result.size(); g++) {
      if (result.get(0).charAt(result.size() - 1) != result.get(g).charAt(result.size() - 1 - g)) {
        win = false;
        break;
      }
    }
    if (win) {
      return String.valueOf(result.get(0).charAt(result.size() - 1));
    }
    return "draw";
  }
}

