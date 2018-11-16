import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Logs {
  public static void main(String[] args) {
    ArrayList<String> fileContent = new ArrayList<>();
    try {
      Path filePath = Paths.get("src/log.txt");
      fileContent = (ArrayList<String>) Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("There is a problem with the file.");
    }
    String[] uniqueIP = listUniqueIPs(fileContent);
    System.out.println(uniqueIP.length);
    for (String i : uniqueIP) {
      System.out.println(i);
    }
    countGetPostRatio(fileContent);
  }

  public static String[] listUniqueIPs(ArrayList<String> content) {
    ArrayList<String> ipAddresses = new ArrayList<>();
    for (int i = 0; i < content.size(); i++) {
      String[] splitRow = content.get(i).split(" ");
      ipAddresses.add(splitRow[8]);
    }

    for (int j = 0; j < ipAddresses.size() - 1; j++) {
      for (int g = j + 1; g < ipAddresses.size(); g++) {
        if (ipAddresses.get(j).compareTo(ipAddresses.get(g)) == 0) {
          ipAddresses.remove(j);
          j --;
        }
      }
    }
    String[] uniqueIP = new String[ipAddresses.size()];
    uniqueIP = (String[])ipAddresses.toArray(uniqueIP);
    return uniqueIP;
  }

  public static void countGetPostRatio(ArrayList<String> content) {
    double numberGet = 0;
    double numberPost = 0;
    ArrayList<String> splitContent = new ArrayList<>();
    for (int i = 0; i < content.size(); i++) {
      String[] splitRow = content.get(i).split(" ");
      splitContent.add(splitRow[11]);
    }

    for (int j = 0; j < splitContent.size(); j++) {
      if (splitContent.get(j).equalsIgnoreCase("get")) {
        numberGet ++;
      } else {
        numberPost ++;
      }
    }
    double getPostRatio = numberGet / numberPost;
    System.out.println("The Get / Post request ratio is " + getPostRatio);
  }
}
