import java.util.ArrayList;
import java.util.Arrays;

public class SumAllAndReverseList {
    public static void main(String[] args) {
        //SumAllElements
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        int sum = 0;
        for (int i = 0; i < ai.size(); i++) {
            sum = sum + ai.get(i);
        }
        System.out.println("Sum of the elements: " + sum);

        //ReverseList
        ArrayList<Integer> aj = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        ArrayList<Integer> ajReversed = new ArrayList<>();
        for (int j = 0; j < aj.size(); j++) {
            ajReversed.add(j, aj.get(aj.size() - 1 - j));
        }
        System.out.println(ajReversed);
    }
}
