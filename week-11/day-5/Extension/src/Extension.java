import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Extension {
  public int add(int a, int b) {
    return a + b;
  }

  public int maxOfThree(int a, int b, int c) {
    int max = 0;
    if (a > b) {
      max = a;
    }
    if (a < c) {
      max = c;
    }
    if (b > c) {
      max = b;
    }
      return max;
  }

  public float median(List<Integer> pool) {
    if ((pool == null) || (pool.size() == 0)) {
      return 0;
    }
    Collections.sort(pool);
    if (pool.size() % 2 == 1) {
      return pool.get((pool.size() - 1) / 2);
    } else {
      return (pool.get(pool.size() / 2) + pool.get((pool.size() / 2) - 1)) / 2;
    }
  }

  public boolean isVowel(char c) {
    return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
  }

  public String translate(String hungarian) {
    if (hungarian == null) {
      return "";
    }
    StringBuilder teve = new StringBuilder(hungarian);
    int length = teve.length();
    for (int i = 0; i < length; i++) {
      char c = teve.charAt(i);
      if (isVowel(c)) {
          teve.replace(i, i + 1, c + "v" + c);
          i += 2;
          length += 2;
      }
    }
    return teve.toString();
  }
}
