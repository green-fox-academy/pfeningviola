import java.util.ArrayList;
import java.util.Arrays;

public class MatchMaking {
    public static void main(String[] args) {
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Claire","Kat","Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Tom","Todd","Neef","Jeff"));
        System.out.println(makingMatches(girls, boys));
    }

    public static ArrayList<String> makingMatches(ArrayList<String> list1, ArrayList<String> list2) {
        int matchesNumber = Math.min(list1.size(), list2.size());
        ArrayList<String> matches = new ArrayList<>();
        for (int i = 0; i < matchesNumber; i++) {
            matches.add(list1.get(i) + " and " + list2.get(i));
        }
        return matches;
    }
}

