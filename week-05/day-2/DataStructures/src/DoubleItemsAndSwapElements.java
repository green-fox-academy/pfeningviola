import java.util.ArrayList;
import java.util.Arrays;

public class DoubleItemsAndSwapElements {
    public static void main(String[] args) {
        //DoubleItems
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        ArrayList<Integer> doubleList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            doubleList.add(i, (numList.get(i) * 2));
        }
        System.out.println(doubleList);

        //Swap Elements
        ArrayList<String> abc = new ArrayList<>(Arrays.asList("first", "second", "third"));
        String toSwap = abc.get(2);
        abc.set(2, abc.get(0));
        abc.set(0, toSwap);
        System.out.println(abc);
    }
}
