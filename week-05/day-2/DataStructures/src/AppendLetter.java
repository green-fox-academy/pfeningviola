import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppendLetter {
    public static void main(String[] args) {
        List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
        System.out.println(appendA2(far));
        System.out.println(appendA(far));
    }

    public static ArrayList appendA2(List list) {
        ArrayList<String> correctList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            correctList.add(i, (list.get(i) + "a"));
        }
        return correctList;
    }

    public static List appendA(List list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, (list.get(i) + "a"));
        }
        return list;
    }
}
