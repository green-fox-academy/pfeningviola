import java.util.ArrayList;
import java.util.Arrays;

public class First6ArraysExercises {
    public static void main(String[] args) {
        //Third
        ArrayList<Integer> q = new ArrayList<>(Arrays.asList(4, 5, 6, 7));
        System.out.println(q.get(2));

        //CompareLength
        ArrayList<Integer> p1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> p2 = new ArrayList<>(Arrays.asList(4, 5));
        if (p1.size() > p2.size()) {
            System.out.println("p1 has more elements");
        } else if (p2.size() < p1.size()) {
            System.out.println("p2 has more elements");
        } else {
            System.out.println("p1 has as many elements as p2");
        }

        //SumElements
        ArrayList<Integer> r = new ArrayList<>(Arrays.asList(54, 23, 66, 12));
        System.out.println(r.get(1) + r.get(2));

        //ChangeElements
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 5, 6));
        s.set(s.indexOf(8), 4);
        System.out.println(s.get(3));

        //IncrementElements
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        t.set(2, (t.get(2) + 1));
        System.out.println(t.get(2));

        //PrintElements
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(4, 5, 6, 7));
        System.out.println(numbers);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j = 0; j < numbers.size(); j++) {
            System.out.print(numbers.get(j) + " ");
        }
    }
}
