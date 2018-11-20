import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lottery {
  public static void main(String[] args) {
    String fileName = "lottery.txt";

    ArrayList<Integer> lotteryNumbers = getLotteryNumbers(fileName);
    HashMap<Integer, Integer> lotteryMapNumber = countFrequencyLotteryNumbers(lotteryNumbers);
    for (Map.Entry<Integer, Integer> number : lotteryMapNumber.entrySet()) {
      System.out.println(number.getKey() + " : " + number.getValue());
    }

    HashMap<Integer, Integer> topFiveNumber = checkTheMostCommonNumbers(lotteryMapNumber);

    for (Map.Entry<Integer, Integer> number : topFiveNumber.entrySet()) {
      System.out.println("Number " + number.getKey() + " has " + number.getValue() + " frequency.");
    }
  }

  public static ArrayList<Integer> getLotteryNumbers (String file) {
    ArrayList<String> fileContent = new ArrayList<>();
    ArrayList<Integer> lotteryNumbers = new ArrayList<>();

    try {
      fileContent = (ArrayList<String>) Files.readAllLines(Paths.get("src/" + file));
    } catch (IOException e) {
      System.out.println("Something went wrong with the file.");
    }

    for (int i = 0; i < fileContent.size(); i++) {
      String[] line = fileContent.get(i).split(";");
      for (int j = 0; j < 5; j++) {
        lotteryNumbers.add(Integer.valueOf(line[line.length - j - 1]));
      }
    }
    return lotteryNumbers;
  }

  public static HashMap<Integer, Integer> countFrequencyLotteryNumbers (ArrayList<Integer> lotteryNumbers) {
    HashMap<Integer, Integer> countLotteryNumbers = new HashMap<>();
    for (int i = 0; i < 90; i++) {
      countLotteryNumbers.put(i + 1, 0);
    }
    Integer hashMapValue = 0;


    for (int i = 0; i < lotteryNumbers.size(); i++) {
      if (countLotteryNumbers.containsKey(lotteryNumbers.get(i))) {
        hashMapValue = countLotteryNumbers.get(lotteryNumbers.get(i));
        hashMapValue++;
        countLotteryNumbers.put(lotteryNumbers.get(i), hashMapValue);
      }
    }
    return countLotteryNumbers;
  }

  public static HashMap<Integer, Integer> checkTheMostCommonNumbers (HashMap<Integer, Integer> lotteryMap) {
    HashMap<Integer, Integer> mostCommonNumbers = new HashMap<>();
    int maxValue = lotteryMap.get(1);

    for (int i = 0; i < 5; i++) {
      //maxValue = lotteryMap.get(i + 1);
      for (int j = 1; j < lotteryMap.size(); j++) {
        try {
          if (lotteryMap.get(j) > maxValue) {
            maxValue = lotteryMap.get(j);
          }
        } catch (NullPointerException np) {//(lotteryMap.get(j) = null) {

        }
      }

      for (Map.Entry<Integer, Integer> maxKey : lotteryMap.entrySet()) {
        if (maxKey.getValue() == maxValue) {
          mostCommonNumbers.put(maxKey.getKey(), maxValue);
          lotteryMap.remove(maxKey.getKey());
          break;
        }
      }
      maxValue = lotteryMap.get(1);
    }
    return mostCommonNumbers;
  }
}
