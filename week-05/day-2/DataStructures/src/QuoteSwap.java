import java.util.ArrayList;
import java.util.Arrays;

public class QuoteSwap {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));
        quoteSwap(list);
    }

    public static void quoteSwap (ArrayList<String> words) {
        int toSwap = words.indexOf("do");
        int toSwap2 = words.indexOf("cannot");
        words.set(toSwap, "cannot");
        words.set(toSwap2, "do");
        for (String i : words) {
            System.out.print(i + " ");
        }
    }
}
