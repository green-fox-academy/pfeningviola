import java.util.Arrays;

public class ThirdAndCompareLength {

    public static void main(String[] args) {
        //Third
        int[] q = {4, 5, 6, 7};
        System.out.println(q[2]);

        //Compare Length
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5};
        if (p2.length > p1.length) {
            System.out.println("p2 has more elements: " + Arrays.toString(p2));
        } else {
            System.out.println("p1 has more elements: " + Arrays.toString(p1));
        }
    }
}
