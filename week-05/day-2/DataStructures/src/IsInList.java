import java.util.ArrayList;
import java.util.Arrays;

public class IsInList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        checkNums(list);
    }
    public static void checkNums (ArrayList<Integer> numbers) {
        ArrayList<Integer> checkList = new ArrayList<>(Arrays.asList(4,8,12,16));
        boolean contain = true;
        for (int i = 0; i < checkList.size(); i++) {
            if (numbers.contains(checkList.get(i))) {
                contain = true;
            } else {
                contain = false;
                break;
            }
        }
        System.out.println(contain);
        return;
    }
}
