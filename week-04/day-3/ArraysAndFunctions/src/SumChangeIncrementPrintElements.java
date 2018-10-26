import java.util.Arrays;

public class SumChangeIncrementPrintElements {

    public static void main(String[] args) {
        //Sum Elements
        int[] r = {54, 23, 66, 12};
        System.out.println(r[1] + r[2]);

        //Change Element
        int[] s = {1, 2, 3, 8, 5, 6};
        s[3] = 4;
        System.out.println(s[3]);

        //Change Element 2
        int[] s2 = {1, 2, 3, 8, 5, 6};
        for (int g = 0; g < s2.length; g++) {
            if (s2[g] == 8) {
                s2[g] = 4;
            }
        }
        System.out.println(s2[3]);

        //Increment Element
        int[] t = {1, 2, 3, 4, 5};
        t[2] ++;
        System.out.println(t[2]);

        //Print Elements
        int[] numbers = {4, 5, 6, 7};
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }
}
